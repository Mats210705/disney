package ar.com.alk.disney.model.repository;

import ar.com.alk.disney.model.entity.Genero;
import ar.com.alk.disney.model.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
