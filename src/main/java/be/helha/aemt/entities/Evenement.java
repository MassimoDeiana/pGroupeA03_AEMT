package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
public class Evenement extends Activite{

		
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Seance seance;

	
	
	public Evenement(String nom, String description, Adresse adresse,Images image, Seance seance) {
		super(nom, description, adresse,image);
		this.seance = seance;
	}

	public Evenement() {}
	
	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
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
		Evenement other = (Evenement) obj;
		return Objects.equals(seance, other.seance);
	}

	@Override
	public String toString() {
		return "Evenement [seance=" + seance + "]";
	}
	
	

	
}
