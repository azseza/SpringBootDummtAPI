package azs.eza.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Cours {
	@Id
	@GeneratedValue
	private Long idC;
	private String intitule;
	@ManyToOne 
	@JoinColumn(name="idEnseignant")
	private Enseignant es;
	public Cours(Long idC, String intitule, Enseignant es) {
		this.idC = idC;
		this.intitule = intitule;
		this.es = es;
	}
	public Long getIdC() {
		return idC;
	}
	public String getIntitule() {
		return intitule;
	}
	public Enseignant getEs() {
		return es;
	}
	public void setIdC(Long idC) {
		this.idC = idC;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public void setEs(Enseignant es) {
		this.es = es;
	}
	@Override
	public String toString() {
		return "Cours [idC=" + idC + ", intitule=" + intitule + ", es=" + es + "]";
	}
	
	

}
