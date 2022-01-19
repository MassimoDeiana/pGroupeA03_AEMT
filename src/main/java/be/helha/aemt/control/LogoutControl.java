package be.helha.aemt.control;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class LogoutControl {

	public String logout() {
	    ((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
	         .getSession(false)).invalidate();
	     return "/index";
	}
}
