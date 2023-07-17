package com.bestbank.productos.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bestbank.productos.domain.utils.GrupoProducto;
import com.bestbank.productos.domain.utils.TipoCliente;
import com.bestbank.productos.domain.utils.TipoProducto;

import lombok.Data;

/**
 * Representa un producto.
 * La clase Producto es una entidad que se mapea a la colección "productos" en la base de datos.
 */
@Document(collection = "productos")
@Data
public class Producto implements Serializable {

  private static final long serialVersionUID = -3885933279296836915L;
  
  @Id
  private String id;
  
  private GrupoProducto grupoProducto;
  
  private TipoProducto tipoProducto;
  
  private String codigoProducto;
  
  private String codigoPersona;
  
  private double comision;
  
  private Integer maxOperacionesMes;
  
  private Integer minDiaMesOperacion;
  
  private Integer indEliminado;
  
  private String estado; 
  
  private TipoCliente tipoCliente;
  
  private Double costExtraOperacionesMes;
  
  private Double minSaldoMensual;
  
  private Double costMinSaldoMensual;
  
  private List<PersonaRoles> personaRoles = new ArrayList<>();
  
  private Date fechaCreacion;
  
  private Date fechaActualizacion;
  

}