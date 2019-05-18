package com.willer.bolsadevalores.bolsadevalores.models;

import javax.persistence.*;

@Entity
@Table
public class Corretora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	
	public Corretora(String nome) {
		this.nome = nome;
	}
	
	public Corretora() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}

}
