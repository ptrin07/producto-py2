package com.bestbank.productos.application.utils;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Clase que proporciona funciones y utilidades relacionadas con operaciones bancarias.
 */
public class BankFnUtils {
  
  public static String uniqueProductCode() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }
  
  public static java.sql.Timestamp getDateTime() {
    return java.sql.Timestamp.valueOf(LocalDateTime.now());
  }
  
}
