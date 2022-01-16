package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Atelier extends Activite{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double tarif;
	
	public Atelier(String nom, String description, Adresse adresse, Date dateDebut, Date dateFin,
			int recurrence,List<Utilisateur> instructeur, double tarif) {
		super(nom,  description,  adresse,  dateDebut,  dateFin,instructeur, recurrence);
		this.tarif = tarif;
	}


	public Atelier() {}
	

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

}
