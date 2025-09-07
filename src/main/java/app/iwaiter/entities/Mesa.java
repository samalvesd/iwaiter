package app.iwaiter.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mesas")
public class Mesa {
    @Id
    private Integer numeroMesa;

    @Column(nullable = false)
    private Integer capacidade;

    @Enumerated(EnumType.STRING)
    private MesaStatus status;

    @ManyToOne
    @JoinColumn(name = "garcom_responsavel")
    private Garcom garcomResponsavel;

    public Mesa() {
    }

    public Mesa(Integer numeroMesa, Integer capacidade, MesaStatus status) {
        this.numeroMesa = numeroMesa;
        this.capacidade = capacidade;
        this.status = status;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public MesaStatus getStatus() {
        return status;
    }

    public Garcom getGarcomResponsavel() {
        return garcomResponsavel;
    }

    public void setGarcomResponsavel(Garcom garcomResponsavel) {
        this.garcomResponsavel = garcomResponsavel;
    }
}
