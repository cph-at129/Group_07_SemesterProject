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
    
    private static Controller instance;
    private DBFacade dbf;
    private Proposal conProposal;
    private User conUser;
    private Project conProject;
    private POE conPOE;
    private Admin conAdmin;
    private Partner conPartner;
    
    private Controller(){
        
       dbf = DBFacade.getInstance();
       conProposal = null;
       conUser = null;
       conProject = null;
       conPOE = null;
       conAdmin = null;
       conPartner = null;
    }
    
    public static Controller getInstance(){
    
      if(instance == null)
         instance = new Controller();
      return instance;
    
    }
    /*
      the method should return true if the new user is registered successfully
      in the Database
    */
    public boolean registerUser(String login, String password, String fName, String lName, String phone){
    
        //create a unique userID ->>>>
        int userID = 1111;
        
        //create a unique partnerID ->>>>
        int partnerID = 1111;
        
        //create a new User object
        conUser = new User(userID,  login,  password,  partnerID,  fName,  lName,  phone);
        
        return dbf.registerUser(conUser);
    
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
    public boolean logIn(String userID, String password) {
        
        User ur = new User(userID, password);
        
        return dbf.logIn(ur);
        
    }

    public boolean submitPOE() {
        
        POE poe = new POE();
        
        return dbf.submitPOE(poe);
        
    }
}
