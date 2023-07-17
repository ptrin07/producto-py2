package com.bestbank.productos.presentation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestbank.productos.application.ProductosApplication;
import com.bestbank.productos.application.dto.req.ProductoModReq;
import com.bestbank.productos.application.dto.req.ProductoReq;
import com.bestbank.productos.application.dto.res.ProductoRes;
import com.bestbank.productos.application.dto.res.ProductoRolesRes;
import com.bestbank.productos.domain.model.PersonaRoles;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase que proporciona servicios REST relacionados con la gestión de productos.
 */
@RestController
@Validated
@RequestMapping("/v1/productos")
public class ProductosRestService {

  
  private ProductosApplication servProdApp;
  
  
  
  public ProductosRestService(ProductosApplication servProdApp) {
    super();
    this.servProdApp = servProdApp;
  }

  /**
   * Crea un nuevo producto con la información proporcionada.
   *
   * @param producto la información del producto a crear
   * @return un Mono que emite el objeto ProductoRes resultante
   */
  @PostMapping("")
  public Mono<ProductoRes> postProduct(@Valid @RequestBody ProductoReq producto) {
    return servProdApp.postProduct(producto);
  }
  
  /**
   * Obtiene un producto por su identificador.
   *
   * @param idProducto el identificador del producto
   * @return un Mono que emite el objeto ProductoRes correspondiente al ID proporcionado
   */
  @GetMapping("/{idProducto}")
  public Mono<ProductoRes> getProductById(@PathVariable(name = "idProducto") String idProducto){
    return servProdApp.getProductById(idProducto);
  }
  
  /**
   * Obtiene todos los productos asociados a un cliente específico.
   *
   * @param idPersona el identificador de la persona (cliente)
   * @return un Flux que emite objetos ProductoRes relacionados al cliente
   */
  @GetMapping("/{idPersona}/cliente")
  public Flux<ProductoRes> getAllProductByClient(
      @PathVariable(name = "idPersona") String idPersona) {
    return servProdApp.getAllProductByClientId(idPersona);
  }
  
  /**
   * Actualiza un producto por su identificador.
   *
   * @param producto la información actualizada del producto
   * @param idProducto el identificador del producto a actualizar
   * @return un Mono que emite el objeto ProductoRes resultante
   */

  @PutMapping("/{idProducto}")
  public Mono<ProductoRes> putProductById(
      @RequestBody ProductoModReq producto, 
      @PathVariable(name = "idProducto") String idProducto) {
    return servProdApp.putProduct(idProducto, producto);
  }
  
  /**
   * Elimina un producto por su identificador.
   *
   * @param idProducto el identificador del producto a eliminar
   * @return un Mono que emite el objeto ProductoRes correspondiente al producto eliminado
   */
  @DeleteMapping("/{idProducto}")
  public Mono<ProductoRes> delProductById(
      @PathVariable(name = "idProducto") String idProducto) {
    return servProdApp.delProductById(idProducto);
  }
  
  /**
   * Obtiene un Producto y los Codigos Personas y Roles dentro de la cuenta.
   *
   * @param idProducto el identificador del producto a consultar
   * @return un Mono que emite el objeto ProductoRes correspondiente al producto
   */
  @GetMapping("/{idProducto}/personas")
  public Mono<ProductoRolesRes> getPersonaRolesByProductId(
      @PathVariable(name = "idProducto") String idProducto) {
    return servProdApp.getPersonaRolesByProductId(idProducto);
  }
  
  
  /**
   * Obtiene un Producto y los Codigos Personas y Roles dentro de la cuenta.
   * Luego de Eliminar una Persona
   *
   * @param idProducto el identificador del producto a modificar
   * @param codePersona el identificador cliente a eliminar
   * @return un Mono que emite el objeto ProductoRes correspondiente al producto modificado
   */ 
  @DeleteMapping("/{idProducto}/personas/{idPersona}")
  public Mono<ProductoRolesRes> delPersonaRolesByProductIdAndCodePersona(@PathVariable(name="idProducto") String idProducto, @PathVariable(name="idPersona") String codePersona){
    return servProdApp.delPersonaRolesByProductIdAndCodePersona(idProducto, codePersona);
  }
  
  /**
   * Obtiene un Producto y los Codigos Personas y Roles dentro de la cuenta.
   * Luego de Adicionar a una persona
   *
   * @param idProducto el identificador del producto a modificar
   * @param PersonaRoles el objeto de la persona Roles a adicionar
   * @return un Mono que emite el objeto ProductoRes correspondiente al producto modificado
   */ 
  @PostMapping("/{idProducto}/personas")
  public Mono<ProductoRolesRes> postPersonaRolesByProductIdAndRolePersona(@PathVariable(name="idProducto") String idProducto, @Valid @RequestBody PersonaRoles personaRol){
    return servProdApp.addPersonaRolesByProductIdAndRolePersona(idProducto, personaRol);
  }
  
  
}
