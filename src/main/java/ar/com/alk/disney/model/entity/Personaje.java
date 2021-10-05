package ar.com.alk.disney.model.entity;

import ar.com.alk.disney.model.entity.PeliculaoSerie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private String imagen;

    @Column(nullable = false)
    private String historia;


    @ManyToMany(mappedBy = "personaje")
    private Set<PeliculaoSerie> peliculaoSeries = new HashSet<>();;


    
}
