package be.helha.aemt.converter;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.ejb.UtilisateurEJB;
import be.helha.aemt.entities.Utilisateur;

@ManagedBean
@FacesConverter(forClass = Utilisateur.class)
public class UtilisateurConverter implements Converter<Utilisateur>{

	@EJB
	private UtilisateurEJB ejb;
		
	@Override
	public Utilisateur getAsObject(FacesContext context, UIComponent component, String submittedValue) {
	    System.out.println(submittedValue);
	    System.out.println(ejb);
	   // System.out.println(ejb.find(1).toString());
	    System.out.println("coucou");
		if (submittedValue == null || submittedValue.isEmpty()) {
	        return null;
	    }

	    try {
	    	
	        return ejb.find(Integer.valueOf(submittedValue));
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Warehouse ID"), e);
	    }
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Utilisateur modelValue) {
	    if (modelValue == null) {
	        return ""; // Never return null here!
	    }

	    if (modelValue instanceof Utilisateur) {
	        return String.valueOf(((Utilisateur) modelValue).getId());
	    } else {
	        throw new ConverterException(new FacesMessage(modelValue + " is not a valid Warehouse"));
	    }
	}

}
