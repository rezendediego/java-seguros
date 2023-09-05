package br.edu.infnet.servico;

import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio_enum.AprovacaoSegurado;
import br.edu.infnet.utilitarios.simulacao.InadimplentesRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TriagemService {
    private List<Segurado> triagemPreContrato = new ArrayList<>();
    static LeitorCSVService leitorCSVService = new LeitorCSVService();
    private static InadimplentesRepository inadimplentesRepository = new InadimplentesRepository();
    public static List<Segurado> getSeguradosPreContrato(){
        return leitorCSVService.criarListaSegurados();
    }

    public static HashMap<String, AprovacaoSegurado> aplicarRegrasTriagem(List<Segurado> listaSeguradosPreContrato) {
        HashMap<String, AprovacaoSegurado> mapaTemp = new HashMap<>();
        listaSeguradosPreContrato.forEach(segurado -> {
                if(segurado.getIdade() < 18){
                    mapaTemp.put(segurado.getNome(), AprovacaoSegurado.REPROVADO);
                }else if(inadimplentesRepository.getInadimplentesPorNome(segurado.getNome())){
                    mapaTemp.put(segurado.getNome(), AprovacaoSegurado.REPROVADO);
                }else{
                    mapaTemp.put(segurado.getNome(), AprovacaoSegurado.APROVADO);
                }
                });
        return mapaTemp;
    }
}
