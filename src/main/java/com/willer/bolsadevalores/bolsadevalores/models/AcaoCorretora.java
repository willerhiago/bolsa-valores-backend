package com.willer.bolsadevalores.bolsadevalores.models;

import javax.persistence.*;

@Entity
@Table
public class AcaoCorretora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int idAcao;
	private String nomeAcao;
	private int idCorretora;
	private String nomeCorretora;
	private double valorVenda;
	private int quant;
	private String tipo;
	
	public AcaoCorretora(int idAcao, String nomeAcao, int idCorretora, String nomeCorretora, double valorVenda, int quant, String tipo) {
		this.idAcao = idAcao;
		this.nomeAcao = nomeAcao;
		this.idCorretora = idCorretora;
		this.nomeCorretora = nomeCorretora;
		this.valorVenda = valorVenda;
		this.quant = quant;
		this.tipo = tipo;
	}
	
	public AcaoCorretora() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getIdAcao() {
		return idAcao;
	}

	public void setIdAcao(int idAcao) {
		this.idAcao = idAcao;
	}

	public String getNomeAcao() {
		return nomeAcao;
	}

	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}

	public int getIdCorretora() {
		return idCorretora;
	}

	public void setIdCorretora(int idCorretora) {
		this.idCorretora = idCorretora;
	}

	public String getNomeCorretora() {
		return nomeCorretora;
	}

	public void setNomeCorretora(String nomeCorretora) {
		this.nomeCorretora = nomeCorretora;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
