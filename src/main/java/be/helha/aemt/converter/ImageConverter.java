	package be.helha.aemt.converter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import be.helha.aemt.dao.ImagesDAO;
import be.helha.aemt.entities.Images;


@FacesConverter(forClass = Images.class)
public class ImageConverter implements Converter<Images>{

	@EJB
	private ImagesDAO ejb;
	
	@Override
    public Images getAsObject(FacesContext context, UIComponent component, String submittedValue) {
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
    public String getAsString(FacesContext context, UIComponent component, Images modelValue) {
        if (modelValue == null) {
            return ""; // Never return null here!
        }

        if (modelValue instanceof Images) {
            return String.valueOf(((Images) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Warehouse"));
        }
    }

	
}
