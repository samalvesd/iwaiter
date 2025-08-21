package app.iwaiter.dto;

import app.iwaiter.entities.Garcom;

public class GarcomDto {

    private Long id;
    private String nome;
    private String fotoPerfil;

    public GarcomDto() {
    }

    public GarcomDto(Long id, String nome, String fotoPerfil) {
        this.id = id;
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
    }

    public GarcomDto(String nome, String fotoPerfil) {
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getFotoPerfil() { return fotoPerfil; }
}
