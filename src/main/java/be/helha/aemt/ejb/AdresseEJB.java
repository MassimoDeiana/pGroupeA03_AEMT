package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.AdresseDAO;
import be.helha.aemt.entities.Adresse;

@Stateless
@LocalBean
public class AdresseEJB {

	@EJB
	private AdresseDAO dao;

	public Adresse find(Integer id) {
		return dao.find(id);
	}

	public List<Adresse> findAll() {
		return dao.findAll();
	}

	@Transactional
	public Adresse add(Adresse u) {
		return dao.add(u);
	}

	@Transactional
	public Adresse delete(Adresse u) {
		return dao.delete(u);
	}
}
