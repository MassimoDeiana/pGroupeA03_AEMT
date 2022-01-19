package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.AtelierDAO;
import be.helha.aemt.entities.Atelier;

@Stateless
@LocalBean
public class AtelierEJB {

	@EJB
	private AtelierDAO dao;

	public Atelier find(Integer id) {
		return dao.find(id);
	}

	public List<Atelier> findAll() {
		return dao.findAll();
	}

	@Transactional
	public Atelier add(Atelier u) {
		return dao.add(u);
	}

	@Transactional
	public Atelier delete(Atelier u) {
		return dao.delete(u);
	}
}
