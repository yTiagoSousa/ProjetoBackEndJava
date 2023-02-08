package com.teste.primeiroexemplo.model;

public class Produto {
    
    //#region Atributos
    private Integer id;
    private String nome;
    private Integer quantidade;
    private String observacao;
    //#endregion
    //#region metodos
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    //#endregion
    
}
