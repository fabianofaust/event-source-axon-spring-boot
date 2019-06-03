package com.eventsource.totvs.axon.dto;

import java.util.List;

import com.eventsource.totvs.axon.model.Endereco;
import com.eventsource.totvs.axon.model.Item;
import com.eventsource.totvs.axon.model.User;

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
public class PedidoDTO {

	private String id;
    private Integer numeroPedido;
    private User user;
    private List<Item> itens;
    private Endereco enderecoEntrega;
}
