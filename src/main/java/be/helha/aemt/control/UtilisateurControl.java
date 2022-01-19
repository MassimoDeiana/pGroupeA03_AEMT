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

import be.helha.aemt.ejb.IUtilisateurRemoteEJB;
import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class UtilisateurControl {

	@EJB
	private UtilisateurEJB ejb;
	
	private Utilisateur utilisateur;
	
	@PostConstruct
	public void init() {
		utilisateur = new Utilisateur();
	}
	
	public String doAdd() {
		utilisateur.setRole("utilisateur");
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
	
	public Utilisateur getLogged() {
        Utilisateur u = new Utilisateur(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
        return ejb.findByMail(u);
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
	
	public int getSizeofActivities() {
		return getLogged().getActivites().size();
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
	
	
}
