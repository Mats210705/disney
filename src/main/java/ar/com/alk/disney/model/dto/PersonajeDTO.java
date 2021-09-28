package ar.com.alk.disney.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PersonajeDTO implements Serializable {
    private Long id;
    private String imagen;
    private Integer edad;
    private float peso;
    private String historia;

    List<PeliculaoSerieDTO> peliculaoSerie;
}
