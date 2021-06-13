package azs.eza.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Etudiants {
	@Id
	@GeneratedValue
	private Long idE;
	private String nomE;
	private String adresse;
	private int tel;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissanceE;
	
	@ManyToOne 
	@JoinColumn(name="idGroupe")
	private Groupe gr;

	public Long getIdE() {
		return idE;
	}

	public String getNomE() {
		return nomE;
	}



	public String getAdresse() {
		return adresse;
	}

	public int getTel() {
		return tel;
	}

	public Date getDateNaissanceE() {
		return dateNaissanceE;
	}

	public Groupe getGr() {
		return gr;
	}

	public void setIdE(Long idE) {
		this.idE = idE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}



	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public void setDateNaissanceE(Date dateNaissanceE) {
		this.dateNaissanceE = dateNaissanceE;
	}

	public void setGr(Groupe gr) {
		this.gr = gr;
	}

	@Override
	public String toString() {
		return "Etudiants [idE=" + idE + ", nomE=" + nomE  + ", adresse=" + adresse + ", tel="
				+ tel + ", dateNaissanceE=" + dateNaissanceE + ", gr=" + gr + "]";
	}

	public Etudiants(Long idE, String nomE, String adresse, int tel, Date dateNaissanceE, Groupe gr) {
		this.idE = idE;
		this.nomE = nomE;
		this.adresse = adresse;
		this.tel = tel;
		this.dateNaissanceE = dateNaissanceE;
		this.gr = gr;
	}
	
	


}