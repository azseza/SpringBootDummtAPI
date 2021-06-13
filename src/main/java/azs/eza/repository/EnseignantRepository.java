package azs.eza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import azs.eza.entities.Enseignant;

@RepositoryRestResource
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{
	
	@RestResource
	List<Enseignant> findByNomEnContaining(String nom);

}
