package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Evenement;

@Stateless
@LocalBean
public class EvenementEJB  {

	@EJB
	private EvenementDAO dao;

	public Evenement find(Integer id) {
		return dao.find(id);
	}

	public List<Evenement> findAll() {
		return dao.findAll();
	}

	@Transactional
	public Evenement add(Evenement u) {
		return dao.add(u);
	}

	@Transactional
	public Evenement delete(Evenement u) {
		return dao.delete(u);
	}
}
