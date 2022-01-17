package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import be.helha.aemt.dao.ActiviteDAO;
import be.helha.aemt.entities.Activite;

@Stateless
@LocalBean
public class ActiviteEJB extends EntityEJB<Activite> {


	
}
