package ar.com.alk.disney.model.repository;


import ar.com.alk.disney.model.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    public Optional<Personaje> findByImage(String imagen);
    public Optional<Personaje> findByName(String nombre);
}