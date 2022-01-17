package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.SeanceDAO;
import be.helha.aemt.entities.Seance;

@Stateless
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
}
