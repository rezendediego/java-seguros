package br.edu.infnet.modelo.dominio;

import br.edu.infnet.excecao.SeguradoInadimplenteException;
import br.edu.infnet.modelo.dominio_enum.TempoContrato;
import br.edu.infnet.utilitarios.validacao.ValidadorPermissaoSeguradoFirmarContrato;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PropostaContrato {
    private UUID idContrato;
    private LocalDateTime dataPropostaContrato;
    private final Segurado segurado;

    private TempoContrato tempoContrato;

    /*
    * Feature 03 Criação do relacionamento entre a classe principal (Classe PropostaContrato)
    * e a mãe (Classe Seguro) com List.
    **/
    private final List<Seguro> listaSeguro;

    public PropostaContrato(LocalDateTime dataPropostaContrato, Segurado segurado, TempoContrato tempoContrato, List<Seguro> listaSeguro) {
        this.idContrato = UUID.randomUUID();
        this.dataPropostaContrato = dataPropostaContrato;
        this.segurado = segurado;
        this.tempoContrato = tempoContrato;
        this.listaSeguro = listaSeguro;
    }

    public UUID getIdContrato() {
        return idContrato;
    }

    public LocalDateTime getDataPropostaContrato() {
        return dataPropostaContrato;
    }

    public Segurado getSegurado() {
        return segurado;
    }

    public TempoContrato getTempoContrato() {
        return tempoContrato;
    }

    public List<Seguro> getListaSeguro() {
        return listaSeguro;
    }

    //Feature 04.2 Cada classe de negócio deve usar uma classe de exception.
    public Boolean seguradoEstaInadimplente(ValidadorPermissaoSeguradoFirmarContrato validadorPermissaoSeguradoFirmarContrato) throws SeguradoInadimplenteException{
        if(validadorPermissaoSeguradoFirmarContrato.getSeguradoInadimplentePorId(this.segurado.getId())){
            throw new SeguradoInadimplenteException("EXCEPTION_SEGURADO_INADIMPLENTE: O Segurado nao pode firmar um contrato de seguro porque está inadimplente");
        }else return true;
    }

    @Override
    public String toString() {
        return "PropostaContrato{" + "\n" +
                "idContrato=" + idContrato + "\n" +
                ", dataPropostaContrato=" + dataPropostaContrato + "\n" +
                ", segurado=" + segurado + "\n" +
                ", seguro=" + listaSeguro +
                '}';
    }
}
