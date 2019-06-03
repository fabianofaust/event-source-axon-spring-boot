package com.eventsource.totvs.axon.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private String id;
    private String nome;
    private Integer saldo;   
    private BigDecimal valor;
}