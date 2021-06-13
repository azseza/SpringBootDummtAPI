package azs.eza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import azs.eza.entities.Salle;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle, Long>{

}
