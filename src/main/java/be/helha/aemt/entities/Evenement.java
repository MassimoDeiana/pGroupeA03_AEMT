package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evenement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom,description;
	private Adresse adresse;
	private Date dateDebut,dateFin;
	private int recurrence;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(int recurrence) {
		this.recurrence = recurrence;
	}
	
	public Evenement(String nom, String description, Adresse adresse, Date dateDebut, Date dateFin,
			int recurence) {
		super();
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.recurrence = recurence;
	}

	
	public Evenement() {}
	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, nom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evenement other = (Evenement) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(nom, other.nom);
	}
	
	
	
	
}
