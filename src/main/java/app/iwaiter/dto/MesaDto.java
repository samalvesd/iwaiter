package app.iwaiter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesaDto {
    @JsonProperty(value = "numero_mesa")
    private Integer numeroMesa;
    private String status;
    private Integer capacidade;

    public MesaDto() {
    }

    public MesaDto(Integer numeroMesa, String status, Integer capacidade) {
        this.numeroMesa = numeroMesa;
        this.status = status;
        this.capacidade = capacidade;
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
