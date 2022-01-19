package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.IUtilisateurRemoteEJB;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Cours;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class ActiviteDetailControl {
	
	@EJB
	private IUtilisateurRemoteEJB ejb;

	private Activite activite;
	private Utilisateur utilisateur;
	
	@PostConstruct
	public void init() {
		activite = (Activite) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("activite");
	}
	
	public Activite getActivite() {
		return activite;
	}
	
	public int getTypeOfActivite() {
		if(activite != null) {
			if(activite.getClass().equals(Cours.class))
				return 1;
			else
				return 2;
		}
		return 0;
	}
	
	
}
