package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Utilisateur;

@Remote
public interface IUtilisateurRemoteEJB {

<<<<<<< HEAD
	Utilisateur find(Integer id);
	
	List<Utilisateur> findAll();
	
	Utilisateur add(Utilisateur u);
	
	Utilisateur delete(Utilisateur u);
}
=======
    Utilisateur find(Integer id);

    List<Utilisateur> findAll();

    Utilisateur add(Utilisateur u);

    Utilisateur delete(Utilisateur u);
}
>>>>>>> 3158ebe35b456c92f0f03c3995347e4443c6b332
