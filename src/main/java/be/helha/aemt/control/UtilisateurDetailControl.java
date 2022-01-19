package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class UtilisateurDetailControl {

    @EJB
    private UtilisateurEJB ejb;

    private Utilisateur utilisateur;

    public void removeActivite(Activite activite) {
        Utilisateur tmp = ejb.findByMail(
				new Utilisateur(
						FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName()
						)
				);
        utilisateur = tmp;
        tmp.removeActivite(activite);
        ejb.update(utilisateur, tmp);
    }

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

	public int getSizeofActivities() {
		if(utilisateur!=null)
			return utilisateur.getActivites().size();
		return 0;
    }
	
	public Utilisateur getLogged() {
		Utilisateur u = new Utilisateur(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		return ejb.findByMail(u);
	}
	
}
