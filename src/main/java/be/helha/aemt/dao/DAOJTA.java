package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;


@Stateless
@LocalBean
public abstract class DAOJTA<T> implements IDAOJTA<T>{
 
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	protected EntityManager em;
    
	
	public DAOJTA() {
		
	}

    
}
