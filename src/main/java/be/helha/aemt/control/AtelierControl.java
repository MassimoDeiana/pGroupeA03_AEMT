package be.helha.aemt.control;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.IAtelierRemoteEJB;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.ejb.IAdresseRemoteEJB;
import be.helha.aemt.ejb.IAtelierRemoteEJB;
import be.helha.aemt.ejb.ISeanceRemoteEJB;
import be.helha.aemt.ejb.IUtilisateurRemoteEJB;
import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Seance;
import be.helha.aemt.entities.Utilisateur;

@Named
@RequestScoped
public class AtelierControl {


	
	@EJB
	private IAtelierRemoteEJB atelierEJB;
	private Atelier atelier;

	
	@EJB
	private UtilisateurEJB uEJB;
    private List<Utilisateur> instructeurs;

    @EJB
    private ISeanceRemoteEJB seanceEJB;
	private Seance seance;
	
	private Adresse adresse;

	
	@PostConstruct
	public void init() {
		atelier = new Atelier();
		seance = new Seance();
		adresse = new Adresse();
		instructeurs = new ArrayList<Utilisateur>();
		instructeurs = doFindAllInstructeur();
	
	}
	
	public List<Utilisateur> findInstructeur(){
		return uEJB.findInstructeur();
	}
	
	public List<Utilisateur> getInstructeurs() {
		return instructeurs;
	}

	public void setInstructeurs(List<Utilisateur> instructeurs) {
		this.instructeurs = instructeurs;
	}

	public String addAtelier() {
		System.out.println(seance.getDateDebut() + " : " + seance.getDateFin());
		atelier.setSeance(seance);
		atelier.setAdresse(adresse);
		atelierEJB.add(atelier);
		return "listAtelier";
	}
	
	
	
	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier Atelier) {
		this.atelier = Atelier;
	}
	
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public List<Atelier> findAll() {
        return atelierEJB.findAll();
    }
	
	public List<Utilisateur> doFindAllInstructeur() {
		return uEJB.findInstructeur();
	}
	
	public String doGetDetails(Atelier pub) {
		atelier = pub;
        return "detail";
    }
	
	public void remove(Atelier atelier) {
       atelierEJB.delete(atelier);
    }
	
	public String updateDirection(Atelier pub) {
		atelier=pub;
		return "updateAtelier";
	}

	
}
