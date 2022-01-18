package be.helha.aemt.ejb;

import javax.ejb.Remote;

import be.helha.aemt.entities.Utilisateur;

@Remote
public interface IUtilisateurRemoteEJB extends IEntityRemoteEJB<Utilisateur> {
		

}
