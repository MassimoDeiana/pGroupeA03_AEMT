
package be.helha.aemt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Seance;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class AtelierDAO extends DAOJTA<Atelier> {
	

	@EJB
	private UtilisateurDAO uDAO;
	
	@EJB
	private SeanceDAO sDAO;
	
	@Override
	public Atelier find(Integer id) {
		
		if(id==null) 
			return null;
		
		Atelier find = em.find(Atelier.class, id);
		em.detach(find);
		
		return find;
	}
	
	public Atelier findAtelier(Atelier e) {
		if(e == null)
			return null;
		String qEvenement="Select e from Atelier e where e.nom=:nom and e.seance=:seance";
        Query queryEvenement = em.createQuery(qEvenement);
        queryEvenement.setParameter("nom", e.getNom());
        queryEvenement.setParameter("seance", e.getSeance());
        List<Atelier> EvenementList = queryEvenement.getResultList();
                 
        return EvenementList.isEmpty()?null : EvenementList.get(0);
		
	}

	@Override
	@Transactional
	public List<Atelier> findAll() {

		String aFind="SELECT a FROM Atelier a";
        TypedQuery<Atelier> qFind=em.createQuery(aFind,Atelier.class);
		List<Atelier> results = qFind.getResultList();
        
        return results.isEmpty()?null : results;
	}

	@Override
	@Transactional
	public Atelier add(Atelier t) {

		if(t==null)
			return null;
        
		Atelier eBD = findAtelier(t);
		
		if(eBD!=null)
			return null;
		

		
		Utilisateur uDB = uDAO.findByMail(t.getInstructeurs());
		
		if(uDB != null)
			t.setInstructeurs(uDB);
		
		Seance sDB = sDAO.findByDate(t.getSeance());
		
		if(sDB != null)
			t.setSeance(sDB);
		
				
        em.persist(t);
		return t;
		
	}

	@Override
	@Transactional
	public Atelier update(Atelier t1, Atelier t2) {

		Atelier aDB1 = findAtelier(t1);
		Atelier aDB2 = findAtelier(t2);
		
		if(aDB1==null || aDB1.getId()==null || t2==null || aDB2!=null)
			return null;
		
		 if(!em.contains(aDB1))
	            return null;
		 
		aDB1.setNom(t2.getNom());
		aDB1.setAdresse(t2.getAdresse());
		aDB1.setDescription(t2.getDescription());
		aDB1.setInstructeurs(t2.getInstructeurs());
		aDB1.setTarif(t2.getTarif());
		aDB1.setSeance(t2.getSeance());
		   
        em.merge(aDB1);

		return aDB1;
	}

	@Override
	@Transactional
	public Atelier delete(Atelier t) {

		Atelier aDB = findAtelier(t);

        if(aDB==null)
            return null;
        
        if(!em.contains(aDB))
            return null;

        em.remove(aDB);

        return aDB;
	}


}
