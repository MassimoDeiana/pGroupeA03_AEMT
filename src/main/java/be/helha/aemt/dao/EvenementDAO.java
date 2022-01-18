
package be.helha.aemt.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Seance;


@Stateless
@LocalBean
public class EvenementDAO extends DAOJTA<Evenement>{

	@EJB
	private SeanceDAO sDAO;
	
	@EJB
	private AdresseDAO aDAO;
	
	@Override
	public Evenement find(Integer id) {
		if(id==null)
			return null;
		
		Evenement find = em.find(Evenement.class, id);
		
		return find;
	}

	
	public Evenement findEvenement(Evenement e) {
		if(e == null)
			return null;
		String qEvenement="Select e from Evenement e where e.nom=:nom and e.seance=:seance";
        Query queryEvenement = em.createQuery(qEvenement);
        queryEvenement.setParameter("nom", e.getNom());
        queryEvenement.setParameter("seance", e.getSeance());
        List<Evenement> EvenementList = queryEvenement.getResultList();
                 
        return EvenementList.isEmpty()?null : EvenementList.get(0);
		
	}
	
	@Override
	@Transactional
	public List<Evenement> findAll() {
		String aFind="SELECT e FROM Evenement e";
		TypedQuery<Evenement> qFind=em.createQuery(aFind,Evenement.class);
		List<Evenement> results = qFind.getResultList();
		
		return results.isEmpty()?null:results;
	}

	@Override
	@Transactional
	public Evenement add(Evenement t) {
		if(t == null)
			return null;
		Evenement eBD = findEvenement(t);
		
		if(eBD!=null)
			return null;
		
		Adresse aDB = aDAO.findByAdresse(t.getAdresse());
		if(aDB != null)
			t.setAdresse(aDB);
		
		Seance sDB = sDAO.findByDate(t.getSeance());
		
		if(sDB != null)
			t.setSeance(sDB);
		
		
		
		em.persist(t);
		return t;
	}

	@Override
	@Transactional
	public Evenement update(Evenement t1, Evenement t2) {
		
		Evenement eDB1 = findEvenement(t1);
		Evenement eDB2 = findEvenement(t2);
		
		if(eDB1==null || eDB1.getId()==null || t2==null || eDB2!=null)
			return null;
		
		 if(!em.contains(eDB1))
	            return null;
		
		eDB1.setNom(t2.getNom());
		eDB1.setDescription(t2.getDescription());
		eDB1.setAdresse(t2.getAdresse());
		eDB1.setSeance(t2.getSeance());
        
        em.merge(eDB1);

		return eDB1;
	}

	@Override
	@Transactional
	public Evenement delete(Evenement t) {
		Evenement eDB = findEvenement(t);

        if(eDB==null)
            return null;
        
        if(!em.contains(eDB))
            return null;

        em.remove(eDB);

        return eDB;
	}


	
	
}

	