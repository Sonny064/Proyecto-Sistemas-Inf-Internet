package session;

import javax.enterprise.context.SessionScoped;
import javax.ejb.EJB;
import java.io.Serializable;
import javax.inject.Inject;

import backend.SessionLocal;

@SessionScoped
public class SessionInfo implements Serializable {
    @Inject
    SessionLocal session;
    
    public SessionInfo(){}
    
    public SessionLocal getSession(){
        return session;
    }    
}
