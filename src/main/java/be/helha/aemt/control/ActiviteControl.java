package be.helha.aemt.control;

import java.awt.image.BufferedImage; 
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;  

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.imageio.ImageIO;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.swing.ImageIcon;


import be.helha.aemt.ejb.AtelierEJB;
import be.helha.aemt.ejb.CoursEJB;
import be.helha.aemt.ejb.EvenementEJB;
import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Cours;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class ActiviteControl {

	@EJB
	private EvenementEJB evenementEJB;
	
	@EJB
	private CoursEJB coursEJB;
	
	@EJB
	private AtelierEJB atelierEJB;
	
	@EJB
	private UtilisateurEJB utilisateurEJB;
	
	private Activite activite;
	
	private Utilisateur utilisateur;
    
    public List<Evenement> doFindAllEvenement() {
        return evenementEJB.findAll();
    }
    
    public List<Cours> doFindAllCours() {
        return coursEJB.findAll();
    }
    
        
    public List<Atelier> doFindAllAtelier() {
        return atelierEJB.findAll();
    }
    
    public String doGetDetails(Activite a) {
    	activite = a;
    	FacesContext.getCurrentInstance().getExternalContext().getFlash().put("activite", activite);
    	return "/detailActivite.xhtml?faces-redirect=true";
    }
    
    public Activite getActivite() {
		return activite;
	}
    
    public void doParticiper(Activite act) {
		Utilisateur tmp = utilisateurEJB.findByMail(
				new Utilisateur(
						FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName()
						)
				);
        utilisateur = tmp;
        tmp.addActivite(act);
        utilisateurEJB.update(utilisateur, tmp);
    }
   

	
    
    
}
