package be.helha.aemt.control;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.CoursEJB;
import be.helha.aemt.ejb.EvenementEJB;
import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Cours;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Seance;

@Named
@RequestScoped
public class EvenementControl {

	@EJB
	private EvenementEJB evenementEJB;
	
	private Evenement evenement;
	private Seance seance;
	private Adresse adresse;
	
	private String dateDebut,dateFin;
	
	@PostConstruct
	public void init() {
		evenement = new Evenement();
		seance = new Seance();
		adresse = new Adresse();
	}
	
	
	
	public Evenement getEvenement() {
		return evenement;
	}



	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}



	public Seance getSeance() {
		return seance;
	}



	public void setSeance(Seance seance) {
		this.seance = seance;
	}



	public Adresse getAdresse() {
		return adresse;
	}



	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

	public String getDateDebut() {
		return dateDebut;
	}



	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}



	public String getDateFin() {
		return dateFin;
	}



	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}



	public void remove(Evenement evenement) {
		evenementEJB.delete(evenement);
	    }
	
	
	public String addEvenement() {
		
		
		seance.setDateDebut(new Date(dateDebut));
		seance.setDateFin(new Date(dateFin));
		evenement.setSeance(seance);
		evenement.setAdresse(adresse);
		evenementEJB.add(evenement);
		return "/listeActivite.xhtml?faces-redirect=true";
	}
	
}
