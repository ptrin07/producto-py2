package com.bestbank.productos.application.dto.req;


import com.bestbank.productos.domain.utils.TipoProducto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa una solicitud para crear o actualizar un producto.
 */
@Data
public class ProductoReq {
  
  @NotEmpty(message = "Se Requiere codigo persona")
  private String codigoPersona;
  
  @NotNull(message = "Se Requiere tipo producto")
  private TipoProducto tipoProducto;
  
  
}
