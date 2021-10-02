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
    
    private Long id;
    @Column(nullable = false, length = 30)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String imagenUrl;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "pelicula_serie_genero",
            joinColumns = @JoinColumn(name = "genero_id"),
            inverseJoinColumns = @JoinColumn(name = "pelicula_serie_id"))
    private List<PeliculaoSerie> pelicula_serie;
}
