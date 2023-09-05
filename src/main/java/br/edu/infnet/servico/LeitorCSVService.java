package br.edu.infnet.servico;

import br.edu.infnet.modelo.dominio.Segurado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSVService {

    String inputFilePath = "src/main/java/br/edu/infnet/utilitarios/relatorio/input/inputTriagemSeguradosPreContrato.csv";


    private FileReader abrirFileReader() throws FileNotFoundException{
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(inputFilePath);
        }catch(FileNotFoundException fnf){
            System.out.println(">>>: FileNotFoundException: O arquivo nao foi encontrado");
        }
        return fileReader;
    }

    public void leiaCSV(){
        try {
            BufferedReader br = new BufferedReader(abrirFileReader());
            String linha;

            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

            br.close();
        } catch (FileNotFoundException fnf) {
            System.out.println(">>>: FileNotFoundException: O arquivo nao foi encontrado" + fnf.getMessage());
        } catch (IOException io) {
            io.printStackTrace();
        }
    }


    public List<Segurado> criarListaSegurados() {
        List<Segurado> seguradosTriagem = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(abrirFileReader());
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] textoData = linha.split(",");
                String nomeTemp = textoData[0];
                Integer idadeTemp = Integer.parseInt(textoData[1]);
                String cepTemp = textoData[2];
                seguradosTriagem.add(new Segurado(nomeTemp,idadeTemp,cepTemp));
            }

            br.close();
        } catch (FileNotFoundException fnf) {
            System.out.println(">>>: FileNotFoundException: O arquivo nao foi encontrado" + fnf.getMessage());
        } catch (IOException io) {
            io.printStackTrace();
        }
        return seguradosTriagem;
    }
}
