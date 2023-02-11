package com.teste.primeiroexemplo.view.model;

public class ProdutoRequest {
    
    //#region Atributos

    private String nome;
    private Integer quantidade;
    private String observacao;
    private Double valor;
    //#endregion
    
    //#region metodos
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
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    //#endregion
}
