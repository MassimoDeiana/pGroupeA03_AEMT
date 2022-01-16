package be.helha.aemt.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Cours extends Activite{
	
	/**
	 
	private static final long serialVersionUID = 1L;

	private double tarif;
	
	public Cours(String nom, String description, Adresse adresse, Date dateDebut, Date dateFin,
			int recurrence,List<Utilisateur> instructeurs, double tarif) {
		super(nom,  description,  adresse,  dateDebut,  dateFin, instructeurs, recurrence);
		this.tarif = tarif;
	}
	

	public Cours() {}



	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
*/

}
