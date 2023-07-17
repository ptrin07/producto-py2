package com.bestbank.productos.application.dto.res;

import com.bestbank.productos.domain.utils.GrupoProducto;
import com.bestbank.productos.domain.utils.TipoCliente;
import com.bestbank.productos.domain.utils.TipoProducto;

import lombok.Data;

/**
 * Clase que representa la respuesta de un producto.
 */
@Data
public class ProductoRes {
  
  private String id;
  
  private GrupoProducto grupoProducto;
  
  private TipoProducto tipoProducto;
  
  private String codigoProducto;
  
  private String estado;
  
  private TipoCliente tipoCliente;
  
  private Integer maxOperacionesMes;
  
  private Integer minDiaMesOperacion;  
  

}
