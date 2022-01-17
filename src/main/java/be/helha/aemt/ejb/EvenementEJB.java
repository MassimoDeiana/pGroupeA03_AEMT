package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Evenement;

@Stateless
public class EvenementEJB implements IEvenementRemoteEJB {

	@EJB
	private EvenementDAO dao;

	@Override
	public Evenement find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<Evenement> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Evenement add(Evenement u) {
		return dao.add(u);
	}

	@Override
	@Transactional
	public Evenement delete(Evenement u) {
		return dao.delete(u);
	}
}
