package com.bestbank.productos.application.services;

import com.bestbank.productos.domain.model.Producto;
import com.bestbank.productos.domain.model.ProductoCartera;

import reactor.core.publisher.Mono;

/**
 * Clase abstracta que define un servicio especializado para la gestión de productos.
 * Las implementaciones concretas deben extender esta clase y proporcionar la 
 * lógica específica del servicio.
 *
 */
public abstract class ProductoServiceEspecial {
  
  protected final ProductoCartera carteraProp = new ProductoCartera();
  
  public abstract Mono<Producto> save(Producto producto);

}
