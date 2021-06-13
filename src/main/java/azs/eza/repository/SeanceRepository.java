package azs.eza.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import azs.eza.entities.Seance;
@RepositoryRestResource
public interface SeanceRepository extends JpaRepository<Seance, Long>{
	@RestResource
	List<Seance> findByDateNaissanceE(Date x);
}
