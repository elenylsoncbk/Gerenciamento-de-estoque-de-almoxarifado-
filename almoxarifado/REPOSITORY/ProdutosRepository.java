package com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.REPOSITORY;

import com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.MODELS.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos,Integer> {
}
