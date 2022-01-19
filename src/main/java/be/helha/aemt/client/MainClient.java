package be.helha.aemt.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import be.helha.aemt.entities.Adresse;
import be.helha.aemt.entities.Utilisateur;

public class MainClient {
	public static void main(String[] args)
	{
		
		Adresse adresse = new Adresse("R1", "N1", "V1", 7000);
		Utilisateur u = new Utilisateur("ThierryRoland@gmail.com", "password1", "Roland", "Thierry", "admin");
//		Article a1 = new Article("Arti1",10);
//		Commande c = new Commande();
//		c.ajouteArticle(a1);
//		u.ajouterCommande(c);
		
		try
		{
			Context ctx=new InitialContext();
		//	IEntityRemoteEJB<Utilisateur> bean=(IEntityRemoteEJB<Utilisateur>)ctx.lookup("java:global/groupeA3/EntityEJB<Utilisateur>!be.helha.aemt.ejb.IEntityRemoteEJB<Utilisateur>");
//			System.out.println(bean.findAll());
//			System.out.println(bean.add(u));
//			System.out.println(bean.findAll());
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
