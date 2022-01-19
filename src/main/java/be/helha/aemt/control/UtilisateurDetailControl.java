package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.IUtilisateurRemoteEJB;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class UtilisateurDetailControl {

	@EJB
	private IUtilisateurRemoteEJB ejb;
	
	private Utilisateur utilisateur;
	
	@PostConstruct
	public void init() {
		utilisateur = (Utilisateur) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("utilisateur");
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur Utilisateur) {
		this.utilisateur = Utilisateur;
	}
    
	public void removeActivite(Activite activite) {
		System.out.println("coucou");		
		Utilisateur tmp = utilisateur;
		tmp.removeActivite(activite);
		ejb.update(utilisateur, tmp);
		
	}
	
}
