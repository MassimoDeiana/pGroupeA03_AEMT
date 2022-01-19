package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.AtelierEJB;
import be.helha.aemt.ejb.CoursEJB;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Cours;

@Named
@RequestScoped
public class CoursDetailControl {

	@EJB
	private CoursEJB ejb;
	
	private Cours cours;
	
	@PostConstruct
	public void init() {
		cours = (Cours) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("cours");
	}
	
	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}
    

	
	public int getSizeofSeances() {
		if(cours.getSeances() != null)
			return 1;
		return 0;
    }
	

	
}
