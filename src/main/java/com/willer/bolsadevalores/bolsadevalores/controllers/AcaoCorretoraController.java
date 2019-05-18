package com.willer.bolsadevalores.bolsadevalores.controllers;

import java.util.List;

import javax.persistence.EntityManager;

import com.willer.bolsadevalores.bolsadevalores.models.Acao;
import com.willer.bolsadevalores.bolsadevalores.models.AcaoCorretora;
import com.willer.bolsadevalores.bolsadevalores.models.Corretora;

public class AcaoCorretoraController {

private EntityManager entityManager;
	
	public AcaoCorretoraController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<AcaoCorretora> getAcaoCorretoras() {
		// entityManager.find(Example.class, id)
		return entityManager.createQuery("FROM AcaoCorretora ORDER BY id DESC", AcaoCorretora.class).getResultList();
	}
	
	public AcaoCorretora getAcaoCorretora(int id) {
		return entityManager.find(AcaoCorretora.class, id);
	}
	
	public AcaoCorretora createAcaoCorretora(int idAcao, int idCorretora, double valorVenda, int quant, String tipo) {
		Acao acao = entityManager.find(Acao.class, idAcao);
		Corretora corretora = entityManager.find(Corretora.class, idCorretora);
		AcaoCorretora acaoCorretora= new AcaoCorretora(acao.getId(), acao.getNome(), corretora.getId(), corretora.getNome(), valorVenda, quant, tipo);
		
		entityManager.getTransaction().begin();
		entityManager.persist(acaoCorretora);
		entityManager.getTransaction().commit();
		
		return acaoCorretora;
	}
	
	public AcaoCorretora deleteAcaoCorretora (int id) {
		AcaoCorretora acaoCorretora = entityManager.find(AcaoCorretora.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(acaoCorretora);
		entityManager.getTransaction().commit();
		return acaoCorretora;
	}
	
	public void  deleteTransacoesCorretora(int idCorretora) {
		// entityManager.find(Example.class, id)
		List<AcaoCorretora> lista= entityManager.createQuery("FROM AcaoCorretora WHERE idCorretora = :idCorretora", AcaoCorretora.class).setParameter("idCorretora", idCorretora).getResultList();
		lista.forEach((registro) ->{
			this.deleteAcaoCorretora(registro.getId());
		});
	}
	
	public void  deleteTransacoesAcao(int idAcao) {
		// entityManager.find(Example.class, id)
		List<AcaoCorretora> lista= entityManager.createQuery("FROM AcaoCorretora WHERE idAcao = :idAcao", AcaoCorretora.class).setParameter("idAcao", idAcao).getResultList();
		lista.forEach((registro) ->{
			this.deleteAcaoCorretora(registro.getId());
		});
	} 
	
}
