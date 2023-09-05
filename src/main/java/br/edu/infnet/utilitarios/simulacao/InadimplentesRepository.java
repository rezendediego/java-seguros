package br.edu.infnet.utilitarios.simulacao;

import br.edu.infnet.modelo.dominio.Segurado;

import java.util.*;

public class InadimplentesRepository {
    private final Segurado seguradoInadimplente = new Segurado("Joao Rodrigues",18,"25530511");
    private final HashMap<String,Boolean> inadimplentes = new HashMap<>();


    public Boolean getInadimplentesPorNome(String nome) {
        Boolean result = true;
        this.inadimplentes.put(seguradoInadimplente.getNome(),true);

        if(inadimplentes.get(nome) == null){
            result = false;
        }
        return result;
    }
}
