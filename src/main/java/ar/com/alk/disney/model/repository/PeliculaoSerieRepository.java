package ar.com.alk.disney.model.repository;

import ar.com.alk.disney.model.entity.PeliculaoSerie;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//creamos una nueva interfaz y heredamos de ella de la siguiente manera.
public interface PeliculaoSerieRepository extends JpaRepository<PeliculaoSerie, Long> {
    List<PeliculaoSerie> findAll(Specification<PeliculaoSerie> spec);
}
