package com.eventsource.totvs.axon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	//@Id
	private String id;
	private String nome;

}
