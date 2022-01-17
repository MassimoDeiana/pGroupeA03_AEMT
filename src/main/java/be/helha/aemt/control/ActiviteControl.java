package be.helha.aemt.control;

import java.util.List;  

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.IActiviteRemoteEJB;
import be.helha.aemt.entities.Activite;

@Named
@RequestScoped
public class ActiviteControl {

	@EJB
	private IActiviteRemoteEJB ejb;
    private Activite activite;
    private Activite a= new Activite();
    
    @PostConstruct
    public void init() {
    	activite= new Activite();
    	a=activite;
    }
    
    public List<Activite> findAll() {
        return ejb.findAll();
    }
    
    public String doGetDetails(Activite act) {
		activite = act;
        return "detail";
    }
    
    public void remove(Activite activite) {
	       ejb.delete(activite);
	    }
	
}
