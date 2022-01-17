package be.helha.aemt.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IndexControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String doIndex() {
		return "index.xhtml?faces-redirect=true";
	}

}
