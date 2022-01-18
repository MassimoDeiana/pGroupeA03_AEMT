
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
import be.helha.aemt.entities.Cours;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Seance;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class CoursDAO extends DAOJTA<Cours> {

	@EJB
	private UtilisateurDAO uDAO;
	
	@EJB
	private SeanceDAO sDAO;
	
	@Override
	public Cours find(Integer id) {
		
		if(id==null) 
			return null;
		
		Cours find = em.find(Cours.class, id);
		em.detach(find);
		
		return find;
	}

	public Cours findCours(Cours e) {
		if(e == null)
			return null;
		String q="Select e from Cours e where e.nom=:nom and e.seances in :seances";
        Query query = em.createQuery(q);
        query.setParameter("nom", e.getNom());
        query.setParameter("seances", e.getSeances());
        List<Cours> list = query.getResultList();
                 
        return list.isEmpty()?null : list.get(0);
	}
	
	
	@Override
	@Transactional
	public List<Cours> findAll() {

		String aFind="SELECT a FROM Cours a";
        TypedQuery<Cours> qFind=em.createQuery(aFind,Cours.class);
		List<Cours> results = qFind.getResultList();
        
        return results.isEmpty()?null : results;
	}

	@Override
	@Transactional
	public Cours add(Cours t) {

		if(t==null)
			return null;
		
		Cours eBD = findCours(t);
		
		if(eBD!=null)
			return null;

		
		Utilisateur uDB = uDAO.findByMail(t.getInstructeur());
		
		if(uDB != null)
		{
			t.setInstructeur(uDB);
		}
			
		
		List<Seance> list = new ArrayList<Seance>();
		
		for (Seance u : t.getSeances()) {			
			Seance aDB = sDAO.findByDate(u);
			if(aDB == null)
			{
				sDAO.add(u);
			}
				
			t.addSeance(sDAO.findByDate(u));
		}
        em.persist(t);
		return t;
		
	}

	@Override
	@Transactional
	public Cours update(Cours t1, Cours t2) {

		Cours aDB1 = findCours(t1);
		Cours aDB2 = findCours(t2);
		
		if(aDB1==null || aDB1.getId()==null || t2==null || aDB2!=null)
			return null;
		
		 if(!em.contains(aDB1))
	            return null;
		 
		aDB1.setNom(t2.getNom());
		aDB1.setAdresse(t2.getAdresse());
		aDB1.setDescription(t2.getDescription());
		aDB1.setInstructeur(t2.getInstructeur());
		aDB1.setTarif(t2.getTarif());
		aDB1.setSeances(t2.getSeances());

        em.merge(aDB1);

		return aDB1;
	}

	@Override
	@Transactional
	public Cours delete(Cours t) {

		Cours aDB = findCours(t);

        if(aDB==null)
            return null;
        
        if(!em.contains(aDB))
            return null;

        em.remove(aDB);

        return aDB;
	}

}
