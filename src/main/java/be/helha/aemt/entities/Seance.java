package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Date dateDebut;
	private Date duree;
	
	public Seance(Date dateDebut, Date duree) {
		super();
		this.dateDebut = dateDebut;
		this.duree = duree;
	}
	
	public Seance() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateDebut, duree);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seance other = (Seance) obj;
		return Objects.equals(dateDebut, other.dateDebut) && Objects.equals(duree, other.duree);
	}
	
	
	
}
