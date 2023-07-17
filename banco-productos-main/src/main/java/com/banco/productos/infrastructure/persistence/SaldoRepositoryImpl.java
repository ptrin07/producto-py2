package com.bestbank.productos.infrastructure.persistence;

import com.bestbank.productos.domain.model.Saldo;
import com.bestbank.productos.domain.repository.SaldoRespository;

import reactor.core.publisher.Mono;

/**
 * Clase abstracta que proporciona una implementación base para el repositorio de saldos.
 * Las implementaciones concretas deben extender esta clase y proporcionar la lógica específica 
 * del repositorio.
 * 
 */

public abstract class SaldoRepositoryImpl {
  
  protected final SaldoRespository saldoRepo;

  protected SaldoRepositoryImpl(SaldoRespository saldoRepo) {
    super();
    this.saldoRepo = saldoRepo;
  }
  
  public abstract Mono<Saldo> save(Saldo primerSaldo);
  

}
