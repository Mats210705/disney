package ar.com.alk.disney.controller;

import ar.com.alk.disney.model.dto.PersonajeDTO;
import ar.com.alk.disney.service.PersonajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("personajes")//Pone la raíz para la URI a acceder al servicio Rest
public class PersonajeController {

    @Autowired
    private PersonajeServices personajeServices;

    @GetMapping({"/", ""})//GET para la configuración de páginas web (filtros, ordenación, búsquedas, etc.)
    public ResponseEntity getPersonajesMethod() {
        // se llama al servicio y se le pide el listado de personajes
        List<PersonajeDTO> personajes = personajeServices.getAll();
        return ResponseEntity
                .ok()
                .body(personajes);

    }
   //mostrar por id
    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity getPersonajeByIdMethod(@PathVariable Long id) {
        PersonajeDTO byId = personajeServices.getById(id);
        return ResponseEntity
                .ok()
                .body(byId);

    }




    @PostMapping({ "/", "" })
    public ResponseEntity postPersonajeMethod(@Valid @RequestBody PersonajeDTO dto) throws URISyntaxException {
        //Valid que tome en cuenta las q estan definidias en esta entidad
        // se llama al servicio y se le pide que guarde personaje
        PersonajeDTO newPersonaje= personajeServices.createNew(dto);

        URI uri = new URI("/Personaje/" + newPersonaje.getId());

        return ResponseEntity
                .created(uri)
                .body(newPersonaje);
    }
    @DeleteMapping({ "/{id}", "/{id}/" })
    public ResponseEntity deletePersonajeByIdMethod(@PathVariable Long id){

        personajeServices.remove(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
