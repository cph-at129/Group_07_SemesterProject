
package test;

import domain.Controller;

public class TestClass {
    
    private static Controller con;
    
    public static void main(String[] args) {
        
        con = new Controller();
        con.submitProjectProposal("111", "111", "111");
        
    }
    
}
