package com.bestbank.productos.domain.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bestbank.productos.domain.utils.GrupoProducto;
import com.bestbank.productos.domain.utils.TipoProducto;

/**
 * Clase que simula un repositorio de base de datos para fines de emulación o pruebas.
 */
public class DatabaseEmulatorRespo {
  
  private Map<String, Map<String, Object>> database;

  public DatabaseEmulatorRespo() {
    database = new HashMap<>();
    initializeData();
  }

  private void initializeData() {
    
    // CTAA
    Map<String, Object> ctaaData = new HashMap<>();
    ctaaData.put("comision", 0.0D);
    ctaaData.put("maxOperacionesMes", 4);
    ctaaData.put("costExtraOperacionesMes", 16.00D);
    ctaaData.put("minDiaMesOperacion", 0);
    ctaaData.put("tipoProducto", TipoProducto.CTAA);
    ctaaData.put("grupoProducto", GrupoProducto.PASIVOS);
    ctaaData.put("minSaldoMensual", 0.00D);
    ctaaData.put("maxProdPersonal", 1);
    ctaaData.put("costMinSaldoMensual", 0.0D);
    ctaaData.put("maxProdEmpresarial", 0);
    ctaaData.put("reqPrevios", new ArrayList<TipoProducto>());      
    database.put("CTAA", ctaaData);
      

    // CTCC
    Map<String, Object> ctccData = new HashMap<>();
    ctccData.put("comision", 0.0D);
    ctccData.put("maxOperacionesMes", Integer.MAX_VALUE);
    ctccData.put("costExtraOperacionesMes", 0.00D);
    ctccData.put("minDiaMesOperacion", 0);
    ctccData.put("tipoProducto", TipoProducto.CTCC);
    ctccData.put("grupoProducto", GrupoProducto.PASIVOS);
    ctccData.put("minSaldoMensual", 0.00D);
    ctccData.put("costMinSaldoMensual", 0.00D);
    ctccData.put("maxProdPersonal", 1);
    ctccData.put("maxProdEmpresarial", Integer.MAX_VALUE);
    ctccData.put("reqPrevios", new ArrayList<TipoProducto>());
    database.put("CTCC", ctccData);

    // DPFJ
    Map<String, Object> dpfjData = new HashMap<>();
    dpfjData.put("comision", 0.0D);
    dpfjData.put("maxOperacionesMes", Integer.MAX_VALUE);
    dpfjData.put("costExtraOperacionesMes", 0.00D);
    dpfjData.put("minDiaMesOperacion", 28);
    dpfjData.put("tipoProducto", TipoProducto.DPFJ);
    dpfjData.put("grupoProducto", GrupoProducto.PASIVOS);
    dpfjData.put("minSaldoMensual", 0.00D);
    dpfjData.put("costMinSaldoMensual", 0.00D);
    dpfjData.put("maxProdPersonal", 1);
    dpfjData.put("maxProdEmpresarial", 0);
    dpfjData.put("reqPrevios", new ArrayList<TipoProducto>());
    database.put("DPFJ", dpfjData);

    // CRPS
    Map<String, Object> crpsData = new HashMap<>();
    crpsData.put("comision", 0.0D);
    crpsData.put("maxOperacionesMes", Integer.MAX_VALUE);
    crpsData.put("costExtraOperacionesMes", 0.00D);
    crpsData.put("minDiaMesOperacion", 28);
    crpsData.put("tipoProducto", TipoProducto.CRPS);
    crpsData.put("grupoProducto", GrupoProducto.ACTIVOS);
    crpsData.put("minSaldoMensual", 0.00D);
    crpsData.put("costMinSaldoMensual", 0.00D);
    crpsData.put("maxProdPersonal", 0);
    crpsData.put("maxProdEmpresarial", 0);
    crpsData.put("reqPrevios", new ArrayList<TipoProducto>());
    database.put("CRPS", crpsData);

    // CREM
    Map<String, Object> crenData = new HashMap<>();
    crenData.put("comision", 0.0D);
    crenData.put("maxOperacionesMes", Integer.MAX_VALUE);
    crenData.put("costExtraOperacionesMes", 0.00D);
    crenData.put("minDiaMesOperacion", 0);
    crenData.put("tipoProducto", TipoProducto.CREM);
    crenData.put("grupoProducto", GrupoProducto.ACTIVOS);
    crenData.put("minSaldoMensual", 0.00D);
    crenData.put("costMinSaldoMensual", 0.00D);
    crenData.put("maxProdPersonal", 0);
    crenData.put("maxProdEmpresarial", Integer.MAX_VALUE);
    crenData.put("reqPrevios", new ArrayList<TipoProducto>());
    database.put("CREM", crenData);

    // CRTC
    Map<String, Object> crtcData = new HashMap<>();
    crtcData.put("comision", 0.0D);
    crtcData.put("maxOperacionesMes", Integer.MAX_VALUE);
    crtcData.put("costExtraOperacionesMes", 0.00D);
    crtcData.put("minDiaMesOperacion", 0);
    crtcData.put("tipoProducto", TipoProducto.CRTC);
    crtcData.put("grupoProducto", GrupoProducto.ACTIVOS);
    crtcData.put("minSaldoMensual", 0.00D);
    crtcData.put("costMinSaldoMensual", 0.00D);
    crtcData.put("maxProdPersonal", Integer.MAX_VALUE);
    crtcData.put("maxProdEmpresarial", Integer.MAX_VALUE);
    crtcData.put("reqPrevios", new ArrayList<TipoProducto>());
    database.put("CRTC", crtcData);

    // CTPVIP
    Map<String, Object> ctvipData = new HashMap<>();
    ctvipData.put("comision", 0.0D);
    ctvipData.put("maxOperacionesMes", 20);
    ctvipData.put("costExtraOperacionesMes", 16.00D);
    ctvipData.put("minDiaMesOperacion", 0);
    ctvipData.put("tipoProducto", TipoProducto.CRTC);
    ctvipData.put("grupoProducto", GrupoProducto.PASIVOS);
    ctvipData.put("minSaldoMensual", 500.0D);
    ctvipData.put("costMinSaldoMensual", 5.00D);
    ctvipData.put("maxProdPersonal", Integer.MAX_VALUE);
    ctvipData.put("maxProdEmpresarial", 0);
    List<TipoProducto> ctvipPrevios = Arrays.asList(TipoProducto.CRTC);
    ctvipData.put("reqPrevios", ctvipPrevios);
    database.put("CTPVIP", ctvipData);
      
    // CTEPIME
    Map<String, Object> ctepymeData = new HashMap<>();
    ctepymeData.put("comision", 0.0D);
    ctepymeData.put("maxOperacionesMes", 20);
    ctepymeData.put("costExtraOperacionesMes", 16.00D);
    ctepymeData.put("minDiaMesOperacion", 0);
    ctepymeData.put("tipoProducto", TipoProducto.CRTC);
    ctepymeData.put("grupoProducto", GrupoProducto.PASIVOS);
    ctepymeData.put("minSaldoMensual", 0.00D);
    ctepymeData.put("costMinSaldoMensual", 0.00D);
    ctepymeData.put("maxProdPersonal", 0);
    ctepymeData.put("maxProdEmpresarial", Integer.MAX_VALUE);
    List<TipoProducto> ctepymePrevios = Arrays.asList(TipoProducto.CRTC, TipoProducto.CTCC);
    ctepymeData.put("reqPrevios", ctepymePrevios);
    database.put("CTEPIME", ctvipData);
      
  }

  public Map<String, Object> getModelData(String modelName) {
    return database.get(modelName);
  }

  /**
   * Actualiza los datos del modelo identificado por el nombre de modelo y 
   * la clave con el valor proporcionado.
   *
   * @param modelName El nombre del modelo a actualizar.
   * @param key       La clave del dato a actualizar.
   * @param value     El nuevo valor para el dato a actualizar.
   */
  public void updateModelData(String modelName, String key, Object value) {
    Map<String, Object> modelData = database.get(modelName);
    if (modelData != null) {
      modelData.put(key, value);
    }
  }

  /**
   * Elimina el modelo identificado por el nombre de modelo.
   *
   * @param modelName El nombre del modelo a eliminar.
   */
  public void deleteModel(String modelName) {
    database.remove(modelName);
  }

}
