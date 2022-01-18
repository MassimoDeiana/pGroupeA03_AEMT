package be.helha.aemt.ejb;

import javax.ejb.Remote;

import be.helha.aemt.entities.Utilisateur;

@Remote
public interface IUtilisateurRemoteEJB extends IEntityRemoteEJB<Utilisateur> {
		

	public Utilisateur findByMail(Utilisateur u);
	
	public Utilisateur update(Utilisateur u1, Utilisateur u2);
}
