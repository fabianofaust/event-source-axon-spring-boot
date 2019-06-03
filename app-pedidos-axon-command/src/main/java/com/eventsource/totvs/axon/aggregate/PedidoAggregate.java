package com.eventsource.totvs.axon.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.eventsource.totvs.axon.command.CreatePedidoCommand;
import com.eventsource.totvs.axon.command.RemovePedidoCommand;
import com.eventsource.totvs.axon.command.UpdateEnderecoPedidoCommand;
import com.eventsource.totvs.axon.command.UpdateItensPedidoCommand;
import com.eventsource.totvs.axon.command.UpdatePedidoCommand;
import com.eventsource.totvs.axon.event.ItemRemovedEvent;
import com.eventsource.totvs.axon.event.PedidoCreatedEvent;
import com.eventsource.totvs.axon.event.PedidoEnderecoUpdateEvent;
import com.eventsource.totvs.axon.event.PedidoItensUpdateEvent;
import com.eventsource.totvs.axon.event.PedidoUpdatedEvent;
import com.eventsource.totvs.axon.model.Endereco;
import com.eventsource.totvs.axon.model.Item;
import com.eventsource.totvs.axon.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Aggregate
@NoArgsConstructor
public class PedidoAggregate {
	
	 @AggregateIdentifier
	 	private String id;
	    private Integer numeroPedido;
	    private User user;
	    private List<Item> itens;
	    private Endereco enderecoEntrega;

	    @CommandHandler
	    public PedidoAggregate(CreatePedidoCommand cmd) {
	        apply(new PedidoCreatedEvent(cmd.getId(), cmd.getNumeroPedido(), cmd.getUser(), cmd.getItens(), cmd.getEnderecoEntrega()));
	    }

	    @CommandHandler
	    public void handle(UpdatePedidoCommand cmd) { 
	        apply(new PedidoUpdatedEvent(cmd.getId(),cmd.getNumeroPedido(),cmd.getUser(), cmd.getItens()));
	    }
	    
	    @CommandHandler
	    public void handle(UpdateEnderecoPedidoCommand cmd) { 
	        apply(new PedidoEnderecoUpdateEvent(cmd.getId(),cmd.getEnderecoEntrega()));
	    }
	    
	    @CommandHandler
	    public void handle(UpdateItensPedidoCommand cmd) { 
	        apply(new PedidoItensUpdateEvent(cmd.getId(), cmd.getItens()));
	    }
	    
	    @CommandHandler
	    public void handle(RemovePedidoCommand cmd) {
	        apply(new ItemRemovedEvent(cmd.getId()));
	    }

	    @EventSourcingHandler
	    public void on(PedidoCreatedEvent event) {
	        this.id = event.getId();
	        this.numeroPedido = event.getNumeroPedido();
	        this.user =  event.getUser();
	        this.itens = event.getItens();
	        this.enderecoEntrega = event.getEnderecoEntrega();
	    }
	    
	    @EventSourcingHandler
	    public void on(PedidoItensUpdateEvent event) {
	        this.itens = event.getItens();
	    }
	    
	    @EventSourcingHandler
	    public void on(PedidoEnderecoUpdateEvent event) {
	        this.enderecoEntrega = event.getEnderecoEntrega();
	    }
	    
	    @EventSourcingHandler
	    public void on(PedidoUpdatedEvent event) {
	        this.user =  event.getUser();
	        this.itens = event.getItens();
	    }

	    @EventSourcingHandler
	    public void on(ItemRemovedEvent event) {
	    }
	}