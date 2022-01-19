package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class UtilisateurEJB implements IUtilisateurRemoteEJB {

	@EJB
	private UtilisateurDAO dao;
	
	@Override
	public Utilisateur find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<Utilisateur> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Utilisateur add(Utilisateur u) {
		return dao.add(u);
	}

	@Override
	@Transactional
	public Utilisateur delete(Utilisateur u) {
		return dao.delete(u);
	}

	@Override
	public Utilisateur findByMail(Utilisateur u) {
		return dao.findByMail(u);
	}

	@Override
	public Utilisateur update(Utilisateur u1, Utilisateur u2) {
		return dao.updateActivites(u1, u2);
	}
	
	public List<Utilisateur> findInstructeur(){
		return dao.findInstructeur();
	}

}
