package be.helha.aemt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Seance;
import be.helha.aemt.entities.Utilisateur;

public class ActiviteDAO extends DAOJTA<Activite> {

	@EJB
	private SeanceDAO sDao;
	
	@Override
	public Activite find(Integer id) {
		if(id==null) 
			return null;
		
		Activite find = em.find(Activite.class, id);
		em.detach(find);
		
		return find;
	}

	@Override
	public List<Activite> findAll() {
		String aFind="SELECT a FROM Activite a";
        TypedQuery<Activite> qFind=em.createQuery(aFind,Activite.class);
		List<Activite> results = qFind.getResultList();
        
        return results.isEmpty()?null : results;
	}
	
	public Activite findByActivite(Activite t) {
        if(t == null) {
            return null;
        }
        if(!t.getType().equals("evenement"))
        {
            String q = "Select t from Activite t where t.nom=:nom and t.type=:type and t.seances in :seances";
            Query querry = em.createQuery(q);

            querry.setParameter("nom", t.getNom());
            querry.setParameter("type", t.getType());
     
            querry.setParameter("seances", t.getSeances());
            
            List<Activite> list = querry.getResultList();
            
            return list.isEmpty()?null : list.get(0);
        }
        else
        {
            String q = "Select t from Activite t where t.nom=:nom and t.type=:type";
            Query querry = em.createQuery(q);

            querry.setParameter("nom", t.getNom());
            querry.setParameter("type", t.getType());
            
            List<Activite> list = querry.getResultList();
            
            return list.isEmpty()?null : list.get(0);
        }
	}

	@Override
	@Transactional
	public Activite add(Activite t) {
        if(t == null)
            return null;

        Activite uBD = findByActivite(t);

        if(uBD != null) 
            return null;

		List<Seance> list = new ArrayList<Seance>();
		
		if(!t.getType().equals("evenement")) {
			for (Seance u : t.getSeances()) {			
				Seance aDB = sDao.findByDate(u);
				if(aDB == null)
					sDao.add(u);
				list.add(sDao.findByDate(u));
			}
			if(list != null) {
				t.setSeances(list);
			}
		}

        em.persist(t);

        return t;
	}

	@Override
	public Activite update(Activite t1, Activite t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Activite delete(Activite t) {
		Activite aDB = find(t.getId());

        if(aDB==null)
            return null;
        
        if(!em.contains(aDB))
            return null;

        em.remove(aDB);

        return aDB;
	}

}
