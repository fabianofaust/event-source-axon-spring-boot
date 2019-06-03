package com.eventsource.totvs.axon.model;

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
public class Endereco {

	private String id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
		
}
