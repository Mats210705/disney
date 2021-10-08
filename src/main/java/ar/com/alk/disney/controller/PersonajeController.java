package ar.com.alk.disney.controller;

import ar.com.alk.disney.model.dto.PersonajeDTO;

import ar.com.alk.disney.service.PersonajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity getPersonajeByIdMethod(@PathVariable Long id) {
        PersonajeDTO byId = personajeServices.getById(id);
        return ResponseEntity
                .ok()
                .body(byId);

    }

    @GetMapping({"/{imagen}/"})
    public ResponseEntity getPersonajeByImagenMethod(@PathVariable String imagen) {

        PersonajeDTO byImagen = personajeServices.getByImage(imagen);
        return ResponseEntity
                .ok()
                .body(byImagen);


    }

    @GetMapping({"/{nombre}/"})
    public ResponseEntity getPersonajeByNombreMethod(@PathVariable String nombre) {
        PersonajeDTO byNombre = personajeServices.getByName(nombre);
        return ResponseEntity
                .ok()
                .body(byNombre);

    }
}
