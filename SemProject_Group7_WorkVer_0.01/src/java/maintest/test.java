
package maintest;

import domain.controller.Controller;

public class test {
    
    public static void main(String[] args) {
        
        Controller con = new Controller();
        
        boolean status = con.logInAsAdmin("admin", "admin");
        
        System.out.println(status);
   }
}