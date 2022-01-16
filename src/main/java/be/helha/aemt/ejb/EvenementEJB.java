package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Evenement;

@Stateless
@LocalBean
public class EvenementEJB implements IEntityRemoteEJB<Evenement> {

	@EJB
	private EvenementDAO dao;

	@Override
	@Transactional
	public Evenement add(Evenement in) {
		return dao.add(in);
	}

	@Override
	@Transactional
	public Evenement delete(Evenement in) {
		return dao.delete(in);
	}

	@Override
	@Transactional
	public Evenement update(Evenement in1, Evenement in2) {
		return dao.update(in1, in2);
	}

	@Override
	public Evenement find(int id) {
		return dao.find(id);
	}

	@Override
	public List<Evenement> findAll() {
		return dao.findAll();
	}


	
	
	
}
