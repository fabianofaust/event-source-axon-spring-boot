package com.eventsource.totvs.axon.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.eventsource.totvs.axon.command.CreateItemCommand;
import com.eventsource.totvs.axon.command.RemoveItemCommand;
import com.eventsource.totvs.axon.command.UpdateItemCommand;
import com.eventsource.totvs.axon.command.UpdateSaldoItemCommand;
import com.eventsource.totvs.axon.event.ItemCreatedEvent;
import com.eventsource.totvs.axon.event.ItemRemovedEvent;
import com.eventsource.totvs.axon.event.ItemSaldoUpdatedEvent;
import com.eventsource.totvs.axon.event.ItemUpdatedEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Aggregate
@NoArgsConstructor
public class ItemAggregate {

    @AggregateIdentifier
    private String id;
    private String nome;
    private Integer saldo;   
    private BigDecimal valor;

    @CommandHandler
    public ItemAggregate(CreateItemCommand cmd) {
        apply(new ItemCreatedEvent(cmd.getId(), cmd.getNome(),cmd.getSaldo(), cmd.getValor()));
    }

    @CommandHandler
    public void handle(UpdateItemCommand cmd) { 
        apply(new ItemUpdatedEvent(cmd.getId(),cmd.getNome(),cmd.getSaldo(), cmd.getValor()));
    }
    
    @CommandHandler
    public void handle(UpdateSaldoItemCommand cmd) {
        apply(new ItemSaldoUpdatedEvent(cmd.getId(), cmd.getSaldo()));
    }

    @CommandHandler
    public void handle(RemoveItemCommand cmd) {
        apply(new ItemRemovedEvent(cmd.getId()));
    }

    @EventSourcingHandler
    public void on(ItemCreatedEvent event) {
        this.id = event.getId();
        this.nome = event.getNome();
        this.saldo =  event.getSaldo();
        this.valor = event.getValor();
    }
    
    @EventSourcingHandler
    public void on(ItemSaldoUpdatedEvent event) {
        this.saldo =  event.getSaldo();
    }

    @EventSourcingHandler
    public void on(ItemUpdatedEvent event) {
        this.nome = event.getNome();
        this.saldo =  event.getSaldo();
        this.valor = event.getValor();
    }

    @EventSourcingHandler
    public void on(ItemRemovedEvent event) {
    }
}