package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.CoursDAO;
import be.helha.aemt.entities.Cours;

@Stateless
public class CoursEJB implements ICoursRemoteEJB {

	@EJB
	private CoursDAO dao;

	@Override
	public Cours find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<Cours> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Cours add(Cours u) {
		return dao.add(u);
	}

	@Override
	@Transactional
	public Cours delete(Cours u) {
		return dao.delete(u);
	}
}
