package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.transaction.Transactional;

import be.helha.aemt.dao.CoursDAO;
import be.helha.aemt.entities.Cours;

public class CoursEJB implements IEntityRemoteEJB<Cours>{

	@EJB
	private CoursDAO dao;
	
	@Override
	@Transactional
	public Cours add(Cours in) {
		return dao.add(in);
	}

	@Override
	@Transactional
	public Cours delete(Cours in) {
		return dao.delete(in);
	}

	@Override
	@Transactional
	public Cours update(Cours in1, Cours in2) {
		return dao.update(in1, in2);
	}

	@Override
	public Cours find(int id) {
		return dao.find(id);
	}

	@Override
	public List<Cours> findAll() {
		return dao.findAll();
	}

}
