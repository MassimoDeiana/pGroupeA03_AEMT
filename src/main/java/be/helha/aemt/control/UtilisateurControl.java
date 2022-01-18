package be.helha.aemt.control;

import java.util.List;

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
	private Utilisateur t = new Utilisateur();
	
	@PostConstruct
	public void init() {
		utilisateur = new Utilisateur();
		t=utilisateur;
	}
	
	public String add() {
		ejb.add(utilisateur);
		return "listUtilisateur";
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur Utilisateur) {
		this.utilisateur = Utilisateur;
	}
    
	public List<Utilisateur> findAll() {
        return ejb.findAll();
    }
	
	public String doGetDetails(Utilisateur pub) {
		utilisateur = pub;
        return "detailUtilisateur";
    }
	
	public void remove(Utilisateur Utilisateur) {
       ejb.delete(Utilisateur);
    }
	
	
	
	public String updateDirection(Utilisateur pub) {
		utilisateur=pub;
		return "updateUtilisateur";
	}
	
	/*
	public String update() {
		System.out.println(t.toString());
		System.out.println(utilisateur.toString());
		ejb.update(t, utilisateur);
		return "listUtilisateur";
	}
	*/
	
	
}
