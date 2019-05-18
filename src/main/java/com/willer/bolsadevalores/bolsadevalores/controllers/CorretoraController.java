package com.willer.bolsadevalores.bolsadevalores.controllers;

import java.util.List;

import javax.persistence.EntityManager;

import com.willer.bolsadevalores.bolsadevalores.models.Corretora;

public class CorretoraController {
	
	private EntityManager entityManager;
	private AcaoCorretoraController acaoCorrController;
	
	public CorretoraController(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.acaoCorrController = new AcaoCorretoraController(entityManager);
	}
	
	public List<Corretora> getCorretoras() {
		// entityManager.find(Example.class, id)
		return entityManager.createQuery("FROM Corretora", Corretora.class).getResultList();
	}
	
	public Corretora getCorretora(int id) {
		return entityManager.find(Corretora.class, id);
	}
	
	public Corretora createCorretora(String nome) {
		Corretora Corretora = new Corretora(nome);
		
		entityManager.getTransaction().begin();
		entityManager.persist(Corretora);
		entityManager.getTransaction().commit();
		
		return Corretora;
	}
	
	public Corretora deleteCorretora (int id) {
		Corretora Corretora = entityManager.find(Corretora.class, id);
		acaoCorrController.deleteTransacoesCorretora(id);
		entityManager.getTransaction().begin();
		entityManager.remove(Corretora);
		entityManager.getTransaction().commit();
		return Corretora;
	}
}
