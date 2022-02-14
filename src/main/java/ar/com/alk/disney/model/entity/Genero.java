package ar.com.alk.disney.model.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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


    @ManyToMany(mappedBy = "generos")
    public List<PeliculaoSerie> peliculasoseries = new ArrayList<>();

    public void addPeliculaoSerie(PeliculaoSerie pais) {
        this.peliculasoseries.add(pais);
    }

    public void removePeliculaoSerie(PeliculaoSerie peliculaoSerie) {
        this.peliculasoseries.remove(peliculaoSerie);
    }
}
