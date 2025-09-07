package app.iwaiter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChamadaDto {

    private Integer numeroMesa;
    private final String nome;
    private String usuario;

    @JsonProperty(value = "foto_perfil")
    private final String fotoPerfil;

    public ChamadaDto(String nome, String fotoPerfil) {
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
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
