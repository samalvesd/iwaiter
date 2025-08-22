package app.iwaiter.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "garcons")
public class Garcom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String fotoPerfil;

    @Column(unique = true)
    private String usuario;

    private String senha;
    private String tokenDispositivo;
    private String cpf;

    public Garcom() {
    }

    public Garcom(String nome, String fotoPerfil, String usuario, String senha, String cpf) {
        this.nome = nome;
        this.fotoPerfil = fotoPerfil;
        this.usuario = usuario;
        this.senha = senha;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTokenDispositivo() {
        return tokenDispositivo;
    }

    public void setTokenDispositivo(String tokenDispositivo) {
        this.tokenDispositivo = tokenDispositivo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
