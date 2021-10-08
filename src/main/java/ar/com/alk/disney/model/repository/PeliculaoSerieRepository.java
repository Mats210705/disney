package ar.com.alk.disney.model.repository;

import ar.com.alk.disney.model.entity.PeliculaoSerie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//creamos una nueva interfaz y heredamos de ella de la siguiente manera.
public interface PeliculaoSerieRepository extends JpaRepository<PeliculaoSerie, Long> {

}
