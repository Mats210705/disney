package ar.com.alk.disney.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GeneroDTO implements Serializable {
    private Long id;
    private String nombre;
    private String imagenUrl;


    @JsonIgnoreProperties({ "generos" })
    private PeliculaoSerieDTO peliculaoSeries;

    public Boolean hasNullOrEmptyAttributes() {
        return nombre == null || nombre.trim().isEmpty()
                || imagenUrl == null || imagenUrl.trim().isEmpty();
    }

}

