package ar.com.alk.disney.model.dto;

import ar.com.alk.disney.model.entity.Genero;
import ar.com.alk.disney.model.entity.PeliculaoSerie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PeliculaSerieDescripcionDTO {
    private String titulo;
    private String imagen;
    private Date fechaDeCreacion;
    private Integer calificacion;
    private Set<PeliculaoSerie> peliculaoSerie;
    private Set<Genero>genero;
}
