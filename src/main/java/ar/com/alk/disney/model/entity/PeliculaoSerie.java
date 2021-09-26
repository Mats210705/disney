package ar.com.alk.disney.model.entity;

import lombok.*;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="pelicula_serie")
public class PeliculaoSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pelicula_serie_id;

    @Column(nullable = false)
    private String imagenUrl;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Date fechaDeCreacion;

    @Column(nullable = false)
    private Integer calificacion;
    
    private List<Personaje> personaje;

    private List<Genero> genero;



    
}


