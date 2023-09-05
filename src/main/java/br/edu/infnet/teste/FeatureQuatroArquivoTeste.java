package br.edu.infnet.teste;

import br.edu.infnet.modelo.dominio.Segurado;
import br.edu.infnet.modelo.dominio_enum.AprovacaoSegurado;
import br.edu.infnet.servico.ImpressaoService;
import br.edu.infnet.servico.LeitorCSVService;
import br.edu.infnet.servico.TriagemService;

import java.util.HashMap;
import java.util.List;

public class FeatureQuatroArquivoTeste {
    public static void main(String[] args){
        LeitorCSVService leitorCSVService = new LeitorCSVService();
        System.out.println("Feature 04.3 - Fazer a leitura de um arquivo texto com o layout definido pelo aluno.");
        System.out.println("Layout Inicial: nome,idade,cep");
        leitorCSVService.leiaCSV();

        List<Segurado> listaSeguradosPreContrato = TriagemService.getSeguradosPreContrato();
        System.out.println("\nListaSegurados lida e criada a partir do arquivo .csv : " + "\n"+ listaSeguradosPreContrato );

        System.out.println("Feature 04.4 - Um arquivo texto deve ser gerado com um layout diferente da entrada");
        HashMap<String, AprovacaoSegurado> seguradosAprovadosTriagem = TriagemService.aplicarRegrasTriagem(listaSeguradosPreContrato);
        ImpressaoService impressaoCSV = new ImpressaoService();
        impressaoCSV.imprimeCSV(seguradosAprovadosTriagem);
    }

}
