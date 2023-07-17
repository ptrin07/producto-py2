package com.bestbank.productos.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bestbank.productos.domain.model.Producto;
import com.bestbank.productos.domain.utils.TipoProducto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz que define el repositorio de productos, que extiende ReactiveMongoRepository.
 * Proporciona métodos para acceder y gestionar los productos almacenados en una base de datos 
 * MongoDB de forma reactiva.
 *
 * @param <Producto> El tipo de entidad Producto.
 * @param <String>   El tipo de dato para el ID del producto.
 */
public interface ProductosRepository extends ReactiveMongoRepository<Producto, String> {
  
  Mono<Long> countByTipoProductoAndCodigoPersonaAndIndEliminado(TipoProducto tipoProducto,
      String codigoPersona, Integer indEliminado);
  
  Mono<Producto> findFirstByIdAndIndEliminado(String id, Integer indEliminado);
  
  Flux<Producto> findAllByCodigoPersonaAndIndEliminado(String codigoPersona, Integer indEliminado);

}