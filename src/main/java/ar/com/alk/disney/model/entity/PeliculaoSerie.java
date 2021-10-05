package ar.com.alk.disney.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "pelicula_serie")


public class PeliculaoSerie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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



    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "pelicula_serie_personaje",
            joinColumns = @JoinColumn(name = "pelicula_serie_id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_id"))
    private Set<Personaje> personajes;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "pelicula_serie_genero",
            joinColumns = @JoinColumn(name = "pelicula_serie_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private Set<Genero> generos;
}


