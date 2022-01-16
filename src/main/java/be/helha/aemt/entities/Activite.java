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
	
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Utilisateur> instructeurs;
	
	private Date dateDebut,dateFin;
	private int recurrence;
	
	public Activite(String nom, String description, Adresse adresse, Date dateDebut, Date dateFin,
			int recurrence) {
		super();
		this.nom=nom;
		this.description=description;
		this.adresse=adresse;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.recurrence=recurrence;
	}
	
	public Activite(String nom, String description, Adresse adresse, Date dateDebut, Date dateFin,List<Utilisateur> instructeurs,
			int recurrence) {
		super();
		this.nom=nom;
		this.description=description;
		this.adresse=adresse;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.instructeurs=instructeurs;
		this.recurrence=recurrence;
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
	

	public List<Utilisateur> getInstructeurs() {
		return instructeurs;
	}

	public void setInstructeurs(List<Utilisateur> instructeurs) {
		this.instructeurs = instructeurs;
	}

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
		Activite other = (Activite) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(nom, other.nom);
	}
}