package app.iwaiter.entities;

import jakarta.persistence.*;

@Entity
public class Mesa {
    @Id
    private Long numero;
    private String restauranteID;

    @ManyToOne
    private Garcom garcomResponsavel;
}
