package ar.com.alk.disney.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PeliculaoSerieDTO implements Serializable {

    private Long id;
    @NotBlank(message = "Imagen es requerida")
    @Pattern(regexp = "http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?", message = "URL contiene caracteres invalidos")
    private String imagenUrl;

    @NotBlank(message = "Titulo es requerido")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Titulo contiene caracteres invalidos")
    private String tituto;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha de creacion es requerida")
    @PastOrPresent(message = "La fecha de creacion puede ser pasada o presente")
    private Date fechaDeCreacion;

    @NotBlank(message = "La calificacion es requerido")
    @Pattern(regexp = "[1,2,3,4,5]", message = "Calificacion contiene caracteres invalidos")
    private Integer calificacion;

   /* @JsonIgnoreProperties({"peliculaoSeries"})
    private GeneroDTO genero;

    @JsonIgnoreProperties({"peliculaoSeries"})
    private GeneroDTO personaje;*/



    public Boolean hasNullOrEmptyAttributes() {
        return imagenUrl == null || imagenUrl.trim().isEmpty()
                || tituto == null || tituto.trim().isEmpty()
                || fechaDeCreacion == null
                || calificacion == null;

    }


}
