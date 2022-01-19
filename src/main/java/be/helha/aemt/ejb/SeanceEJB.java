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
public class SeanceEJB implements ISeanceRemoteEJB {

	@EJB
	private SeanceDAO dao;

	@Override
	public Seance find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<Seance> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Seance add(Seance u) {
		return dao.add(u);
	}

	@Override
	@Transactional
	public Seance delete(Seance u) {
		return dao.delete(u);
	}
	
	public List<Seance> getAtelierSeance(Integer id) {
		return dao.getAtelierSeance(id);
	}
	
	public List<Seance> getEvenementSeance(Integer id) {
		return dao.getEvenementSeance(id);
	}

	public List<Seance> getCoursSeance(Integer id) {
		return dao.getCoursSeance(id);
	}

}
