package infnet.edu.seguros.model.service;

import infnet.edu.seguros.model.domain.SeguroVeiculo;
import infnet.edu.seguros.model.domain.Usuario;
import infnet.edu.seguros.model.repository.SeguroVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguroVeiculoService {

    @Autowired
    private SeguroVeiculoRepository repository;

    public void incluir(SeguroVeiculo seguro){
        repository.save(seguro);
    }

    public List<SeguroVeiculo> obterLista(){
        return (List<SeguroVeiculo>)repository.findAll();
    }

    public SeguroVeiculo obterPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<SeguroVeiculo> GetAllByUsu(Usuario usu){
        return (List<SeguroVeiculo>) repository.ObterLista(usu.getId());
    }

    public void Excluir(Integer id) {
        repository.deleteById(id);
    }
}