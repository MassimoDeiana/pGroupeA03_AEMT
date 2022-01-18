package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.IUtilisateurRemoteEJB;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class UtilisateurControl {

	@EJB
	private IUtilisateurRemoteEJB ejb;
	
	private Utilisateur utilisateur;
	
	@PostConstruct
	public void init() {
		utilisateur = new Utilisateur();
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public String doAdd() {
		utilisateur.setRole("utilisateur");
		ejb.add(utilisateur);
		return "index";
	}
}
