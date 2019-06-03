package com.eventsource.totvs.axon.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

	private String id;
    private String nome;
    private Integer saldo;   
    private BigDecimal valor;
}
