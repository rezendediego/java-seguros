package br.edu.infnet.modelo.dominio;

import br.edu.infnet.excecao.SeguroNaoDisponivelException;
import br.edu.infnet.modelo.dominio_enum.Sexo;
import br.edu.infnet.modelo.dominio_enum.TipoSeguro;
import br.edu.infnet.utilitarios.validacao.ValidadorDisponibilidadeSeguroVida;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class SeguroVida extends Seguro{
    private Integer idadeSegurado;
    private Sexo sexoSegurado;
    private List<String> beneficiarios;
    private BigDecimal capitalSegurado;

    public SeguroVida(String nomeSegurado,
                      boolean autoRenovavel,
                      LocalDateTime inicio,
                      Optional<LocalDateTime> fim,
                      Integer idadeSegurado,
                      Sexo sexoSegurado,
                      List<String> beneficiarios,
                      BigDecimal capitalSegurado) {
        super(nomeSegurado, TipoSeguro.SEGURO_VIDA, autoRenovavel, inicio, fim);
        this.idadeSegurado = idadeSegurado;
        this.sexoSegurado = sexoSegurado;
        this.beneficiarios = beneficiarios;
        this.capitalSegurado = capitalSegurado;
    }

    public SeguroVida(String nomeSegurado,
                      boolean autoRenovavel,
                      LocalDateTime inicio,
                      Integer idadeSegurado,
                      Sexo sexoSegurado,
                      List<String> beneficiarios,
                      BigDecimal capitalSegurado) {
        super(nomeSegurado, TipoSeguro.SEGURO_VIDA, autoRenovavel, inicio);
        this.idadeSegurado = idadeSegurado;
        this.sexoSegurado = sexoSegurado;
        this.beneficiarios = beneficiarios;
        this.capitalSegurado = capitalSegurado;
    }

    public Integer getIdadeSegurado() {
        return idadeSegurado;
    }

    public Sexo getSexoSegurado() {
        return sexoSegurado;
    }

    public List<String> getBeneficiarios() {
        return beneficiarios;
    }

    public BigDecimal getCapitalSegurado() {
        return capitalSegurado;
    }


    //Feature 04.2 Cada classe de negócio deve usar uma classe de exception.
    public Boolean modVidaEstaDisponivel(ValidadorDisponibilidadeSeguroVida validadorDisponibilidadeSeguroVida) throws SeguroNaoDisponivelException {
        if(!validadorDisponibilidadeSeguroVida.getDisponibilidade()){
            throw new SeguroNaoDisponivelException("EXCEPTION_SEGURO_NAO_DISPONIVEL: A modalidade Seguro Vida Nao está disponível");
        }else return true;
    }


    @Override
    public Mensalidade calcularMensalidade(BigDecimal valorBase) {
        Mensalidade mensalidade = new Mensalidade(valorBase);
        BigDecimal valorMensalidadeAdicional = calcularAdicionalFaixaEtaria(mensalidade, this.idadeSegurado);
        valorMensalidadeAdicional = valorMensalidadeAdicional.subtract(calcularDescontoMulher(mensalidade, this.sexoSegurado));
        mensalidade.setValorMensalidade(mensalidade.getValorBase().add(valorMensalidadeAdicional));
        return mensalidade;
    }

    private BigDecimal calcularDescontoMulher(Mensalidade mensalidade, Sexo sexoSegurado) {
        BigDecimal valorDescontoMulher;
        if(sexoSegurado.equals(Sexo.FEMININO)){
            valorDescontoMulher = mensalidade.getValorBase().multiply(new BigDecimal("5")).divide(new BigDecimal("100"));
        }else {valorDescontoMulher = BigDecimal.ZERO;}
        return valorDescontoMulher;
    }

    private BigDecimal calcularAdicionalFaixaEtaria(Mensalidade mensalidade, Integer idadeSegurado) {
        BigDecimal valorAdicionalFaixaEtaria;
        if(idadeSegurado >=18 && idadeSegurado <=30 ){
            valorAdicionalFaixaEtaria = mensalidade.getValorBase().multiply(new BigDecimal("1.5")).divide(new BigDecimal("100"));
        } else if(idadeSegurado > 31 && idadeSegurado <= 70){
                valorAdicionalFaixaEtaria = mensalidade.getValorBase().multiply(new BigDecimal("4")).divide(new BigDecimal("100"));
        } else if(idadeSegurado > 70){
                    valorAdicionalFaixaEtaria = mensalidade.getValorBase().multiply(new BigDecimal("10")).divide(new BigDecimal("100"));
        }else{valorAdicionalFaixaEtaria = BigDecimal.ZERO;}
        return valorAdicionalFaixaEtaria;
    }

    @Override
    public String toString() {
        return "SeguroVida{" +
                super.toString() +
                ", idadeSegurado=" + idadeSegurado + "\n" +
                ", sexoSegurado=" + sexoSegurado + "\n" +
                ", beneficiarios=" + beneficiarios + "\n" +
                ", capitalSegurado=" + capitalSegurado +
                "} ";
    }
}
