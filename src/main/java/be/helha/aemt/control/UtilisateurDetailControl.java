package be.helha.aemt.control;

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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur Utilisateur) {
        this.utilisateur = Utilisateur;
    }

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

}