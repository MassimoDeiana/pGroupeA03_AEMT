package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.dao.DAOJTA;

@Remote
public interface IEntityRemoteEJB<T> {
	
	
	T add(T in);
	
	T delete(T in);
	
	//T update(T in1, T in2);
	
	T find(Integer id);
	
	List<T> findAll();
	
}
