package ar.com.alk.disney.controller;

import ar.com.alk.disney.model.dto.PeliculaoSerieDTO;
import ar.com.alk.disney.model.entity.PeliculaoSerie;
import ar.com.alk.disney.service.PeliculaoSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disney/peliculaoSerie")
public class PeliculaoSerieController {
    @Autowired
    private PeliculaoSerieServices peliculaoSerieServicesservices;

    @PostMapping("/peliculaoSerie")
    public ResponseEntity<PeliculaoSerie>crearNew(@RequestBody PeliculaoSerie peliculaoserie){
        return ResponseEntity.ok(services.createNew(peliculaoserie));
    }

    @GetMapping({ "/", "" })
    public ResponseEntity<List<PeliculaoSerieDTO>> ge{
        return ResponseEntity.ok(service.getList());
    }




}
