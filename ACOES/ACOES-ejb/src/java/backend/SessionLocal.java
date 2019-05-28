package backend;

import javax.ejb.Local;

import objects.*;

@Local
public interface SessionLocal {
    public void login(String email, String password) throws Exception;
    public Worker getUser();
    
    public void add(Object target) throws Exception;
    public void update(Object target) throws Exception;
    public void delete(Object target) throws Exception;
    
    public void updateSelf() throws Exception;
    public void deleteSelf(String password) throws Exception;
    
    public void addUser(Worker target) throws Exception;
    public void updateUser(Worker target) throws Exception;
    public void deleteUser(Worker target) throws Exception;
    
    public void addPayment(Payment target) throws Exception;
    
    public void addDonation(Center center, Float value);
}
