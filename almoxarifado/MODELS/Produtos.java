package com.example.Projeto.de.Gerenciamento.de.Estoque.de.almoxarifado.MODELS;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nome;

    @DecimalMin(value = "0.5")
    private Double preco;

    @Min(1)
    private Integer quantidade;

    public Produtos(){

    }
    public Produtos(Integer id, String nome, Double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @DecimalMin(value = "0.5") Double getPreco() {
        return preco;
    }

    public void setPreco(@DecimalMin(value = "0.5") Double preco) {
        this.preco = preco;
    }

    public @Min(1) Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@Min(1) Integer quantidade) {
        this.quantidade = quantidade;
    }
}
