package ar.com.alk.disney.model.repository;

import ar.com.alk.disney.model.entity.PeliculaoSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaoSerieRepository extends JpaRepository<PeliculaoSerie, Long> {
}
