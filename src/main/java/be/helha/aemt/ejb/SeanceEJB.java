package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.SeanceDAO;
import be.helha.aemt.entities.Seance;

@Stateless
@LocalBean
public class SeanceEJB {

	@EJB
	private SeanceDAO dao;

	public Seance find(Integer id) {
		return dao.find(id);
	}

	public List<Seance> findAll() {
		return dao.findAll();
	}

	@Transactional
	public Seance add(Seance u) {
		return dao.add(u);
	}

	@Transactional
	public Seance delete(Seance u) {
		return dao.delete(u);
	}
}
