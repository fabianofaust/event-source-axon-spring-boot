package com.eventsource.totvs.axon.components;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.eventsource.totvs.axon.event.DeletePedidoEvent;
import com.eventsource.totvs.axon.event.PedidoCreatedEvent;
import com.eventsource.totvs.axon.event.PedidoItensUpdateEvent;
import com.eventsource.totvs.axon.exception.ObjectNotFoundException;
import com.eventsource.totvs.axon.model.Pedido;
import com.eventsource.totvs.axon.repository.PedidoRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@ProcessingGroup("amqpEvents")
public class PedidoEventProcessor {

 
    private final PedidoRepository Repository;

    @EventHandler
    public void on(PedidoCreatedEvent event) {
        Pedido pedido = Repository.save(new Pedido(event.getId(), event.getNumeroPedido(), event.getUser(), event.getItens(), event.getEnderecoEntrega()));
  
    }
    
    @EventHandler
    public void on(PedidoItensUpdateEvent event) {
    	   var pedido = Repository.findById(event.getId())
                   .orElseThrow(ObjectNotFoundException::new);
    	   pedido.setItens(event.getItens());
        Pedido rPedido = Repository.save(pedido); 
    }
    
    @EventHandler
    public void on(DeletePedidoEvent event) {
        Repository.deleteById(event.getId());
       
    }
}
