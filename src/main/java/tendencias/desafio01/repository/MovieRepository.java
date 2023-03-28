package tendencias.desafio01.repository;

import org.springframework.data.repository.CrudRepository;
import tendencias.desafio01.entity.Movie;

import java.util.UUID;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
