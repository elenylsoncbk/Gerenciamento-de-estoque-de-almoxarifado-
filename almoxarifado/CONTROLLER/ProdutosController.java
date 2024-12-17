package com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.CONTROLLER;
import com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.MODELS.Produtos;
import com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.SERVICE.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService service;

//    @PostMapping
//    public Produtos salvar(@RequestBody Produtos produtos){
//        return service.salvar(produtos);
//    }

    @PostMapping
    public ResponseEntity<Produtos> salvar(@RequestBody Produtos produtos){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(produtos))  ;
    }

    @GetMapping
    public List<Produtos> listar(){
        return service.listar();
    }
    @GetMapping("/{id}")
    public Produtos obterPorId(@PathVariable("id")Integer id){
        return service.obterPorId(id);
    }


    @PutMapping
    public ResponseEntity<String>semPut(){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Metodo não permitido");
    }
    @PutMapping("/{id}")
    public Produtos editar(@PathVariable("id") Integer id,@RequestBody Produtos produtos){
        return service.editar(id, produtos);

    }
    //    @DeleteMapping("/{id}")
    //    public void deletar(@PathVariable("id")Integer id){
//        service.deletar(id);
//    }
    @DeleteMapping
    public ResponseEntity<String>semDelete(){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Metodo não permitido");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable("id")String id){
        int idInt;
        try {
            idInt= Integer.parseInt(id);
            if(idInt<0){
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID inválido.");
            }
        }catch (NumberFormatException e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID deve ser um número inteiro");
        }
        Produtos produtoExistente = service.obterPorId(idInt);
        if (produtoExistente != null) {
            service.deletar(idInt);
            return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
    }

}
