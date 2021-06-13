package azs.eza.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import azs.eza.entities.Cours;

@RepositoryRestResource
public interface CoursRepository extends JpaRepository<Cours, Long>{
	
	@RestResource
	Cours findByEsIdEnEquals(Long idEns);

}
