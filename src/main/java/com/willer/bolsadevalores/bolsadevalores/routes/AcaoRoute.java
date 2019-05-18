package com.willer.bolsadevalores.bolsadevalores.routes;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.willer.bolsadevalores.bolsadevalores.controllers.AcaoController;
import com.willer.bolsadevalores.bolsadevalores.models.Acao;

import java.util.List;

@CrossOrigin
@RequestMapping("/acao")
public class AcaoRoute {
	
	private AcaoController acaoController;
	
	public AcaoRoute(AcaoController acaoController) {
		this.acaoController = acaoController;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Acao> getAcoes(){
		return acaoController.getAcoes();
	}
	
	@RequestMapping(value = "/ativas", method = RequestMethod.GET)
	@ResponseBody
	public List<Acao> getAcoesAtivas(){
		return acaoController.getAcoesAtivas();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Acao getAcao(@PathVariable(name = "id") int id){
		return acaoController.getAcao(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params={"nome", "quant", "valor", "description"})
	@ResponseBody
	public Acao createAcao (String nome, int quant, double valor, String description){
		return acaoController.createAcao(nome, quant, valor, description);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAcao(@PathVariable("id") int id){
		acaoController.deleteAcao(id);
    }
	
	@RequestMapping(value = "/compra", method = RequestMethod.POST, params={"idAcao", "idCorretora", "quant"})
    @ResponseBody
    public boolean compra(int idAcao, int idCorretora, int quant){
		acaoController.compra(idAcao, idCorretora, quant);
		return true;
    }
}
