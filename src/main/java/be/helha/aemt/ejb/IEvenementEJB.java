package be.helha.aemt.ejb;

import javax.ejb.Remote;

import be.helha.aemt.entities.Evenement;

@Remote
public interface IEvenementEJB extends IEntityRemoteEJB<Evenement>{

}
