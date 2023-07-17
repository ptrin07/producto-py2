package com.bestbank.productos.application.services;

import org.springframework.stereotype.Service;

import com.bestbank.productos.domain.model.Producto;
import com.bestbank.productos.domain.repository.ProductosRepository;
import com.bestbank.productos.domain.utils.TipoProducto;
import com.bestbank.productos.infrastructure.persistence.ProductosRepositoryImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase que proporciona servicios relacionados con la gestión de productos y 
 * extiende la implementación del repositorio "ProductosRepositoryImpl".
 * 
 */

@Service
public class ProductosService extends ProductosRepositoryImpl {

  protected ProductosService(ProductosRepository productosRepo) {
    super(productosRepo);
  }

  @Override
  public Mono<Long> countByTipoProductoAndCodigoPersonaAndIndEliminado(
      TipoProducto tipoProducto, String codigoPersona, Integer indEliminado) {
    return productosRepo.countByTipoProductoAndCodigoPersonaAndIndEliminado(tipoProducto, 
        codigoPersona, indEliminado);
  }

  @Override
  public Mono<Producto> findFirstByIdAndIndEliminado(String id,
      Integer indEliminado) {
    return productosRepo.findFirstByIdAndIndEliminado(id, indEliminado);
  }

  @Override
  public Flux<Producto> findAllByCodigoPersonaAndIndEliminado(
      String codigoPersona, Integer indEliminado) {
    return productosRepo.findAllByCodigoPersonaAndIndEliminado(codigoPersona, indEliminado);
  }

  @Override
  public Mono<Producto> save(Producto producto) {
    return productosRepo.save(producto);
  }

}
