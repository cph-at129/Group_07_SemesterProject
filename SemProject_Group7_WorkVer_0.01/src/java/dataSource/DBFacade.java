
package dataSource;

import dataSource.mappers.PartnerMapper;
import dataSource.mappers.ProjectMapper;
import dataSource.mappers.UserMapper;
import domain.Partner;
import domain.Project;
import domain.User;
import java.sql.Connection;
import java.util.ArrayList;

/*
   - provides a facade to the Data Source Layer
   - encapsulates connection handling
   - is Singleton
*/

public class DBFacade {

          private UserMapper userMapper;
          private PartnerMapper partnerMapper;
          private ProjectMapper projectMapper;
	  private Connection con;
	  
	  //== Singleton start
	  private static DBFacade instance;
	 
	  private DBFacade() {
                  partnerMapper = new PartnerMapper();
                  userMapper = new UserMapper();
                  projectMapper = new ProjectMapper();
		  con 	= DBConnector.getInstance().getConnection();  		  
	  }
	  public static DBFacade getInstance()
	  {
		  if(instance == null)
			  instance = new DBFacade();
		  return instance;
	  }

    public boolean logIn(User ur) {
        
        return userMapper.logIn(ur, con);
        
    }
    
    public boolean registerPartner(Partner dbfPartner){
    
        return partnerMapper.registerPartner(dbfPartner, con);
    
    }

    public boolean registerUser(User dbfUser) {
        
        return userMapper.registerUser(dbfUser, con);
        
    }
    public boolean registerDellEmployee(User dbfUser){
    
        return userMapper.registerDellEmployee(dbfUser, con);
    
    }
    
    public ArrayList<Project> getProjects(){
    
        return projectMapper.getProjects(con);
    
    }
    
}
