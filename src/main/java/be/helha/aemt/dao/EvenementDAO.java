package be.helha.aemt.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Evenement;

@Stateless
@LocalBean
public class EvenementDAO extends DAOJTA<Evenement>{

	@Override
	public Evenement find(Integer id) {
		if(id==null)
			return null;
		
		Evenement find = em.find(Evenement.class, id);
		
		return find;
	}

	
	public Evenement findEvenement(String nom,Date dateDebut) {
		if(nom==null)
			return null;
		String qEvenement="Select e from Evenement e where e.nom=:nom and e.dateDebut=:dateDebut";
        Query queryEvenement = em.createQuery(qEvenement);
        queryEvenement.setParameter("nom", nom);
        queryEvenement.setParameter("dateDebut", dateDebut);
        List<Evenement> EvenementList = queryEvenement.getResultList();
                 
        return EvenementList.isEmpty()?null : EvenementList.get(0);
		
	}
	
	@Override
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
		Evenement eBD = findEvenement(t.getNom(), t.getDateDebut());
		
		if(eBD!=null)
			return null;
		
		em.persist(t);
		return t;
	}

	@Override
	@Transactional
	public Evenement update(Evenement t1, Evenement t2) {
		
		Evenement eDB1 = findEvenement(t1.getNom(),t1.getDateDebut());
		Evenement eDB2 = findEvenement(t2.getNom(),t2.getDateDebut());
		
		if(eDB1==null || eDB1.getId()==null || t2==null || eDB2!=null)
			return null;
		
		 if(!em.contains(eDB1))
	            return null;
		
		eDB1.setNom(t2.getNom());
		eDB1.setDescription(t2.getDescription());
		eDB1.setAdresse(t2.getAdresse());
		eDB1.setDateDebut(t2.getDateDebut());
		eDB1.setDateFin(t2.getDateFin());
		eDB1.setRecurrence(t2.getRecurrence());
        
        em.merge(eDB1);

		return eDB1;
	}

	@Override
	@Transactional
	public Evenement delete(Evenement t) {
		Evenement eDB = findEvenement(t.getNom(),t.getDateDebut());

        if(eDB==null)
            return null;
        
        if(!em.contains(eDB))
            return null;

        em.remove(eDB);

        return eDB;
	}

	
	
}
