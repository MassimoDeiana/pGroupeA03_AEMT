package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.AtelierEJB;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Atelier;

@Named
@RequestScoped
public class AtelierDetailControl {

	@EJB
	private AtelierEJB ejb;
	
	private Atelier atelier;
	
	@PostConstruct
	public void init() {
		atelier = (Atelier) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("atelier");
	}
	
	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}
    

	
	public int getSizeofSeances() {
		if(atelier.getSeance() != null)
			return 1;
		return 0;
    }
	

	
}
