package ar.com.alk.disney.model.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="pelicula_serie")
public class PeliculaoSerie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "pelicula_serie_id")
    private Long Id;

    @Column(nullable = false)
    private String imagenUrl;

    @Column(nullable = false)
    private String titulo;

    @Column(name = "fecha_creacion", nullable = false)
    private Date fechaDeCreacion;

    @Column(name= "calificacion", nullable = false)
    private Integer calificacion;
    


    @ManyToMany(mappedBy = "pelicula_serie")
    private Set<Personaje> personajes = new HashSet<>();

    @ManyToMany(mappedBy = "pelicula_serie")
    private Set<Genero> generos = new HashSet<>();





    
}


