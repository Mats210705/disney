package ar.com.alk.disney.controller;

import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;
import ar.com.alk.disney.service.PeliculaoSerieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;




@RestController//@RestController es un controller especial en RESTful de especificacion y equivale
// a la suma de @Controller y @ResponseBody.


public class PeliculaoSerieController {
    @Autowired
    private PeliculaoSerieServices peliculaoSerieServices;


    //getAll
    @GetMapping({"/", ""})
    public ResponseEntity getPeliculasoSeriesMethod() {
        // se llama al servicio y se le pide el listado de peliculas y series
        List<PeliculaoSerieDTO> peliculasoSeries = peliculaoSerieServices.getAll();

        // se crea el response request
        return ResponseEntity
                .ok()
                .body(peliculasoSeries);
    }

    //get by id
    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity getPeliculaoSerieByIdMethod(@PathVariable Long id) {

        PeliculaoSerieDTO byId = peliculaoSerieServices.getById(id);

        return ResponseEntity
                .ok()
                .body(byId);
    }


        @PostMapping({"/personajes/{personajesId}/PeliculaoSeries ","/personajes/{personajesId}/PeliculaoSeries " })
    public ResponseEntity postPersonajeMethod(@Valid @RequestBody PeliculaoSerieDTO dto, @PathVariable Long personajesId ) throws URISyntaxException {
        //Valid que tome en cuenta las q estan definidias en esta entidad
        // se llama al servicio y se le pide que guarde pelicula o serie
        PeliculaoSerieDTO newPelicualoSerie = peliculaoSerieServices.createNew(dto, personajesId);

        URI uri = new URI("/personaje/" + newPelicualoSerie.getId());

        return ResponseEntity
                .created(uri)
                .body(newPelicualoSerie);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity deletePeliculaoSerieByIdMethod(@PathVariable Long id) {

        peliculaoSerieServices.remove(id);

        return ResponseEntity
                .noContent()
                .build();
    }


}
