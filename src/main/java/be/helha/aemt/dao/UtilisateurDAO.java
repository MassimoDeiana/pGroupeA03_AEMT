package be.helha.aemt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Seance;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class UtilisateurDAO extends DAOJTA<Utilisateur> {
	
	@EJB
	private ActiviteDAO aDao;
	
    public Utilisateur find(Integer id) {
        if(id == null) 
            return null;

        Utilisateur find = em.find(Utilisateur.class, id);

        return find;
    }

    public Utilisateur findByMail(Utilisateur u) {
        if(u == null) {
            return null;
        }
        String qUtilisateur = "Select u from Utilisateur u where u.mail=:mail";
        Query queryUtilisateur = em.createQuery(qUtilisateur);

        queryUtilisateur.setParameter("mail", u.getMail());

        List<Utilisateur> utilisateurList = queryUtilisateur.getResultList();

        return utilisateurList.isEmpty()?null : utilisateurList.get(0);
    }

    @Transactional
    public List<Utilisateur> findAll() {
        String aFind = "SELECT u FROM Utilisateur u";
        TypedQuery<Utilisateur> qFind = em.createQuery(aFind, Utilisateur.class);
        List<Utilisateur> results = qFind.getResultList();

        return results.isEmpty()?null : results;
    }

    @Transactional
    public Utilisateur add(Utilisateur t) {
        if(t == null)
            return null;

        Utilisateur uBD = findByMail(t);

        if(uBD != null) {
            return null;
        }
        

		List<Activite> list = new ArrayList<Activite>();
		
		for (Activite u : t.getActivites()) {
			
			Activite uDB = aDao.findByActivite(u);
		
			if(uDB == null)
			{
				aDao.add(u);
			}
			
			list.add(aDao.findByActivite(u));
			
		}
		
		if(list != null) {
			t.setActivites(list);
		}

        em.persist(t);

        return t;
    }

    @Transactional
    public Utilisateur delete(Utilisateur t) {
        Utilisateur uDB = findByMail(t);

        if(uDB==null)
            return null;
        if(!em.contains(uDB))
            return null;

        em.remove(uDB);
        return uDB;
    }

	@Override
	@Transactional
	public Utilisateur update(Utilisateur t1, Utilisateur t2) {
		// TODO Auto-generated method stub
		return null;
	}

}