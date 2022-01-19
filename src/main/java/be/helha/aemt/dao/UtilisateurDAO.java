package be.helha.aemt.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Seance;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Adresse;

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
    
    public Utilisateur find(Long u) {
    	if(u==null)
    		return null;
    	Utilisateur find = em.find(Utilisateur.class, u);
    	
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
    
    public Utilisateur findByActivites(Utilisateur u) {
        if(u == null || u.getActivites().isEmpty()) {
            return null;
        }
        String qUtilisateur = "Select u from Utilisateur u where u.activites=:activites";
        Query queryUtilisateur = em.createQuery(qUtilisateur);

        queryUtilisateur.setParameter("activites", u.getActivites());

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
		
		Utilisateur uDB1 = findByMail(t1);
		Utilisateur uDB2 = findByMail(t2);
		if(uDB1==null || uDB1.getId()==null || t2==null || uDB2!=null) {
			return null;
		}
		 if(!em.contains(uDB1))
	            return null;

		uDB1.setActivites(t2.getActivites());
        
        em.merge(uDB1);

		return uDB1;
	}
	
	@Transactional
	public Utilisateur updateActivites(Utilisateur t1, Utilisateur t2) {
		System.out.println("mdrrrr");
		Utilisateur uDB1 = findByMail(t1);
		System.out.println("test1");
		Utilisateur uDB2 = t2;
		System.out.println("test");
		if(uDB2 != null && uDB1.getActivites().equals(uDB2.getActivites())) {
			System.out.println("test2");
			return null;
		}
		if(!em.contains(uDB1)) {
			System.out.println("ici");
        	return null;
		}

		uDB1.setActivites(t2.getActivites());
        
        em.merge(uDB1);

		return uDB1;
	}

}