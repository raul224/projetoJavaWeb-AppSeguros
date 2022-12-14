package infnet.edu.seguros.controller;

import infnet.edu.seguros.model.domain.Cliente;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {
    private String mensagem;
    @Autowired
    private ClienteService service;

    @GetMapping(value = "/cliente")
    public String TelaCadastro() {
        return "cliente/cadastro";
    }

    @GetMapping(value = "/cliente/listar")
    public String ListarSeguros(Model model,  @SessionAttribute("user") Usuario usu){
        model.addAttribute("listagem", service.getAllByUsu(usu));
        model.addAttribute("msg", mensagem);
        return "cliente/lista";
    }

    @PostMapping(value = "/cliente/incluir")
    public String IncluirSeguro(Cliente cliente, @SessionAttribute("user") Usuario usu) {
        cliente.setUsuario(usu);
        service.incluir(cliente);
        return "redirect:/cliente/listar";
    }

    @GetMapping(value = "/cliente/{id}/excluir")
    public String Excluir(@PathVariable Integer id) {
        try {
            service.excluir(id);
            mensagem = "Excluído com sucesso";
        } catch (Exception e){
            mensagem = "Não é possível excluir esse cliente por estar associado a um orçamento";
        }
        return "redirect:/cliente/listar";
    }
}
