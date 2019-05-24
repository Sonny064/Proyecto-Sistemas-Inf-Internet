package acoes.model;

import objects.*;
import objects.Worker.Profile;
import java.sql.Date;

public class Test {
   public static void main(String args[]){
       Model m = new Model();
       
       Worker w;
       
       if((w = m.find(Worker.class, "foo@gmail.com")) != null){
           System.out.println("foo@gmail.com found");
           
           if(w.checkPassword("1234")){
               System.out.println("Password 1234 OK. Changing it.");
               
               if(!w.changePassword("1235", "1236")){
                 System.out.println("Cannot change password");
               }
               
               if(w.changePassword("1234", "1235")){
                   System.out.println("Password changed succesfully!");
                   m.update(w);
               }
           } else if(w.checkPassword("1235")){
               System.out.println("Password 1235 OK");
           }
       } else {
           System.out.println("foo@gmail.com not found, adding it");
           w = new Worker("foo@gmail.com", "1234", Profile.ADMIN, "1234567A", "Pepito", "Fernandez", Date.valueOf("1990-10-01"));
           m.add(w);  
       }
   }
}
