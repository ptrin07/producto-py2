package com.bestbank.productos.application.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bestbank.productos.application.utils.ApplicationConstants;
import com.bestbank.productos.application.utils.BankFnUtils;
import com.bestbank.productos.domain.model.Producto;
import com.bestbank.productos.domain.model.ProductoCartera;
import com.bestbank.productos.domain.model.Saldo;
import com.bestbank.productos.domain.utils.TipoCliente;
import com.bestbank.productos.domain.utils.TipoProducto;

import reactor.core.publisher.Mono;

/**
 * Clase que implementa un servicio especializado para la gestión de productos 
 * utilizando herramientas adicionales.
 * Extiende de la clase abstracta "ProductoServiceEspecial".
 */
public class ProductoServicioTool extends ProductoServiceEspecial {

  private ProductosService servProd;
  private ProductoCartera carteraProd;
  private SaldosService servSaldo;
  
  public void setServProd(ProductosService servProd) {
    this.servProd = servProd;
  }

  public void setCarteraProd(ProductoCartera carteraProd) {
    this.carteraProd = carteraProd;
  }
  
  public void setSerSaldo(SaldosService saldoService) {
    this.servSaldo = saldoService;
  }
  
  private Boolean reglaProductoPrevios(List<Producto> productos) {
    if (carteraProd.getReqPrevios().isEmpty()) {
      return true;
    } 
    List<TipoProducto> prodContratados = productos.stream()
        .map(Producto::getTipoProducto)
        .distinct()
        .toList(); 
    
    return prodContratados.containsAll(carteraProd.getReqPrevios());
  }
  
  private Boolean reglaMaxProductoPermitivo(List<Producto> productos) {
    Map<TipoProducto, Long> tipoProdContadorMap = productos.stream()
        .collect(Collectors.groupingBy(Producto::getTipoProducto, Collectors.counting()));
    Long cantidadProdEndCliente = tipoProdContadorMap
        .getOrDefault(carteraProd.getTipoProducto(), (long) 0);
    if (carteraProd.getTipoCliente() == TipoCliente.EMPRESARIAL) {
      return cantidadProdEndCliente < carteraProd.getMaxProdEmpresarial();
    } else {
      return  cantidadProdEndCliente < carteraProd.getMaxProdPersonal();
    }    
  }
  
  private Boolean reglasParaProductos(List<Producto> productos) {
    return reglaProductoPrevios(productos) && reglaMaxProductoPermitivo(productos);
    
  }

  @Override
  public Mono<Producto> save(Producto producto) {
    return servProd.findAllByCodigoPersonaAndIndEliminado(
        producto.getCodigoPersona(), ApplicationConstants.REGISTRO_NO_ELIMINADO).collectList()
        .filter(this::reglasParaProductos)
        .flatMap(permiteGuardar -> {
          return servProd.save(producto).flatMap(entidad -> {
            Saldo saldoCero = new Saldo();
            saldoCero.setCodControl(BankFnUtils.uniqueProductCode());
            saldoCero.setGrupoProdcuto(entidad.getGrupoProducto());
            saldoCero.setTipoProducto(entidad.getTipoProducto());
            saldoCero.setCodigoProducto(entidad.getId());
            saldoCero.setSaldoActual(0.00D);
            saldoCero.setIdPersona(entidad.getCodigoPersona());
            saldoCero.setFechaActualizacion(BankFnUtils.getDateTime());
            return servSaldo.save(saldoCero)
                .flatMap(saldoW -> {
                  return Mono.just(entidad);
                });
          });
        })
          .switchIfEmpty(Mono.error(
              new Throwable(String.format("%s Producto No Resgistrado, requistos no cumplidos", 
                  producto.getTipoProducto().getDescripcion()))
              )
          );
  }
}
