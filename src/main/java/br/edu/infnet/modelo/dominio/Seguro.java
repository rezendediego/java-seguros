package br.edu.infnet.modelo.dominio;

import br.edu.infnet.modelo.dominio_enum.TipoSeguro;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public abstract class Seguro {
    private UUID idSeguro;
    private String nomeSegurado;
    private TipoSeguro tipoSeguro;
    private boolean autoRenovavel;
    private final LocalDateTime inicio;
    private Optional<LocalDateTime> fim;

    public Seguro(String nomeSegurado, TipoSeguro tipoSeguro, boolean autoRenovavel, LocalDateTime inicio, Optional<LocalDateTime> fim) {
        this.idSeguro = UUID.randomUUID();
        this.nomeSegurado = nomeSegurado;
        this.tipoSeguro = tipoSeguro;
        this.autoRenovavel = autoRenovavel;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Seguro(String nomeSegurado, TipoSeguro tipoSeguro, boolean autoRenovavel, LocalDateTime inicio) {
        this.idSeguro = UUID.randomUUID();
        this.nomeSegurado = nomeSegurado;
        this.tipoSeguro = tipoSeguro;
        this.autoRenovavel = autoRenovavel;
        this.inicio = inicio;
        this.fim = Optional.empty();
    }

    //Metodo Abstrato Feature-02
    public abstract Mensalidade calcularMensalidade(BigDecimal valorBase);

    public UUID getIdSeguro() {
        return idSeguro;
    }

    public String getNomeSegurado() {
        return nomeSegurado;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public boolean isAutoRenovavel() {
        return autoRenovavel;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public Optional<LocalDateTime> getFim() {
        return fim;
    }

    @Override
    public String toString() {
        if(fim.isEmpty()){
            return  "idSeguro=" + idSeguro + "\n" +
                    ", nomeSegurado='" + nomeSegurado + '\'' + "\n" +
                    ", tipoSeguro=" + tipoSeguro + "\n" +
                    ", autoRenovavel=" + autoRenovavel + "\n" +
                    ", inicio=" + inicio + "\n";
        }
        return  "idSeguro=" + idSeguro + "\n" +
                ", nomeSegurado='" + nomeSegurado + '\'' + "\n" +
                ", tipoSeguro=" + tipoSeguro + "\n" +
                ", autoRenovavel=" + autoRenovavel + "\n" +
                ", inicio=" + inicio + "\n" +
                ", fim=" + fim + "\n";
    }
}

