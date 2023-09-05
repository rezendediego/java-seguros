package br.edu.infnet.servico;

import br.edu.infnet.modelo.dominio_enum.AprovacaoSegurado;

import java.util.HashMap;

public interface Impressora {
   void imprimeCSV(HashMap<String, AprovacaoSegurado> seguradosAprovadosTriagem);
}
