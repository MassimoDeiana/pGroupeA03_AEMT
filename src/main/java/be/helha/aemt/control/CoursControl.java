package be.helha.aemt.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.CoursEJB;
import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Cours;
import be.helha.aemt.entities.Seance;

@Named
@RequestScoped
public class CoursControl {

	@EJB
	private CoursEJB coursEJB;
	
	private Cours cours;
	private List<Seance> seances;
	private Seance seance;
	
	
	private String dateDebut,dateFin;
	
	private Adresse adresse;
	
	@PostConstruct
	public void init() {
		cours = new Cours();
		adresse = new Adresse();
		seance = new Seance();
		seances = new ArrayList<Seance>();
	}
	
	public void remove(Cours cours) {
	       coursEJB.delete(cours);
	    }

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seance) {
		this.seances = seance;
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
	

	public String addCours() {
		
		
		seance.setDateDebut(new Date(dateDebut));
		seance.setDateFin(new Date(dateFin));
		cours.addSeance(seance);
		cours.setAdresse(adresse);
		coursEJB.add(cours);
		return "listAtelier";
	}
	
	public String doGetDetails(Cours pub) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("cours", pub);
		cours = pub;
        return "/admin/detailCours.xhtml?faces-redirect=true";
    }
	
	
}
