package azs.eza.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Enseignant {
	@Id
	@GeneratedValue
	private Long idEn;
	private String nomEn;
	private String adresseEn;
	private int telEn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissanceEn;
	private String email;
	public Enseignant(Long idE, String nomE, String adresse, int tel, Date dateNaissanceE, String email) {
		this.idEn = idE;
		this.nomEn = nomE;
		this.adresseEn = adresse;
		this.telEn = tel;
		this.dateNaissanceEn = dateNaissanceE;
		this.email = email;
	}
	public Long getIdE() {
		return idEn;
	}
	public String getNomE() {
		return nomEn;
	}
	public String getAdresse() {
		return adresseEn;
	}
	public int getTel() {
		return telEn;
	}
	public Date getDateNaissanceE() {
		return dateNaissanceEn;
	}
	public String getEmail() {
		return email;
	}
	public void setIdE(Long idE) {
		this.idEn = idE;
	}
	public void setNomE(String nomE) {
		this.nomEn = nomE;
	}
	public void setAdresse(String adresse) {
		this.adresseEn = adresse;
	}
	public void setTel(int tel) {
		this.telEn = tel;
	}
	public void setDateNaissanceE(Date dateNaissanceE) {
		this.dateNaissanceEn = dateNaissanceE;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Enseignant [idE=" + idEn + ", nomE=" + nomEn + ", adresse=" + adresseEn + ", tel=" + telEn
				+ ", dateNaissanceE=" + dateNaissanceEn + ", email=" + email + "]";
	}
	
	
}
