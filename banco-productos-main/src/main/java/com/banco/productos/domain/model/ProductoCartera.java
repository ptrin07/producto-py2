package com.bestbank.productos.domain.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.bestbank.productos.domain.utils.GrupoProducto;
import com.bestbank.productos.domain.utils.TipoCliente;
import com.bestbank.productos.domain.utils.TipoProducto;

import lombok.Data;

/**
 * Clase que representa un producto de la cartera, relacionado con 
 * los productos ofrecidos por la entidad.
 */
@Data
public class ProductoCartera {
  
  @Id
  private String id;
  
  private double comision;
  
  private TipoCliente tipoCliente;
  
  private TipoProducto tipoProducto;
  
  private GrupoProducto grupoProducto;
  
  private Integer maxOperacionesMes;
  
  private Integer minDiaMesOperacion;
  
  private Double minSaldoMensual;
  
  private Integer maxProdPersonal;
  
  private Integer maxProdEmpresarial;
  
  private List<TipoProducto> reqPrevios;
  
  private Double costExtraOperacionesMes;
  
  private Double costMinSaldoMensual;
  

}
