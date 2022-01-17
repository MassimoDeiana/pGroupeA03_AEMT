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
public class Atelier extends Activite{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Seance seance;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Utilisateur instructeur;
	
	private double tarif;


	
	public Atelier(String nom, String description, Adresse adresse, Seance seance, Utilisateur instructeur,
			double tarif) {
		super(nom, description, adresse);
		this.seance = seance;
		this.instructeur = instructeur;
		this.tarif = tarif;
	}

	public Atelier() {}
	
	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Utilisateur getInstructeurs() {
		return instructeur;
	}

	public void setInstructeurs(Utilisateur instructeur) {
		this.instructeur = instructeur;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(seance);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atelier other = (Atelier) obj;
		return Objects.equals(seance, other.seance);
	}

	@Override
	public String toString() {
		return "Atelier [seance=" + seance + ", instructeur=" + instructeur + ", tarif=" + tarif + "]";
	}
	
	
	
	
}
