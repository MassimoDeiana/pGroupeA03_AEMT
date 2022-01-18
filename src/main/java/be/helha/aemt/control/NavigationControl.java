package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.aemt.ejb.EntityEJB;
import be.helha.aemt.ejb.IAtelierRemoteEJB;
import be.helha.aemt.ejb.IEntityRemoteEJB;
import be.helha.aemt.ejb.IUtilisateurRemoteEJB;
import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class NavigationControl {
	
	
	@EJB
	IUtilisateurRemoteEJB utilisateurEJB;
	
	@EJB
	IAtelierRemoteEJB atelierEJB;
	
	
	public List<Utilisateur> doNext() {
		System.out.println(utilisateurEJB.findAll());
		return utilisateurEJB.findAll();

	}
	
	

}