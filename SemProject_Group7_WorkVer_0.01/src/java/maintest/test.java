
package maintest;

import domain.controller.Controller;

public class test {
    
    public static void main(String[] args) {
        
        Controller con = new Controller();
        
       boolean status = con.createNewProject("Project1", 1000000, "partner1");
        
        System.out.println(status);
   }
}