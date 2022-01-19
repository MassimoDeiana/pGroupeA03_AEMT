package be.helha.aemt.control;

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



	public void remove(Evenement evenement) {
		evenementEJB.delete(evenement);
	    }
	
	
	public String addEvenement() {
		evenement.setSeance(seance);
		evenement.setAdresse(adresse);
		evenementEJB.add(evenement);
		return "/listeActivite.xhtml?faces-redirect=true";
	}
	
}
