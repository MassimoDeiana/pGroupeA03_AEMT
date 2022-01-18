package be.helha.aemt.ejb;

import be.helha.aemt.entities.Utilisateur;

public interface IUtilisateurRemoteEJB extends IEntityRemoteEJB<Utilisateur> {

	public Utilisateur findByMail(Utilisateur u);
	
	public Utilisateur update(Utilisateur u1, Utilisateur u2);
}
