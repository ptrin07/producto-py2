package com.bestbank.productos.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bestbank.productos.domain.model.Saldo;

/**
 * Interfaz que define el repositorio de saldos, que extiende ReactiveMongoRepository.
 * Proporciona métodos para acceder y gestionar los saldos almacenados en una base de datos 
 * MongoDB de forma reactiva.
 *
 * @param <Saldo>   El tipo de entidad Saldo.
 * @param <String>  El tipo de dato para el ID del saldo.
 */

public interface SaldoRespository extends ReactiveMongoRepository<Saldo, String> {

}
