package com.bestbank.productos.application.dto.req;

import java.util.Optional;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Clase que representa la solicitud de modificación de un producto.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductoModReq extends ProductoReq {

  private Optional<Double> comision;
  
  private Optional<Integer> maximoOperacionesMes;
  
  private Optional<Integer> minDiaMesOperacion; 
  
}
