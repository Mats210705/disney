package ar.com.alk.disney.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import java.io.Serializable;

import java.util.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "pelicula_serie")


public class PeliculaoSerie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pelicula_serie_id")
    private Long Id;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    private String titulo;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaDeCreacion;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "pelicula_serie_genero",
            joinColumns = @JoinColumn(name = "pelicula_serie_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id")
    )
    private List<Personaje> personajes = new ArrayList<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "pelicula_serie_genero",
            joinColumns = @JoinColumn(name = "pelicula_serie_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genero> generos = new ArrayList<>();


}


