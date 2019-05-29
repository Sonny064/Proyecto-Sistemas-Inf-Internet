package backend;

import javax.ejb.Stateful;

import objects.*;
import objects.Worker.Profile;

// TODO: Add select functions
@Stateful
public class Session implements SessionLocal {
    private Personal user;

    public Session(){}

    @Override
    public void login(String email, String password) throws Exception {
        user = Model.login(email, password);
    }

    @Override
    public Personal getUser(){
        return user;
    }

    @Override
    public void add(Object target) throws Exception {
        if(user != null && user.getProfile() == Profile.ADMIN){
            Model.add(target);
        } else {
            throw new Exception("Insufficient privileges");
        }
    }

    @Override
    public void update(Object target) throws Exception {
        if(user != null && user.getProfile() == Profile.ADMIN){
            Model.update(target);
        } else {
            throw new Exception("Insufficient privileges");
        }
    }

    @Override
    public void delete(Object target) throws Exception {
        if(user != null && user.getProfile() == Profile.ADMIN){
            Model.delete(target);
        } else {
            throw new Exception("Insufficient privileges");
        }
    }

    @Override
    public void updateSelf() throws Exception {
        if(user != null){
            Model.update(user);
        } else {
            throw new Exception("Cannot update empty user");
        }
    }

    @Override
    public void deleteSelf(String password) throws Exception {
        if(user != null && user.checkPassword(password)){
            Model.delete(user);
        } else {
            throw new Exception("Cannot update empty user");
        }
    }

    @Override
    public void addUser(Personal target) throws Exception {
        if(user != null && (user.getProfile() == Profile.ADMIN || user.getProfile().ordinal() < target.getProfile().ordinal())){
            Model.add(target);
        } else {
            throw new Exception("Insufficient privileges");
        }
    }

    @Override
    public void updateUser(Personal target) throws Exception {
        if(user != null && (user.getProfile() == Profile.ADMIN || user.getProfile().ordinal() < target.getProfile().ordinal())){
            Model.update(target);
        } else {
            throw new Exception("Insufficient privileges");
        }
    }

    @Override
    public void deleteUser(Personal target) throws Exception {
        if(user != null && (user.getProfile() == Profile.ADMIN || user.getProfile().ordinal() < target.getProfile().ordinal())){
            Model.delete(target);
        } else {
            throw new Exception("Insufficient privileges");
        }
    }
    
    @Override
    public void addPayment(IngresosEgresos target) throws Exception {
        if(user != null && user.getProfile().ordinal() <= Profile.WORKER.ordinal()){
            Model.add(target);
        } else {
            throw new Exception("Insufficient privileges");
        }
    }

    @Override
    public void addDonation(Centro center, Float value){
        String name = user != null ? user.getFirstName() + " " + user.getLastName() : "Anónimo";
        java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());

        Model.add(new IngresosEgresos(center, value, name, "Donación", now));
    }
}
