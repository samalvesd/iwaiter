package app.iwaiter.dto;

import app.iwaiter.entities.Garcom;

public class GarcomDto {

    private String nome;
    private String fotoPerfil;
    private String usuario;
    private String senha;
    private String cpf;

    public GarcomDto() {
    }

    public GarcomDto(String nome, String fotoPerfil) {
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
    }

    public GarcomDto(Long id, String nome, String fotoPerfil, String usuario, String senha, String cpf) {
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
        this.usuario = usuario;
        this.senha = senha;
        this.cpf = cpf;
    }

    public GarcomDto(Long id, String nome, String usuario) {
    }

    public String getNome() {
        return nome;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
