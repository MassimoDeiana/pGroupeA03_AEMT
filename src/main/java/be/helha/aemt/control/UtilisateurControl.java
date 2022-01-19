package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Activite;
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
		try {
			utilisateur.setMdp(encode(utilisateur.getMdp()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ejb.add(utilisateur);
		return "listUtilisateur";
	}
	
	public String doAddWithAdmin() {
		try {
			utilisateur.setMdp(encode(utilisateur.getMdp()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	

	public void removeActivite(Activite activite,Utilisateur u) {		
		Utilisateur tmp = ejb.findByMail(u);
        utilisateur = tmp;
        tmp.removeActivite(activite);
        ejb.update(utilisateur, tmp);
		
	}
	
	
	
	public static String encode(final String clearText) throws NoSuchAlgorithmException {
        return new String(
                Base64.getEncoder().encode(MessageDigest.getInstance("SHA-256").digest(clearText.getBytes(StandardCharsets.UTF_8))));
    }
	
	
}
