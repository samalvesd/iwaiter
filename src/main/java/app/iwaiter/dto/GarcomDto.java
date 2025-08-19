package app.iwaiter.dto;

import app.iwaiter.entities.Garcom;

public class GarcomDto {

    private final Long id;
    private final String nome;
    private final String fotoPerfil;

    public GarcomDto(Long id, String nome, String fotoPerfil) {
        this.id = id;
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getFotoPerfil() { return fotoPerfil; }
}
