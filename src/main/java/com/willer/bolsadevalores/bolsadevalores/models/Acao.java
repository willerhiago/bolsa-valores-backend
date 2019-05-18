package com.willer.bolsadevalores.bolsadevalores.models;

import javax.persistence.*;

@Entity
@Table
public class Acao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private int quant;
	private double valor;
	private String description;
	private String estado;
	
	public Acao(String nome, int quant, double valor, String description) {
		this.nome = nome;
		this.quant = quant;
		this.valor = valor;
		this.description = description;
		this.estado = "V";
	}
	
	public Acao() {}
	
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

}
