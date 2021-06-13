package azs.eza.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Groupe {
	@Id
	@GeneratedValue
	private Long idG;
	private String nomG;
	@ManyToOne 
	@JoinColumn(name="idDelegue")
	private Etudiants et;
	@ManyToOne 
	@JoinColumn(name="idResponsable")
	private Enseignant es;
	public Groupe(Long idG, String nomG, Etudiants et, Enseignant es) {
		this.idG = idG;
		this.nomG = nomG;
		this.et = et;
		this.es = es;
		
	}
	public Long getIdG() {
		return idG;
	}
	public String getNomG() {
		return nomG;
	}
	public Etudiants getEt() {
		return et;
	}
	public Enseignant getEs() {
		return es;
	}
	public void setIdG(Long idG) {
		this.idG = idG;
	}
	public void setNomG(String nomG) {
		this.nomG = nomG;
	}
	public void setEt(Etudiants et) {
		this.et = et;
	}
	public void setEs(Enseignant es) {
		this.es = es;
	}
	@Override
	public String toString() {
		return "Groupe [idG=" + idG + ", nomG=" + nomG + ", et=" + et + ", es=" + es + "]";
	}
	
	
}
