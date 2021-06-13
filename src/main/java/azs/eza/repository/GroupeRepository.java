package azs.eza.repository;

import java.security.acl.Group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import azs.eza.entities.Groupe;

@RepositoryRestResource
public interface GroupeRepository extends JpaRepository<Groupe, Long>{


}
