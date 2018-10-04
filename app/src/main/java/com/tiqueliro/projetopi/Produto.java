package com.tiqueliro.projetopi;

/**
 * Created by android on 17/09/2018.
 */

public class Produto {
    private Categoria categoria;
    private String id;
    private String fabricacao;
    private String validade;
    private String nome;
    private int quantidade;
    private String lote;
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(String nome) {
        this.categoria.setNome(nome);
    }

    public void setId(String id) {
        this.id = id;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        this.fabricacao = fabricacao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }


}