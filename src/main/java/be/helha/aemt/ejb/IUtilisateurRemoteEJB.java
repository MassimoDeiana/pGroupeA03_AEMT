package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Utilisateur;

@Remote
public interface IUtilisateurRemoteEJB {

	Utilisateur find(Integer id);
	
	List<Utilisateur> findAll();
	
	Utilisateur add(Utilisateur u);
	
	Utilisateur delete(Utilisateur u);
}
