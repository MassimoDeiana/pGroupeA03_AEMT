package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface IDAOJTA<T> {

	
	
	public T find(Integer id);

	public List<T> findAll();

	public T add(T t);

	public T update(T t1,T t2);

	public T delete(T t);
	
	
	
}
