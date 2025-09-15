package app.iwaiter.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chamadas")
public class Chamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_mesa", nullable = false)
    private Integer numeroMesa;

    @Column(name = "horario_chamada", nullable = false)
    private LocalDateTime horarioChamada;

    @Column(name = "horario_finalizacao")
    private LocalDateTime horarioFinalizacao;

    @ManyToOne
    @JoinColumn(name = "garcom_id")
    private Garcom garcom;

    @Column(nullable = false)
    private ChamadaStatus status;

    public Chamada() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public LocalDateTime getHorarioChamada() {
        return horarioChamada;
    }

    public void setHorarioChamada(LocalDateTime horarioChamada) {
        this.horarioChamada = horarioChamada;
    }

    public LocalDateTime getHorarioFinalizacao() {
        return horarioFinalizacao;
    }

    public void setHorarioFinalizacao(LocalDateTime horarioFinalizacao) {
        this.horarioFinalizacao = horarioFinalizacao;
    }

    public Garcom getGarcom() {
        return garcom;
    }

    public void setGarcom(Garcom garcom) {
        this.garcom = garcom;
    }

    public ChamadaStatus getStatus() {
        return status;
    }

    public void setStatus(ChamadaStatus status) {
        this.status = status;
    }
}
