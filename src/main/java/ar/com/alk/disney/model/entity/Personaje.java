package ar.com.alk.disney.model.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="personaje")
public class Personaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false)
    private float peso;

    @Column(nullable = false)
    private String imagenUrl;

    @Column(nullable = false)
    private String historia;
    private boolean deleted = Boolean.FALSE;




    @ManyToMany(mappedBy = "personajes")
    public List<PeliculaoSerie> peliculasoseries = new ArrayList<>();

    public void addPeliculaoSerie(PeliculaoSerie pais) {
        this.peliculasoseries.add(pais);
    }

    public void removePeliculaoSerie(PeliculaoSerie peliculaoSerie) {
        this.peliculasoseries.remove(peliculaoSerie);
    }


}
