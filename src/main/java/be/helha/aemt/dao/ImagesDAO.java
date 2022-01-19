package be.helha.aemt.dao;

import java.util.List;

import be.helha.aemt.entities.Activite;
import be.helha.aemt.entities.Images;

public class ImagesDAO extends DAOJTA<Images>{

	@Override
	public Images find(Integer id) {
		if(id==null) 
			return null;
		
		Images find = em.find(Images.class, id);
		
		return find;
	}

	@Override
	public List<Images> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Images add(Images t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Images update(Images t1, Images t2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Images delete(Images t) {
		// TODO Auto-generated method stub
		return null;
	}

}
