package acoes;

import objects.*;
import objects.Worker.Profile;
import java.sql.Date;

public class Test {
   public static void main(String args[]){
       Model m = new Model();

       Worker w1 = new Worker("foo@gmail.com", "1234", Profile.ADMIN, "1234567A", "Pepito", "Fernandez", Date.valueOf("1990-10-01") );

       m.addWorker(w1);

       if(w1.checkPassword("1234")){
           System.out.println("Password ok");
       } else {
           System.out.println("Login error");
       }

        if(w1.checkPassword("1235")){
           System.out.println("Password ok");
       } else {
           System.out.println("Login error");
       }
   }
}
