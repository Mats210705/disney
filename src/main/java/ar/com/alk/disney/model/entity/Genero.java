package ar.com.alk.disney.model.entity;


import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
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
    private String imagen;


    @ManyToMany(mappedBy = "generos")
    public List<PeliculaoSerie> peliculasoseries = new ArrayList<>();
}
