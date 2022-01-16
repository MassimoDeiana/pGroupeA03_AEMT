/*
package be.helha.aemt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import be.helha.aemt.entities.Atelier;
import be.helha.aemt.entities.Cours;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class CoursDAO extends DAOJTA<Cours> {

	@EJB
	private UtilisateurDAO uDAO;
	
	@Override
	public Cours find(Integer id) {
		
		if(id==null) 
			return null;
		
		Cours find = em.find(Cours.class, id);
		em.detach(find);
		
		return find;
	}

	@Override
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
        
		List<Utilisateur> ulist = new ArrayList<Utilisateur>();
		
		for (Utilisateur u : t.getInstructeurs()) {
			
			Utilisateur uDB = uDAO.findByMail(u);
			
			if(uDB != null)
			{
				ulist.add(uDB);
			}
		}
		
		if(ulist != null) {
			t.setInstructeurs(ulist);
		}
		
        em.persist(t);
		return t;
		
	}

	@Override
	@Transactional
	public Cours update(Cours t1, Cours t2) {

		Cours aDB1 = find(t1.getId());
		Cours aDB2 = find(t2.getId());
		
		if(aDB1==null || aDB1.getId()==null || t2==null || aDB2!=null)
			return null;
		
		 if(!em.contains(aDB1))
	            return null;
		 
		aDB1.setNom(t2.getNom());
		aDB1.setAdresse(t2.getAdresse());
		aDB1.setDescription(t2.getDescription());
		aDB1.setDateDebut(t2.getDateDebut());
		aDB1.setDateFin(t2.getDateFin());
		aDB1.setInstructeurs(t2.getInstructeurs());
		aDB1.setTarif(t2.getTarif());
		aDB1.setRecurrence(t2.getRecurrence());

		   
        em.merge(aDB1);

		return aDB1;
	}

	@Override
	@Transactional
	public Cours delete(Cours t) {

		Cours aDB = find(t.getId());

        if(aDB==null)
            return null;
        
        if(!em.contains(aDB))
            return null;

        em.remove(aDB);

        return aDB;
	}

}
*/