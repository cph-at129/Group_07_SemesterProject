
package maintest;

import domain.controller.Controller;

public class test {
    
    public static void main(String[] args) {
        
        Controller con = new Controller();
        
        boolean status = con.registerNewPartner("user6", "5555", "fName5", "lName5","Elgiganten", "Denmark", "51111111112");
        
        System.out.println(status);
   }
}