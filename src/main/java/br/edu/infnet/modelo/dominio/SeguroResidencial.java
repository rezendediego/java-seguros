package br.edu.infnet.modelo.dominio;

import br.edu.infnet.excecao.SeguroNaoDisponivelException;
import br.edu.infnet.modelo.dominio_enum.TipoImovel;
import br.edu.infnet.modelo.dominio_enum.TipoSeguro;
import br.edu.infnet.utilitarios.validacao.ValidadorDisponibilidadeSeguroResidencial;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class SeguroResidencial extends Seguro{
    private TipoImovel tipoImovel;
    private Integer metrosQuadradosConstruidos;
    private BigDecimal valorIndenizacao;


    public SeguroResidencial(String nomeSegurado,
                             boolean autoRenovavel,
                             LocalDateTime inicio,
                             Optional<LocalDateTime> fim,
                             TipoImovel tipoImovel,
                             Integer metrosQuadradosConstruidos,
                             BigDecimal valorIndenizacao
                             ) {
        super(nomeSegurado, TipoSeguro.SEGURO_RESIDENCIAL, autoRenovavel, inicio, fim);
        this.tipoImovel = tipoImovel;
        this.metrosQuadradosConstruidos = metrosQuadradosConstruidos;
        this.valorIndenizacao = valorIndenizacao;
    }

    public SeguroResidencial(String nomeSegurado,
                             boolean autoRenovavel,
                             LocalDateTime inicio,
                             TipoImovel tipoImovel,
                             Integer metrosQuadradosConstruidos,
                             BigDecimal valorIndenizacao
    ) {
        super(nomeSegurado, TipoSeguro.SEGURO_RESIDENCIAL, autoRenovavel, inicio);
        this.tipoImovel = tipoImovel;
        this.metrosQuadradosConstruidos = metrosQuadradosConstruidos;
        this.valorIndenizacao = valorIndenizacao;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public Integer getMetrosQuadradosConstruidos() {
        return metrosQuadradosConstruidos;
    }

    public BigDecimal getValorIndenizacao() {
        return valorIndenizacao;
    }


    //Feature 04.2 Cada classe de negócio deve usar uma classe de exception.
    public Boolean modResidencialEstaDisponivel(ValidadorDisponibilidadeSeguroResidencial validadorDisponibilidadeSeguroResidencial) throws SeguroNaoDisponivelException {
        if(!validadorDisponibilidadeSeguroResidencial.getDisponibilidade()){
            throw new SeguroNaoDisponivelException("EXCEPTION_SEGURO_NAO_DISPONIVEL: A modalidade Seguro Residencial Nao está disponível");
        }else return true;
    }


    //FEATURE-02 Implementação
    @Override
    public Mensalidade calcularMensalidade(BigDecimal valorBase){
        Mensalidade mensalidade = new Mensalidade(valorBase);
        BigDecimal valorMensalidadeAdicional = calcularPorcentagemPorTipoImovel(mensalidade,this.getTipoImovel());
        valorMensalidadeAdicional = valorMensalidadeAdicional.add(calcularPorcentagemPorMetroQuadrado(mensalidade,this.getMetrosQuadradosConstruidos()));
        mensalidade.setValorMensalidade(mensalidade.getValorBase().add(valorMensalidadeAdicional));
        return mensalidade;
    }

    //Metodos Auxiliares
    private BigDecimal calcularPorcentagemPorTipoImovel(Mensalidade mensalidade, TipoImovel tipoImovel){

        BigDecimal valorCalculadoTipoImovel;

        //Adicionar porcentagem por tipo de imovel
        if(tipoImovel.equals(TipoImovel.CASA)){
            valorCalculadoTipoImovel = mensalidade.getValorBase().multiply(new BigDecimal("25")).divide(new BigDecimal("100"));
        } else if (tipoImovel.equals(TipoImovel.CASA_CONDOMINIO)) {
            valorCalculadoTipoImovel = mensalidade.getValorBase().multiply(new BigDecimal("8")).divide(new BigDecimal("100"));
        } else if (tipoImovel.equals(TipoImovel.APARTAMENTO)) {
            valorCalculadoTipoImovel = mensalidade.getValorBase().multiply(new BigDecimal("13")).divide(new BigDecimal("100"));
        } else{valorCalculadoTipoImovel = BigDecimal.ZERO;}

        return valorCalculadoTipoImovel;
    }

    private BigDecimal calcularPorcentagemPorMetroQuadrado(Mensalidade mensalidade, Integer metrosQuadrados){
        BigDecimal valorCalculadoPorMEtroQuadrado;

        //Adicionar porcentagem por metros quadrados
        if(metrosQuadrados <= 100){
            valorCalculadoPorMEtroQuadrado = mensalidade.getValorBase().multiply(new BigDecimal("3")).divide(new BigDecimal("100"));
        } else if (metrosQuadrados <= 500) {
            valorCalculadoPorMEtroQuadrado = mensalidade.getValorBase().multiply(new BigDecimal("5")).divide(new BigDecimal("100"));
        } else {
            valorCalculadoPorMEtroQuadrado = mensalidade.getValorBase().multiply(new BigDecimal("7")).divide(new BigDecimal("100"));
        }
        return valorCalculadoPorMEtroQuadrado;
    }

    @Override
    public String toString() {
        return "SeguroResidencial{" +
                super.toString() +
                ", tipoImovel=" + tipoImovel + "\n" +
                ", metrosQuadradosConstruidos=" + metrosQuadradosConstruidos + "\n" +
                ", valorIndenizacao=" + valorIndenizacao +
                "} ";
    }
}
