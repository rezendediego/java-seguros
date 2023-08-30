package br.edu.infnet.modelo.dominio;

import java.util.UUID;

public class Segurado {
    private UUID id;
    private String nome;
    private Integer idade;
    private String cep;

    public Segurado(String nome, Integer idade, String cep) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.idade = idade;
        this.cep = cep;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "Segurado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cep='" + cep + '\'' +
                '}';
    }
}
