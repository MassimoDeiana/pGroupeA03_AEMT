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
public class AtelierEJB implements IAtelierRemoteEJB {

	@EJB
	private AtelierDAO dao;

	@Override
	public Atelier find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<Atelier> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Atelier add(Atelier u) {
		return dao.add(u);
	}

	@Override
	@Transactional
	public Atelier delete(Atelier u) {
		return dao.delete(u);
	}
}
