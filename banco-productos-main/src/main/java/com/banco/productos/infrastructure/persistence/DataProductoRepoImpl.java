package com.bestbank.productos.infrastructure.persistence;

import com.bestbank.productos.domain.model.ProductoCartera;
import com.bestbank.productos.domain.repository.DatabaseEmulatorRespo;
import com.bestbank.productos.domain.utils.TipoProducto;

import reactor.core.publisher.Mono;

/**
 *  Clase abstracta que proporciona una implementación base para el repositorio de
 *  datos de productos.Las implementaciones concretas deben extender esta clase y 
 *  proporcionar la lógica específica del 
 *  repositorio.
 */
public abstract class DataProductoRepoImpl {
  
  protected DatabaseEmulatorRespo carteraProdRep = new DatabaseEmulatorRespo(); 
  
  public abstract Mono<ProductoCartera> getValoresCarteraPorTipoId(TipoProducto tipoProducto);
      

}
