package com.eventsource.totvs.axon.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventsource.totvs.axon.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, String> {
	

}
