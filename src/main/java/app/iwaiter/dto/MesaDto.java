package app.iwaiter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesaDto {
    @JsonProperty(value = "numero_mesa")
    private Integer numeroMesa;
    private String status;
    private Integer capacidade;
    @JsonProperty(value = "garcom_responsavel")
    private String garcomResponsavelNome;
    public MesaDto() {
    }

    public String getGarcomResponsavelNome() {
        return garcomResponsavelNome;
    }

    public MesaDto(Integer numeroMesa, String status, Integer capacidade, String garcomResponsavelNome) {
        this.numeroMesa = numeroMesa;
        this.status = status;
        this.capacidade = capacidade;
        this.garcomResponsavelNome = garcomResponsavelNome;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCapacidade() {
        return capacidade;
    }
}
