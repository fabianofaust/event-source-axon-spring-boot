package com.eventsource.totvs.axon.components;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.eventsource.totvs.axon.event.ItemCreatedEvent;
import com.eventsource.totvs.axon.event.ItemRemovedEvent;
import com.eventsource.totvs.axon.event.ItemSaldoUpdatedEvent;
import com.eventsource.totvs.axon.event.ItemUpdatedEvent;
import com.eventsource.totvs.axon.exception.ObjectNotFoundException;
import com.eventsource.totvs.axon.model.Item;
import com.eventsource.totvs.axon.repository.ItemRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
@ProcessingGroup("amqpEvents")
public class ItemEventProcessor {

    private final ItemRepository Repository;

    @EventHandler
    public void on(ItemCreatedEvent event) {
        Item item = Repository.save(new Item(event.getId(), event.getNome(), event.getSaldo(), event.getValor()));
        log.info("EVENT: O item foi criado! {}", item);
    }

    @EventHandler
    public void on(ItemUpdatedEvent event) {
        var item = Repository.findById(event.getId())
                .orElseThrow(ObjectNotFoundException::new);
        item.setNome(event.getNome());
        item.setSaldo(event.getSaldo());
        item.setValor(event.getValor());
        Repository.save(item);
        log.info("EVENT: O item foi atualizado! {}", item);
    }
    
    @EventHandler
    public void on(ItemSaldoUpdatedEvent event) {
        var item = Repository.findById(event.getId())
                .orElseThrow(ObjectNotFoundException::new);
        item.setSaldo(event.getSaldo());
        Repository.save(item);
        log.info("EVENT: O item foi atualizado! {}", item);
    }

    @EventHandler
    public void on(ItemRemovedEvent event) {
        Repository.deleteById(event.getId());
        log.info("EVENT: O item foi removido! {}", event.getId());
    }
}
