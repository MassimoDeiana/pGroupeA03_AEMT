package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class UtilisateurEJB implements IUtilisateurRemoteEJB {

<<<<<<< HEAD
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
=======
    @EJB
    private UtilisateurDAO dao;

    @Override
    public Utilisateur find(Integer id) {
        return dao.find(id);
    }

    @Override
    @Transactional
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
>>>>>>> 3158ebe35b456c92f0f03c3995347e4443c6b332

}
