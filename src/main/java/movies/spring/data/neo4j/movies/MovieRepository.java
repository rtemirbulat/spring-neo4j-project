package movies.spring.data.neo4j.movies;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(path = "movies")
@Tag(name = "movies")
interface MovieRepository extends Repository<Movie, String> {

	List<Movie> findAll();

	Optional<Movie> findById(String title);

	Optional<Movie> findOneByTitle(String title);

	List<Movie> findAllByTitleLikeIgnoreCase(String title);

	@RestResource(exported = false)
	List<Movie> findAllByDirectorsName(String name);

	@RestResource(exported = false)
	List<Movie> findAllByActorsPersonName(String name);
}
