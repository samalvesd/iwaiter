package app.iwaiter.entities;

import jakarta.persistence.*;

@Entity
public class Mesa {
    @Id
    private Long numero;

    private Long capacidade;
    private Boolean disponivel;

    @ManyToOne
    private Garcom garcomResponsavel;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Long capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public Garcom getGarcomResponsavel() {
        return garcomResponsavel;
    }

    public void setGarcomResponsavel(Garcom garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
    }
}
