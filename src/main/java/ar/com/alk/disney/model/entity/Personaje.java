package ar.com.alk.disney.model.entity;

import ar.com.alk.disney.model.entity.PeliculaoSerie;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Personaje")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long personajeId;

    private Integer edad;

    private String nombre;

    private Double peso;

    private String imagenUrl;

    private String historia;

    private List<PeliculaoSerie> peliculas;

    public Long getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(Long personajeId) {
        this.personajeId = personajeId;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<PeliculaoSerie> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculaoSerie> peliculas) {
        this.peliculas = peliculas;
    }

   

    
}
