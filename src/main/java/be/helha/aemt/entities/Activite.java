package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activite extends Evenement implements Serializable {
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Utilisateur instructeur;
	private double tarif;
	private String type;
	
	public Activite(String nom, String description, Adresse adresse, Date dateDebut, Date dateFin,
			int recurrence,Utilisateur instructeur, double tarif, String type) {
		super(nom,  description,  adresse,  dateDebut,  dateFin, recurrence);
		this.instructeur = instructeur;
		this.tarif = tarif;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Utilisateur getInstructeur() {
		return instructeur;
	}

	public void setInstructeur(Utilisateur instructeur) {
		this.instructeur = instructeur;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Activite [id=" + id + ", instructeur=" + instructeur + ", tarif=" + tarif + ", type=" + type + "]";
	}	

}
