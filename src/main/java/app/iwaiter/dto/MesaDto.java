package app.iwaiter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesaDto {
    @JsonProperty(value = "numero_mesa")
    private final Integer numeroMesa;
    private final String status;
    private final Integer capacidade;
    @JsonProperty(value = "garcom_responsavel")
    private final String garcomResponsavelNome;
    @JsonProperty(value = "garcom_responsavel_id")
    private final Long garcomResponsavelId;

    public MesaDto(Integer numeroMesa, String status, Integer capacidade, String garcomResponsavelNome, Long garcomResponsavelId) {
        this.numeroMesa = numeroMesa;
        this.status = status;
        this.capacidade = capacidade;
        this.garcomResponsavelNome = garcomResponsavelNome;
        this.garcomResponsavelId = garcomResponsavelId;
    }

    public String getGarcomResponsavelNome() {
        return garcomResponsavelNome;
    }

    public Long getGarcomResponsavelId() {
        return garcomResponsavelId;
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
