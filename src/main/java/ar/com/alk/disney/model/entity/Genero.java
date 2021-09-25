package ar.com.alk.disney.model.entity;

import java.util.List;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long generoId;

    private String nombre;

    private String imagenUrl;

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    private List<PeliculaoSerie> pelicula;

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<PeliculaoSerie> getPelicula() {
        return pelicula;
    }

    public void setPelicula(List<PeliculaoSerie> pelicula) {
        this.pelicula = pelicula;
    }
    
}
