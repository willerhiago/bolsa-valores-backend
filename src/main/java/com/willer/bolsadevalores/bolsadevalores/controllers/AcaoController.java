package com.willer.bolsadevalores.bolsadevalores.controllers;

import java.util.List;

import javax.persistence.EntityManager;

import com.willer.bolsadevalores.bolsadevalores.models.Acao;
import com.willer.bolsadevalores.bolsadevalores.controllers.AcaoCorretoraController;

public class AcaoController {
	
	private EntityManager entityManager;
	private AcaoCorretoraController acaoCorrController;
	
	public AcaoController(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.acaoCorrController = new AcaoCorretoraController(entityManager);
	}
	
	public List<Acao> getAcoes() {
		// entityManager.find(Example.class, id)
		return entityManager.createQuery("FROM Acao", Acao.class).getResultList();
	}
	
	public List<Acao> getAcoesAtivas() {
		// entityManager.find(Example.class, id)
		return entityManager.createQuery("FROM Acao WHERE estado = 'V'", Acao.class).getResultList();
	}
	
	public Acao getAcao(int id) {
		return entityManager.find(Acao.class, id);
	}
	
	public Acao createAcao(String nome, int quant, double valor, String description) {
		Acao acao = new Acao(nome, quant, valor, description);
		
		entityManager.getTransaction().begin();
		entityManager.persist(acao);
		entityManager.getTransaction().commit();
		
		return acao;
	}
	
	public Acao deleteAcao (int id) {
		Acao acao = entityManager.find(Acao.class, id);
		this.acaoCorrController.deleteTransacoesAcao(id);
		entityManager.getTransaction().begin();
		entityManager.remove(acao);
		entityManager.getTransaction().commit();
		return acao;
	}
	
	public Acao compra (int idAcao, int idCorretora, int quant) {
		Acao acao = entityManager.find(Acao.class, idAcao);
		int novaQuant = acao.getQuant() - quant;
		if(quant >= acao.getQuant()){
			novaQuant = 0;
			quant = acao.getQuant();
		} 
		
		this.acaoCorrController.createAcaoCorretora(idAcao, idCorretora, acao.getValor(), quant, "C");
		entityManager.getTransaction().begin();
		if(novaQuant == 0) acao.setEstado("C");
		acao.setQuant(novaQuant);
		entityManager.getTransaction().commit();
		
		return acao;
	}
	
}
