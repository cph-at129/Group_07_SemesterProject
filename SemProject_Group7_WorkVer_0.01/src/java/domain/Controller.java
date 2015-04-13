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
    private ProjectProposal projectP;
    
    private Controller(){
        
       dbf = DBFacade.getInstance();
       projectP = null;
    
    }
    
    public static Controller getInstance(){
    
      if(instance == null)
         instance = new Controller();
      return instance;
    
    }
    //submit project proposal
    public boolean submitProjectProposal(String partnerName, String country, String activity){
        
        projectP = new ProjectProposal(partnerName, country, activity);
        
        System.out.println("IN controller");
        System.out.println(projectP);
        boolean status = dbf.submitProjectProposal(projectP);
        
        return status;
    }
    


//log in
    
    
    
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
}
