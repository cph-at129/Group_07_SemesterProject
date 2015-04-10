
package dataSource;

import dataSource.mappers.ProjectProposalMapper;
import domain.ProjectProposal;
import java.sql.Connection;

/*
   - provides a facade to the Data Source Layer
   - encapsulates connection handling
   - is Singleton
*/

public class DBFacade {
          private ProjectProposalMapper projectPMapper;
	  private Connection con;
	  
	  //== Singleton start
	  private static DBFacade instance;
	 
	  private DBFacade() {
                  projectPMapper = new ProjectProposalMapper();
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
    
}
