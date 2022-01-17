package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.DAOJTA;
import be.helha.aemt.dao.IDAOJTA;

@Stateless
public class EntityEJB<T> implements IEntityRemoteEJB<T>{

	@EJB
	IDAOJTA<T> dao;
	
	@Override
	@Transactional
	public T add(T in) {
		return dao.add(in);
	}

	@Override
	@Transactional
	public T delete(T in) {
		return dao.delete(in);
	}

	@Override
	@Transactional
	public T find(Integer id) {
		return dao.find(id);
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

}
