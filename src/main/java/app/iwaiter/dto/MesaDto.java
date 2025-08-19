package app.iwaiter.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class MesaDto {

    private Long numeroMesa;
    private Long capacidade;
    private Boolean disponivel;
    private String nomeGarcomResponsavel;

    public Long getNumeroMesa() { return numeroMesa; }

    public Long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Long capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getNomeGarcomResponsavel() {
        return nomeGarcomResponsavel;
    }

    public void setNomeGarcomResponsavel(String nomeGarcomResponsavel) {
        this.nomeGarcomResponsavel = nomeGarcomResponsavel;
    }
}
