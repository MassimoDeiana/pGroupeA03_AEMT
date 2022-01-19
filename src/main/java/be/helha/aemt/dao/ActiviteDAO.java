package be.helha.aemt.dao;

import java.util.List; 

import javax.ejb.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Images;

@Stateless
@LocalBean
public class ActiviteDAO extends DAOJTA<Activite> {

	
	public Activite findByActivite(Activite a) {
		
		if(a==null) {
			return null;
		}
		String q="Select a from Activite a where a.nom=:nom";
        Query query = em.createQuery(q);
        query.setParameter("nom", a.getNom());
        List<Activite> list = query.getResultList();
                 
        return list.isEmpty()?null : list.get(0);
		
	}
	public Images findImageByActivite(Activite a) {
		
		if(a==null) {
			return null;
		}
		
		String q="Select a from Activite a where a.nom=:nom";
        Query query = em.createQuery(q);
        query.setParameter("nom", a.getNom());
        List<Images> list = query.getResultList();
                 
        return list.isEmpty()?null : list.get(0);
		
	}
	

	@Override
	public Activite find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Activite> findAll() {
		
		String aFind="SELECT v FROM Activite v";
        TypedQuery<Activite> qFind=em.createQuery(aFind,Activite.class);
		List<Activite> results = qFind.getResultList();
        
        return results.isEmpty()?null : results;
	}

	@Override
	public Activite add(Activite t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activite update(Activite t1, Activite t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activite delete(Activite t) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
