package be.helha.aemt.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cours extends Activite{
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Seance> seances;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Utilisateur instructeur;
	
	private double tarif;
	
	public Cours(String nom, String description, Adresse adresse, Utilisateur instructeur,
			double tarif) {
		super(nom, description, adresse);
		this.seances = new ArrayList<Seance>();
		this.instructeur = instructeur;
		this.tarif = tarif;
	}
	
	
	public Cours(String nom, String description, Adresse adresse,Images image, Utilisateur instructeur,
			double tarif) {
		super(nom, description, adresse,image);
		this.seances = new ArrayList<Seance>();
		this.instructeur = instructeur;
		this.tarif = tarif;
	}
	
	public Cours() {
		this.seances = new ArrayList<Seance>();
	}

	public List<Seance> getSeances() {
		List<Seance> sortedList = seances.stream()
			.sorted(Comparator.comparing(Seance::getDateDebut))
			.collect(Collectors.toList());
		return sortedList;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}
	
	public boolean addSeance(Seance t)
	{
		if(t==null)
			return false;
		if(seances.contains(t))
			return false;
		return seances.add(t);
	}

	public Utilisateur getInstructeur() {
		return instructeur;
	}

	public void setInstructeur(Utilisateur instructeur) {
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
		result = prime * result + Objects.hash(seances);
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
		Cours other = (Cours) obj;
		return Objects.equals(seances, other.seances);
	}

	@Override
	public String toString() {
		return "Cours [seances=" + seances + ", instructeur=" + instructeur + ", tarif=" + tarif + "]";
	}

	
	
	

	

}
