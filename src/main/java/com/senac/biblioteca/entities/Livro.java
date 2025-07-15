package com.senac.biblioteca.entities;

public class Livro {
    private Integer id;
    private String nome;
    private String autor;
    private Double preco;

    public Livro(Integer id, String nome, String autor, Double preco) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.preco = preco;
    }

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
