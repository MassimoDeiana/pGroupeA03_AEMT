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
	private double tarif;
	private String type;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Seance> seances;
	
	
	public Activite(String nom, String description, Adresse adresse, String type, List<Utilisateur> instructeurs, double tarif, List<Seance> seances) {
		super();
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.type=type;
		this.instructeurs = instructeurs;
		this.tarif = tarif;
		this.seances = seances;
	}
	
	public Activite(String nom, String description, Adresse adresse, String type) {
		super();
		this.nom = nom;
		this.description = description;
		this.adresse = adresse;
		this.type=type;
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

	public List<Utilisateur> getInstructeurs() {
		return instructeurs;
	}

	public void setInstructeurs(List<Utilisateur> instructeurs) {
		this.instructeurs = instructeurs;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom, seances, type);
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
		return Objects.equals(nom, other.nom) && Objects.equals(seances, other.seances)
				&& Objects.equals(type, other.type);
	}

	
	
	
	
	
	
}