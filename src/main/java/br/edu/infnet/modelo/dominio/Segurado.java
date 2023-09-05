package br.edu.infnet.modelo.dominio;

import br.edu.infnet.excecao.SeguradoMenorIdadeException;

import java.util.Objects;
import java.util.UUID;

public class Segurado {
    private final UUID id;
    private final String nome;
    private final Integer idade;
    private final String cep;

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

    public Integer getIdade(){
        return idade;
    }

    public String getCep() {
        return cep;
    }

    //Feature 04.2 Cada classe de negócio deve usar uma classe de exception.
    public Boolean permissaoParaContratarSeguro() throws SeguradoMenorIdadeException{
        if(this.idade<18){
            throw new SeguradoMenorIdadeException("EXCEPTION_SEGURADO_MENOR_IDADE: O Segurado é menor de idade e não pode contratar seguros");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segurado segurado = (Segurado) o;
        return Objects.equals(id, segurado.id) && Objects.equals(nome, segurado.nome) && Objects.equals(idade, segurado.idade) && Objects.equals(cep, segurado.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade, cep);
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
