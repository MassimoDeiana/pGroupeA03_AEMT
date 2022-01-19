package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.ActiviteDAO;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean

public class ActiviteEJB {

	@EJB
	private ActiviteDAO dao;

	public Activite find(Integer id) {
		return dao.find(id);
	}

	public List<Activite> findAll() {
		return dao.findAll();
	}

	@Transactional
	public Activite add(Activite u) {
		return dao.add(u);
	}

	@Transactional
	public Activite delete(Activite u) {
		return dao.delete(u);
	}


	
}
