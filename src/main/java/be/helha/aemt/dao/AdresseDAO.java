package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import be.helha.aemt.entities.Adresse;

@Stateless
@LocalBean
public class AdresseDAO extends DAOJTA<Adresse> {

	
	public Adresse findByAdresse(Adresse a) {
	
		if(a==null) {
			return null;
		}
		String qAdresse="Select a from Adresse a where a.codePostal=:codePostal and a.rue=:rue and a.numero=:numero and a.ville=:ville";
        Query queryAdresse = em.createQuery(qAdresse);
        queryAdresse.setParameter("codePostal", a.getCodePostal());
        queryAdresse.setParameter("rue", a.getRue());
        queryAdresse.setParameter("numero", a.getNumero());
        queryAdresse.setParameter("ville", a.getVille());
        List<Adresse> adresseList = queryAdresse.getResultList();
                 
        return adresseList.isEmpty()?null : adresseList.get(0);
		
	}
	
	
	
	@Override
	public Adresse find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adresse> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse add(Adresse t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse update(Adresse t1, Adresse t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse delete(Adresse t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
