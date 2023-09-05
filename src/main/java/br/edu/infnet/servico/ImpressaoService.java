package br.edu.infnet.servico;

import br.edu.infnet.modelo.dominio_enum.AprovacaoSegurado;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ImpressaoService implements Impressora{

    String diretorioPath = "src/main/java/br/edu/infnet/utilitarios/relatorio/output";
    String arquivoNome = LocalDate.now() + "_relatorio.csv";

    @Override
    public void imprimeCSV(HashMap<String, AprovacaoSegurado> seguradosAprovadosTriagem) {
        try (FileWriter escreveArquivo = new FileWriter(diretorioPath + "/" + arquivoNome);
             PrintWriter escritorCSV = new PrintWriter(escreveArquivo)) {

            escritorCSV.println("Nome, Resultado Triagem");

            for (Map.Entry<String, AprovacaoSegurado> entry : seguradosAprovadosTriagem.entrySet()) {
                escritorCSV.println(entry.getKey() + "," + entry.getValue());
            }

            System.out.println("Arquivo CSV criado e escrito com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nao foi possivel escrever o arquivo CSV");
        }
    }


}
