package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class UtilisateurControl {

	@EJB
	private UtilisateurEJB ejb;
	
	private Utilisateur utilisateur;
	private Utilisateur t = new Utilisateur();

	
	@PostConstruct
	public void init() {
		System.out.println(ejb);
		utilisateur = new Utilisateur();
		t = utilisateur;
	}
	
	public String doAdd() {
		utilisateur.setRole("utilisateur");
		ejb.add(utilisateur);
		return "listUtilisateur";
	}
	
	public String doAddWithAdmin() {
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
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("utilisateur", pub);
		utilisateur = pub;
        return "detailUtilisateur.xhtml?faces-redirect=true";
    }
	
	public void remove(Utilisateur Utilisateur) {
       ejb.delete(Utilisateur);
    }
	

	public String updateDirection(Utilisateur pub) {
		utilisateur=pub;
		return "updateUtilisateur";
	}
	
	public int getRole() {
		Utilisateur u = getLogged();
		if(u!=null)
		{
			switch(u.getRole())
			{
			case "admin":return 1;
			case "utilisateur":return 2;
			case "instructeur":return 2;
			default:return 0;
			}
		}
		return 0;
	}
	
	public Utilisateur getLogged() {
		Utilisateur u = new Utilisateur(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		return ejb.findByMail(u);
	}
	
	
}
