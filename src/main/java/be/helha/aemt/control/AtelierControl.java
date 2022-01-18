package be.helha.aemt.control;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.IAtelierRemoteEJB;
import be.helha.aemt.entities.Atelier;

@Named
@RequestScoped
public class AtelierControl {

	@EJB
	IAtelierRemoteEJB ejb;
	
	public List<Atelier> doFindAll() {
		return ejb.findAll();
	}
}
