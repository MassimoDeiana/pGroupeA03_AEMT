package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import be.helha.aemt.ejb.AtelierEJB;
import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class NavigationControl {
	
	
	@EJB
	UtilisateurEJB utilisateurEJB;
	
	@EJB
	AtelierEJB atelierEJB;
	
	
	public List<Utilisateur> doNext() {
		System.out.println(utilisateurEJB.findAll());
		return utilisateurEJB.findAll();

	}
	
	public String doRegister() {
		return "/register.xhtml?faces-redirect=true";
	}

    public String doLogin() {
        return "/login.xhtml?faces-redirect=true";
    }

    public String doQuiSommesNous() {
        return "/quiSommesNous.xhtml?faces-redirect=true";
    }

    public String doAteliers() {
        return "/ateliers.xhtml?faces-redirect=true";
    }

    public String doPleineConscience() {
        return "/pleineConscience.xhtml?faces-redirect=true";
    }

    public String doAgenda() {
		return "/agenda.xhtml?faces-redirect=true";
	}
    
    public String doProfil() {
        return "/utilisateur/profil.xhtml?faces-redirect=true";
    }
	
	public String doIndexAdmin() {
		return "/admin/indexAdmin.xhtml?faces-redirect=true";
	}

	public String doAjoutAtelier() {
		return "/admin/ajoutAtelier.xhmlt?faces-redirect=true";
	}
	
	public String doAjoutCours() {
		return "/admin/ajoutCours.xhtml?faces-redirect=true";
	}
	
	public String doAjoutEvenement() {
		return "/admin/ajoutEvenement.xhtml?faces-redirect=true";
	}
	
	public String doAjoutUtilisateur() {
		return "/admin/ajoutUtilisateur.xhtml?face-redirect=true";
	}
	
	public String doListeUtilisateur() {
		return "/admin/listeUtilisateur.xhtml?face-redirect=true";
	}
	
	public String doListeActivite() {
		return "/admin/listeActivite.xhtml?face-redirect=true";
	}
	
	
	
	
}