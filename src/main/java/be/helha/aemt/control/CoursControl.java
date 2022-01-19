package be.helha.aemt.control;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.CoursEJB;
import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Cours;

@Named
@RequestScoped
public class CoursControl {

	@EJB
	private CoursEJB coursEJB;
	
	private Cours cours;
	
	@PostConstruct
	public void init() {
		cours = new Cours();
	}
	
	public void remove(Cours cours) {
	       coursEJB.delete(cours);
	    }
	
}
