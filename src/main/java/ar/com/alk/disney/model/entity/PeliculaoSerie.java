package ar.com.alk.disney.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
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
    private String imagenUrl;

    @Column(nullable = false)
    private String titulo;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaDeCreacion;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    private boolean deleted = Boolean.FALSE;

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


