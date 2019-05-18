package com.willer.bolsadevalores.bolsadevalores.routes;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.willer.bolsadevalores.bolsadevalores.controllers.CorretoraController;
import com.willer.bolsadevalores.bolsadevalores.models.Corretora;

import java.util.List;

@CrossOrigin
@RequestMapping("/corretora")
public class CorretoraRoute {
	
	private CorretoraController corretoraController;
	
	public CorretoraRoute(CorretoraController corretoraController) {
		this.corretoraController = corretoraController;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Corretora> getCorretoras(){
		return corretoraController.getCorretoras();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Corretora getCorretora (@PathVariable(name = "id") int id){
		return corretoraController.getCorretora(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params={"nome"})
	@ResponseBody
	public Corretora createCorretora (String nome){
		return corretoraController.createCorretora(nome);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCorretora(@PathVariable("id") int id){
		corretoraController.deleteCorretora(id);
		
    }
}
