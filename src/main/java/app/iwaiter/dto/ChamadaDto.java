package app.iwaiter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ChamadaDto {

    private Long id;

    @JsonProperty("numero_mesa")
    private Integer numeroMesa;
    private String nome;
    private String usuario;
    private LocalDateTime horarioChamada;

    @JsonProperty(value = "foto_perfil")
    private String fotoPerfil;

    public ChamadaDto() {
    }

    public ChamadaDto(Long id, Integer numeroMesa, LocalDateTime horarioChamada) {
        this.id = id;
        this.numeroMesa = numeroMesa;
        this.horarioChamada = horarioChamada;
    }

    public ChamadaDto(String nome, String fotoPerfil) {
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
    }

    public LocalDateTime getHorarioChamada() {
        return horarioChamada;
    }

    public void setHorarioChamada(LocalDateTime horarioChamada) {
        this.horarioChamada = horarioChamada;
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }
}
