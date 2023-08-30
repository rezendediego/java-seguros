package br.edu.infnet.modelo.dominio;

import br.edu.infnet.modelo.dominio_enum.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class SeguroSaude extends Seguro{
    private Integer idadeSegurado;
    private Sexo sexoSegurado;
    private ModalidadeSeguroSaude modalidadeSeguroSaude;
    private PeriodoCarencia periodoCarencia;
    private List<DoencasPreexistentes> doencasPreexistentes;


    public SeguroSaude(String nomeSegurado,
                       boolean autoRenovavel,
                       LocalDateTime inicio,
                       Optional<LocalDateTime> fim,
                       Integer idadeSegurado,
                       Sexo sexoSegurado,
                       ModalidadeSeguroSaude modalidadeSeguroSaude,
                       PeriodoCarencia periodoCarencia,
                       List<DoencasPreexistentes> doencasPreexistentes
                       ) {
        super(nomeSegurado, TipoSeguro.SEGURO_SAUDE, autoRenovavel, inicio, fim);
        this.idadeSegurado = idadeSegurado;
        this.sexoSegurado = sexoSegurado;
        this.modalidadeSeguroSaude = modalidadeSeguroSaude;
        this.periodoCarencia = periodoCarencia;
        this.doencasPreexistentes = doencasPreexistentes;
    }

    public SeguroSaude(String nomeSegurado,
                       boolean autoRenovavel,
                       LocalDateTime inicio,
                       Integer idadeSegurado,
                       Sexo sexoSegurado,
                       ModalidadeSeguroSaude modalidadeSeguroSaude,
                       PeriodoCarencia periodoCarencia,
                       List<DoencasPreexistentes> doencasPreexistentes) {
        super(nomeSegurado, TipoSeguro.SEGURO_SAUDE, autoRenovavel, inicio);
        this.idadeSegurado = idadeSegurado;
        this.sexoSegurado = sexoSegurado;
        this.modalidadeSeguroSaude = modalidadeSeguroSaude;
        this.periodoCarencia = periodoCarencia;
        this.doencasPreexistentes = doencasPreexistentes;
    }

    public Integer getIdadeSegurado() {
        return idadeSegurado;
    }

    public Sexo getSexoSegurado() {
        return sexoSegurado;
    }

    public ModalidadeSeguroSaude getModalidadeSeguroSaude() {
        return modalidadeSeguroSaude;
    }

    public PeriodoCarencia getPeriodoCarencia() {
        return periodoCarencia;
    }

    public List<DoencasPreexistentes> getDoencasPreexistentes() {
        return doencasPreexistentes;
    }


    @Override
    public Mensalidade calcularMensalidade(BigDecimal valorBase) {
        Mensalidade mensalidade = new Mensalidade(valorBase);
        BigDecimal valorMensalidadeAdicional = calcularAdicionalDoencaPreExistente(mensalidade, this.doencasPreexistentes);
        valorMensalidadeAdicional = valorMensalidadeAdicional.add(calcularAdicionalFatorRiscoHomem(mensalidade, this.sexoSegurado));
        mensalidade.setValorMensalidade(mensalidade.getValorBase().add(valorMensalidadeAdicional));
        return mensalidade;
    }

    private BigDecimal calcularAdicionalFatorRiscoHomem(Mensalidade mensalidade,
                                                        Sexo sexoSegurado) {
        BigDecimal valorCalculadoAdicionalFatorRiscoHomem;
        if(sexoSegurado.equals(Sexo.MASCULINO)){
            valorCalculadoAdicionalFatorRiscoHomem = mensalidade.getValorBase().multiply(new BigDecimal("5").divide(new BigDecimal("100")));
        }else{valorCalculadoAdicionalFatorRiscoHomem = BigDecimal.ZERO;}
        return valorCalculadoAdicionalFatorRiscoHomem;
    }

    private BigDecimal calcularAdicionalDoencaPreExistente(Mensalidade mensalidade,
                                                           List<DoencasPreexistentes> doencasPreexistentes) {
        BigDecimal porcentagem = new BigDecimal(doencasPreexistentes.size() * 5);
        return mensalidade.getValorBase().multiply(porcentagem).divide(new BigDecimal("100"), RoundingMode.CEILING);
    }

    @Override
    public String toString() {
        return "SeguroSaude{" +
                super.toString() +
                ", idadeSegurado=" + idadeSegurado + "\n" +
                ", sexoSegurado=" + sexoSegurado + "\n" +
                ", modalidadeSeguroSaude=" + modalidadeSeguroSaude + "\n" +
                ", periodoCarencia=" + periodoCarencia + "\n" +
                ", doencasPreexistentes=" + doencasPreexistentes +
                "} ";
    }
}
