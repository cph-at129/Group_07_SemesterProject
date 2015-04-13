
package dataSource;

import dataSource.mappers.POEMapper;
import dataSource.mappers.ProjectProposalMapper;
import dataSource.mappers.UserMapper;
import domain.POE;
import domain.ProjectProposal;
import domain.User;
import java.sql.Connection;

/*
   - provides a facade to the Data Source Layer
   - encapsulates connection handling
   - is Singleton
*/

public class DBFacade {
          private ProjectProposalMapper projectPMapper;
          private UserMapper urMapper;
          private POEMapper poeMapper;
	  private Connection con;
	  
	  //== Singleton start
	  private static DBFacade instance;
	 
	  private DBFacade() {
                  projectPMapper = new ProjectProposalMapper();
                  urMapper = new UserMapper();
		  con 	= DBConnector.getInstance().getConnection();  		  
	  }
	  public static DBFacade getInstance()
	  {
		  if(instance == null)
			  instance = new DBFacade();
		  return instance;
	  }
	  //== Singleton end

    public boolean submitProjectProposal(ProjectProposal projectP) {
        
        return projectPMapper.submitProjectProposal(projectP, con);
        
    }

    public boolean logIn(User ur) {
        
        return urMapper.logIn(ur, con);
        
    }

    public boolean submitPOE(POE poe) {
        
        return poeMapper.submitPOE(poe, con);
        
    }
    
}
