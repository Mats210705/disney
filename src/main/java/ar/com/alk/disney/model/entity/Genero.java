package ar.com.alk.disney.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="genero")
public class Genero implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long generoId;

    private String nombre;

    private String imagenUrl;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "pelicula_serie_genero",
            joinColumns = @JoinColumn(name = "genero_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_serie_id"))
    private List<PeliculaoSerie> pelicula_serie;
}
