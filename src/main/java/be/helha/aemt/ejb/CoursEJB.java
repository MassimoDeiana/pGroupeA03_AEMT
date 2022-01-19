package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.CoursDAO;
import be.helha.aemt.entities.Cours;

@Stateless
@LocalBean
public class CoursEJB {

	@EJB
	private CoursDAO dao;

	public Cours find(Integer id) {
		return dao.find(id);
	}

	public List<Cours> findAll() {
		return dao.findAll();
	}

	@Transactional
	public Cours add(Cours u) {
		return dao.add(u);
	}

	@Transactional
	public Cours delete(Cours u) {
		return dao.delete(u);
	}
}
