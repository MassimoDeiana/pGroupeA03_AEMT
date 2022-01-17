package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.ActiviteDAO;
import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Evenement;

@Stateless
@LocalBean
public class ActiviteEJB implements IActiviteEJB {

	@EJB
	ActiviteDAO dao;

	@Override
	@Transactional
	public Activite add(Activite in) {
		return dao.add(in);
	}

	@Override
	@Transactional
	public Activite delete(Activite in) {
		return dao.delete(in);
	}

	@Override
	@Transactional
	public Activite update(Activite in1, Activite in2) {
		return dao.update(in1, in2);
	}

	@Override
	public Activite find(int id) {
		return dao.find(id);
	}

	@Override
	public List<Activite> findall() {
		return dao.findAll();
	}
	
}
