package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.CoursEJB;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Cours;
import be.helha.aemt.entities.Seance;

@Named
@RequestScoped
public class CoursControl {

	@EJB
	private CoursEJB coursEJB;
	
	private Cours cours;
	private Seance seance;
	
	@PostConstruct
	public void init() {
		cours = new Cours();
		seance = new Seance();
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

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}
	
	public String doGetDetails(Cours pub) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("cours", pub);
		cours = pub;
        return "/admin/detailCours.xhtml?faces-redirect=true";
    }
	
	
}
