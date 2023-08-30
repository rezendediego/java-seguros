package br.edu.infnet.modelo.dominio;

import java.math.BigDecimal;

public class Mensalidade {
    private final BigDecimal valorBase;
    private BigDecimal valorMensalidade;

    public Mensalidade(BigDecimal valorBase) {
        this.valorBase = valorBase;
    }

    public void setValorMensalidade(BigDecimal valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public BigDecimal getValorBase() {
        return valorBase;
    }

    public BigDecimal getValorMensalidade() {
        return valorMensalidade;
    }

    @Override
    public String toString() {
        return "Mensalidade{" +
                "valorMensalidade=" + valorMensalidade +
                '}';
    }
}
