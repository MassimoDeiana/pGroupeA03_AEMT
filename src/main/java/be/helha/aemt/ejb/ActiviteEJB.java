package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.ActiviteDAO;
import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class ActiviteEJB implements IActiviteRemoteEJB {

	@EJB
	private ActiviteDAO dao;

	@Override
	public Activite find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<Activite> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Activite add(Activite u) {
		return dao.add(u);
	}

	@Override
	@Transactional
	public Activite delete(Activite u) {
		return dao.delete(u);
	}


	
}
