package session;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

@RequestScoped
public class Login {
    @Inject
    SessionInfo session;
    
    private String email;

    private String password;

    public Login(){}
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String _email){
        email = _email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String _password){
        password = _password;
    }

    public String login(){
        try {
            session.getSession().login(email, password);
            return "index.xhtml";
        } catch(Exception e) {
            new FacesMessage(e.toString());
            return null;
        }
    }
}
