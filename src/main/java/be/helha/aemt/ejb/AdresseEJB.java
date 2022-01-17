package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.AdresseDAO;
import be.helha.aemt.entities.Adresse;

@Stateless
public class AdresseEJB implements IAdresseRemoteEJB {

	@EJB
	private AdresseDAO dao;

	@Override
	public Adresse find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<Adresse> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Adresse add(Adresse u) {
		return dao.add(u);
	}

	@Override
	@Transactional
	public Adresse delete(Adresse u) {
		return dao.delete(u);
	}
}
