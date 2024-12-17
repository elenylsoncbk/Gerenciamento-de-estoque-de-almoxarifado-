package com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.SERVICE;
import com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.MODELS.Produtos;
import com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.REPOSITORY.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    public Produtos salvar(Produtos produtos){
        return produtosRepository.save(produtos);
    }
    public List<Produtos> listar(){
        return produtosRepository.findAll();
    }
    public Produtos obterPorId(Integer id){
        return produtosRepository.findById(id).orElse(null);
    }
    public void deletar(Integer id){
        produtosRepository.deleteById(id);
    }
    public Produtos editar(Integer id,Produtos produtos){
        Produtos produtosAEditar = produtosRepository.findById(id).get();
        if (produtosAEditar != null){
           produtosAEditar.setNome(produtos.getNome());
           produtosAEditar.setPreco(produtos.getPreco());
           produtosAEditar.setQuantidade(produtos.getQuantidade());
           produtosRepository.save(produtosAEditar);
        }else{
            throw new RuntimeException("Produto não encontrada");
        }
        return produtosAEditar;
    }

}
