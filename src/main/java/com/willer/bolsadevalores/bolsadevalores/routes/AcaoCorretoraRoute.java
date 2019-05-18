package com.willer.bolsadevalores.bolsadevalores.routes;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.willer.bolsadevalores.bolsadevalores.controllers.AcaoCorretoraController;
import com.willer.bolsadevalores.bolsadevalores.models.AcaoCorretora;

@CrossOrigin
@RequestMapping("/acaoCorretora")
public class AcaoCorretoraRoute {

	private AcaoCorretoraController acaoCorController;
	
	public AcaoCorretoraRoute(AcaoCorretoraController acaoCorController) {
		this.acaoCorController = acaoCorController;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	@ResponseBody
	public List<AcaoCorretora> getAcaoCorretoras(){
		return acaoCorController.getAcaoCorretoras();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public AcaoCorretora getAcaoCorretora (@PathVariable(name = "id") int id){
		return acaoCorController.getAcaoCorretora(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public AcaoCorretora createAcaoCorretora (int idAcao, int idCorretora, double valorVenda, int quant, String tipo){
		return acaoCorController.createAcaoCorretora(idAcao, idCorretora, valorVenda,quant,tipo);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAcaoCorretora(@PathVariable("id") int id){
		acaoCorController.deleteAcaoCorretora(id);
    }
}
