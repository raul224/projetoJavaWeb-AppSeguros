package infnet.edu.seguros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import infnet.edu.seguros.model.domain.Seguro;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.SeguroService;

@Controller
public class SeguroController {
	private String mensagem;
	@Autowired
	private SeguroService service;

	@GetMapping(value = "/seguro")
	public String TelaCadastro() {
		return "seguro/cadastro";
	}
	
	@GetMapping(value = "/seguro/listar")
	public String ListarSeguros(Model model, @SessionAttribute("user") Usuario usu){
		model.addAttribute("listagem", service.getAllByUsu(usu));
		model.addAttribute("msg", mensagem);
		return "seguro/lista";
	}
	
	@PostMapping(value = "/seguro/incluir")
	public String IncluirSeguro(Seguro seguro, @SessionAttribute("user") Usuario usu) {
		seguro.setUsuario(usu);
		service.incluir(seguro);
		return "redirect:/seguro/listar";
	}
	
	@GetMapping(value = "/seguro/{id}/excluir")
	public String Excluir(@PathVariable Integer id) {
		try {
			service.excluir(id);
			mensagem = "Seguro " + id + " foi excluido com sucesso";
		} catch (Exception e){
			mensagem = "Não é possível excluir esse seguro por estar associado a um orçamento";
		}
		return "redirect:/seguro/listar";
	}

	public void Exclusao(Integer id){
		service.excluir(id);
	}
}
