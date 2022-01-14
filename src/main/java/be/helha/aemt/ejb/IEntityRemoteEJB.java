package be.helha.aemt.ejb;

import java.util.List;

public interface IEntityRemoteEJB<T> {
	
	T add(T in);
	
	T delete(T in);
	
	T update(T in1, T in2);
	
	T find(int id);
	
	List<T> findall();
	
}
