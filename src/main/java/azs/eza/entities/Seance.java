package azs.eza.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Seance {
	@Id
	@GeneratedValue
	private Long idSeance;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date dateNaissanceE;	
	@ManyToOne 
	@JoinColumn(name="idGroupe")
	private Groupe gr;
	@ManyToOne 
	@JoinColumn(name="idEnseignant")
	private Enseignant Es;
	
}
