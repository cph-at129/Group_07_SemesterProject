/*
 provides interface to the application logic and data	
 interprets commands from Presentation Layer
 performs calculations and enforces business rules on basis of input and stored data
 uses the services of the Data Source Layer
*/
package domain;

import dataSource.DBFacade;

/*

   - provides a facade to the Domain Layer
   - holds the state of the business transaction
   - perform business logic
   - registers all objects affected during the business transaction with a Unit of Work object (through the DBFacade)
   - is Singleton to ensure unambiguous state

*/

public class Controller {
    
    private DBFacade dbf;
    private Proposal conProposal;
    private User conUser;
    private Project conProject;
    private POE conPOE;
    private Admin conAdmin;
    private Partner conPartner;
    
    public Controller(){
        
       dbf = DBFacade.getInstance();
       conProposal = null;
       conUser = null;
       conProject = null;
       conPOE = null;
       conAdmin = null;
       conPartner = null;
    }
    /*
      the method should return true if the new user is registered successfully
      in the Database
    */
    public boolean registerUser(String login, String password, String fName, String lName, String phone){
    
        //create a unique userID ->>>>
        int userID = 1113;
        
        //create a unique partnerID ->>>>
        int partnerID = 11111;
        
        //create a new User object
        conUser = new User(userID,  login,  password,  partnerID,  fName,  lName,  phone);
        
        return dbf.registerUser(conUser);
    
    }

    public boolean logIn(String login, String password) {
        
        //create a method to check if user exist
        int userID = 1111;
        
        conUser = new User(userID, login, password);
        
        return dbf.logIn(conUser);
        
    }
    public boolean submitPOE(int partnerID, String submissionDate){
    
        //create a unique poeID
        int poeID = 1111;
        
        conPOE = new POE(poeID, partnerID, submissionDate);
        
        return dbf.submitPOE(conPOE);
    
    }
    













//submit project proposal
    public boolean submitProjectProposal(String partnerName, String country, String activity){
        
        conProposal = new Proposal(partnerName, country, activity);
        
        System.out.println("IN controller");
        System.out.println(conProposal);
        boolean status = dbf.submitProjectProposal(conProposal);
        
        return status;
    }
    
    
    
    
    //review project proposal
    
    //add comments to project proposal
    
    //accept project proposal
    
    //decline project proposal
    
    //send project proposal notification
    
    //open project
    
    //delete project
    
    //submit POE
    
    //attach image to POE
    
    //review POE
    
    //add comments to POE
    
    //send POE notification
    
    //save POE
    
    //open POE
    
    //delete POE
    
    //attach document
    
    //save document
    
    //open document
    
    //delete document
    
    //show spreadsheet form with data and statistics
    
    //view remaining budget
    
    
    /*
       the method checks if the user has logged in successfully
     */
    

//    public boolean submitPOE() {
//        
//        POE poe = new POE();
//        
//        return dbf.submitPOE(poe);
//        
//    }
}
