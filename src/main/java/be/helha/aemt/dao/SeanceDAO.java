package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Seance;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class SeanceDAO extends DAOJTA<Seance> {

	@Override
	public Seance find(Integer id) {
		if(id==null) 
			return null;
		
		Seance find = em.find(Seance.class, id);
		em.detach(find);
		
		return find;
	}
	
	public Seance findByDate(Seance t) {
        if(t == null) {
            return null;
        }
        String q = "Select t from Seance t where t.dateDebut=:dateDebut and t.dateFin=:dateFin";
        Query querry = em.createQuery(q);

        querry.setParameter("dateDebut", t.getDateDebut());
        querry.setParameter("dateFin", t.getDateFin());

        List<Seance> list = querry.getResultList();

        return list.isEmpty()?null : list.get(0);
	}

	@Override
	public List<Seance> findAll() {
		String aFind="SELECT a FROM Seance a";
        TypedQuery<Seance> qFind=em.createQuery(aFind,Seance.class);
		List<Seance> results = qFind.getResultList();
        
        return results.isEmpty()?null : results;
	}

	@Override
	@Transactional
	public Seance add(Seance t) {
        if(t == null)
            return null;

        Seance uBD = findByDate(t);

        if(uBD != null) {
            return null;
        }

        em.persist(t);

        return t;
	}

	@Override
	@Transactional
	public Seance update(Seance t1, Seance t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Seance delete(Seance t) {

		Seance aDB = find(t.getId());

        if(aDB==null)
            return null;
        
        if(!em.contains(aDB))
            return null;

        em.remove(aDB);

        return aDB;
	}
	
	public List<Seance> getAtelierSeance(Integer id) {
        
        String qSearch="SELECT a.seance FROM Atelier a where a.id=:id";
        Query queryFind = em.createQuery(qSearch);
        queryFind.setParameter("id", id);
        List<Seance> seanceList = queryFind.getResultList();
        
        return seanceList.isEmpty()?null : seanceList;  
    }
	
	public List<Seance> getEvenementSeance(Integer id) {
        
        String qSearch="SELECT a.seance FROM Evenement a where a.id=:id";
        Query queryFind = em.createQuery(qSearch);
        queryFind.setParameter("id", id);
        List<Seance> seanceEvenement = queryFind.getResultList();
        
        return seanceEvenement.isEmpty()?null : seanceEvenement;  
    }
	
	public List<Seance> getCoursSeance(Integer id) {
        
        String qSearch="SELECT a.seances FROM Cours a where a.id=:id";
        Query queryFind = em.createQuery(qSearch);
        queryFind.setParameter("id", id);
        List<Seance> seanceCours = queryFind.getResultList();
        
        return seanceCours.isEmpty()?null : seanceCours;  
    }

}
