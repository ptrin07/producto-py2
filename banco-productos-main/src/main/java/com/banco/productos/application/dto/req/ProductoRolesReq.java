package com.bestbank.productos.application.dto.req;

import com.bestbank.productos.domain.utils.TipoPersonaRol;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa una solicitud para asignar persona y roles a un producto.
 */
@Data
public class ProductoRolesReq {
  
  @NotEmpty
  private String codigoPersona;
  
  
  @NotNull
  private TipoPersonaRol rol;
  

}
