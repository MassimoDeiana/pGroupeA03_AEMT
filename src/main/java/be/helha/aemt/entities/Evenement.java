package be.helha.aemt.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Evenement extends Activite{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Evenement(String nom, String description, Adresse adresse, Date dateDebut, Date dateFin,
			int recurrence) {
		super(nom,description,adresse,dateDebut,dateFin,recurrence);
	}
	
	public Evenement() {}
	
}
