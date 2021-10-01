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


@RestController
@RequestMapping(value="peliculaoSeries")

public class PeliculaoSerieController {
    @Autowired
    private PeliculaoSerieServices peliculaoSerieServices;



    @GetMapping({ "/", "" })
    public ResponseEntity getPeliculaoSerieMethod() {
        // se llama al servicio y se le pide el listado de peliculas y series
        List<PeliculaoSerieDTO> peliculaoSeries = peliculaoSerieServices.getAll();

        // se crea el response request
        return ResponseEntity
                .ok()
                .body(peliculaoSeries);
    }

    @GetMapping({ "/{id}", "/{id}/" })
    public ResponseEntity getPeliculaoSerieByIdMethod(@PathVariable Long id) {

        PeliculaoSerieDTO byId = peliculaoSerieServices.getById(id);

        return ResponseEntity
                .ok()
                .body(byId);
    }

    @PostMapping({ "/", "" })
    public ResponseEntity postPeliculaoSerieMethod(@Valid @RequestBody PeliculaoSerieDTO dto) throws URISyntaxException {
        //Valid que tome en cuenta las q estan definidias en esta entidad
        // se llama al servicio y se le pide que guarde pelicula o serie
        PeliculaoSerieDTO newPelicualoSerie= peliculaoSerieServices.createNew(dto);

        URI uri = new URI("/PeliculaoSeries/" + newPelicualoSerie.getId());

        return ResponseEntity
                .created(uri)
                .body(newPelicualoSerie);
    }




}
