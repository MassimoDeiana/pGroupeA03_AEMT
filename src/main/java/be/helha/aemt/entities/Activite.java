package be.helha.aemt.entities;

import java.io.Serializable;  
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Activite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom,description;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Adresse adresse;

	@ManyToOne(cascade=CascadeType.PERSIST)
	private Images image;
	
	
	public Activite(String nom, String description, Adresse adresse,Images image) {
		super();
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.image=image;
	}

	public Activite() {}
	
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
	
	public Images getImage() {
		return image;
	}

	public void setImage(Images image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activite other = (Activite) obj;
		return Objects.equals(nom, other.nom);
	}

	@Override
	public String toString() {
		return "Activite [nom=" + nom + ", description=" + description + ", adresse=" + adresse + "]";
	}
	
	
	
	
}