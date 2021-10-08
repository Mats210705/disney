package ar.com.alk.disney.model.dto;

import ar.com.alk.disney.model.entity.PeliculaoSerie;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GeneroDTO implements Serializable {
    private Long id;
    private String nombre;
    private String imageUrl;


    public List<PeliculaoSerie> pelicula_serie;

}

