package be.helha.aemt.control;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginControl {

	//public static boolean isLogin;
	
	public String doIndex() {
		return "indexUser.xhtml?faces-redirect=true";
	}
	
	public boolean isLogged() {
		if(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName() != null)
			return true;
		else
			return false;
		//return isLogin;
	}
	

}
