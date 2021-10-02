package ar.com.alk.disney.model.entity;

import ar.com.alk.disney.model.entity.PeliculaoSerie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="personaje")
public class Personaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private float peso;

    @Column(nullable = false)
    private String imagenUrl;

    @Column(nullable = false)
    private String historia;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "pelicula_serie_personaje",
            joinColumns = @JoinColumn(name = "personaje_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_serie_id"))
    private List<PeliculaoSerie> pelicula_serie;


    
}
