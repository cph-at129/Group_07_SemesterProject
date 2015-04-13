
package dataSource;

import dataSource.mappers.POEMapper;
import dataSource.mappers.ProposalMapper;
import dataSource.mappers.UserMapper;
import domain.POE;
import domain.Proposal;
import domain.User;
import java.sql.Connection;

/*
   - provides a facade to the Data Source Layer
   - encapsulates connection handling
   - is Singleton
*/

public class DBFacade {
          private ProposalMapper projectMapper;
          private UserMapper userMapper;
          private POEMapper poeMapper;
	  private Connection con;
	  
	  //== Singleton start
	  private static DBFacade instance;
	 
	  private DBFacade() {
                  projectMapper = new ProposalMapper();
                  userMapper = new UserMapper();
		  con 	= DBConnector.getInstance().getConnection();  		  
	  }
	  public static DBFacade getInstance()
	  {
		  if(instance == null)
			  instance = new DBFacade();
		  return instance;
	  }
	  //== Singleton end

    public boolean submitProjectProposal(Proposal projectP) {
        
        return projectMapper.submitProjectProposal(projectP, con);
        
    }

    public boolean logIn(User ur) {
        
        return userMapper.logIn(ur, con);
        
    }

    public boolean submitPOE(POE poe) {
        
        return poeMapper.submitPOE(poe, con);
        
    }

    public boolean registerUser(User dbfUser) {
        
        return userMapper.registerUser(dbfUser, con);
        
    }
    
}
