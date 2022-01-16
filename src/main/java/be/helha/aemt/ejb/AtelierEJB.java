package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.transaction.Transactional;

import be.helha.aemt.dao.AtelierDAO;
import be.helha.aemt.entities.Atelier;

public class AtelierEJB implements IEntityRemoteEJB<Atelier> {

	@EJB
	private AtelierDAO dao;
	
	@Override
	@Transactional
	public Atelier add(Atelier in) {
		return dao.add(in);
	}

	@Override
	@Transactional
	public Atelier delete(Atelier in) {
		return dao.delete(in);
	}

	@Override
	@Transactional
	public Atelier update(Atelier in1, Atelier in2) {
		return dao.update(in1, in2);
	}

	@Override
	public Atelier find(int id) {
		return dao.find(id);
	}

	@Override
	public List<Atelier> findAll() {
		return dao.findAll();
	}

}
