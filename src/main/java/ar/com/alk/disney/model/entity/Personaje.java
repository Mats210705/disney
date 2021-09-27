package ar.com.alk.disney.model.entity;

import ar.com.alk.disney.model.entity.PeliculaoSerie;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="personaje")
public class Personaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private Integer edad;

    private String nombre;

    private float peso;

    private String imagenUrl;

    private String historia;


    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "pelicula_serie_personaje",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_serie_id"))
    private List<PeliculaoSerie> pelicula_serie;


    
}
