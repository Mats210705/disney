package ar.com.alk.disney.controller;

import ar.com.alk.disney.model.dto.GeneroDTO;

import ar.com.alk.disney.service.GeneroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "generos")

public class GeneroController {
    @Autowired
    private GeneroServices generoServices;
    //getAll
    @GetMapping({"/", ""})
    public ResponseEntity getGenerosMethod() {
        List<GeneroDTO> generos = generoServices.getAll();
        return ResponseEntity
                .ok()
                .body(generos);

    }
    //getById
    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity getGeneroByIdMethod(@PathVariable Long id) {

        GeneroDTO byId = generoServices.getById(id);

        return ResponseEntity
                .ok()
                .body(byId);
    }
    //Delete
    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity deleteGeneroByIdMethod(@PathVariable Long id) {

        generoServices.remove(id);

        return ResponseEntity
                .noContent()
                .build();
    }
    //guardar nuevos ingresos
    @PostMapping({"/", ""})
    public ResponseEntity postGeneroMethod(@Valid @RequestBody GeneroDTO dto) throws URISyntaxException {
        //Valid que tome en cuenta las q estan definidias en esta entidad
        // se llama al servicio y se le pide que guarde pelicula o serie
        GeneroDTO newGenero = generoServices.createNew(dto);

        URI uri = new URI("/Generos/" + newGenero.getId());

        return ResponseEntity
                .created(uri)
                .body(newGenero);
    }
}
