package br.com.damin.springscreen.repository;

import br.com.damin.springscreen.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Series, Long> {

}
