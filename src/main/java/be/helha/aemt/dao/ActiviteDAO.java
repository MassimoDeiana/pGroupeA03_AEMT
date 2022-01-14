package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Activite;

public class ActiviteDAO extends DAOJTA<Activite> {

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

	@Override
	public Activite add(Activite t) {

		if(t==null)
			return null;
        
        em.persist(t);
		return t;
		
	}

	@Override
	public Activite update(Activite t1, Activite t2) {

		Activite aDB1 = find(t1.getId());
		Activite aDB2 = find(t2.getId());
		
		if(aDB1==null || aDB1.getId()==null || t2==null || aDB2!=null)
			return null;
		
		 if(!em.contains(aDB1))
	            return null;
		 
		aDB1.setNom(t2.getNom());
		aDB1.setAdresse(t2.getAdresse());
		aDB1.setDescription(t2.getDescription());
		aDB1.setDateDebut(t2.getDateDebut());
		aDB1.setDateFin(t2.getDateFin());
		aDB1.setInstructeur(t2.getInstructeur());
		aDB1.setTarif(t2.getTarif());
		aDB1.setRecurrence(t2.getRecurrence());
		aDB1.setType(t2.getType());
		   
        em.merge(aDB1);

		return aDB1;
	}

	@Override
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
