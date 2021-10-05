package ar.com.alk.disney.model.dto;

import ar.com.alk.disney.model.entity.Genero;
import ar.com.alk.disney.model.entity.PeliculaoSerie;
import ar.com.alk.disney.model.entity.Personaje;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//Deberá mostrar solamente los campos imagen, título y fecha de creación.
public class PeliculaoSerieResumenDTO {
    private Long id;
    @NotBlank(message = "Imagen es requerida")
    @Pattern(regexp = "http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?", message = "URL contiene caracteres invalidos")
    private String imagen;

    @NotBlank(message = "Titulo es requerido")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Titulo contiene caracteres invalidos")
    private String tituto;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha de creacion es requerida")
    @PastOrPresent(message = "La fecha de creacion puede ser pasada o presente")
    private Date fechaDeCreacion;

    public Boolean hasNullOrEmptyAttributes() {
        return imagen == null || imagen.trim().isEmpty()
                || tituto == null || tituto.trim().isEmpty()
                || fechaDeCreacion == null;
    }
}
