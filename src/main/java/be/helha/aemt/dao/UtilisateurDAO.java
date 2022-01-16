package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class UtilisateurDAO extends DAOJTA<Utilisateur> {

    public Utilisateur find(Integer id) {
        if(id == null) 
            return null;

        Utilisateur find = em.find(Utilisateur.class, id);
        em.detach(find);

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
	public Utilisateur update(Utilisateur t1, Utilisateur t2) {
		// TODO Auto-generated method stub
		return null;
	}

}