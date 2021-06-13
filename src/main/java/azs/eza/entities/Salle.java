package azs.eza.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Salle {
	@Id
	@GeneratedValue
	private Long idSalle;
	private String numSalle;
	public Salle(Long idSalle, String numSalle) {
		this.idSalle = idSalle;
		this.numSalle = numSalle;
	}
	public Long getIdSalle() {
		return idSalle;
	}
	public String getNumSalle() {
		return numSalle;
	}
	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}
	public void setNumSalle(String numSalle) {
		this.numSalle = numSalle;
	}
	@Override
	public String toString() {
		return "Salle [idSalle=" + idSalle + ", numSalle=" + numSalle + "]";
	}
	


}
