
package dataSource.mappers;

import domain.POE;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*   THIS CLASS IS ORGANIZING THE DATA TRANSPORT
     BETWEEN THE DOMAIN LAYER AND THE DATABASE
*/
public class POEMapper {
    
    //THE CLASS MUST DEVELOP THE OBJECT MODEL AND THE DATABASE SCHEMA INDEPENDETLY
    
    //should isolate SQL from Domain logic
    
    //maps between classes and tables
    
    
    /*
       the method should open POE from the database
    */
//    public POE openPOE(int poeID, Connection con){
//    
//      //build SELECT statement
//      
//      //execute statement
//        
//      //transfer POE from Database to a ??Collection??
//        
//      //return Domain object  
//    
//    }
//    
    /*
      the method should save new POE to the Database
    */
    public boolean submitPOE(POE poe, Connection con){
    
        int rowsInserted = 0;
        
        String sqlString = 
                "INSERT INTO poe"
                + "VALUES (?,?,?)";
        
        PreparedStatement statement = null;
        
        try {
            
            statement = con.prepareStatement(sqlString);
            
            statement.setInt(1, poe.getPoeID());
            statement.setInt(2, poe.getPartnerID());
            statement.setString(3, poe.getSubmissionDate());
            
            statement.executeQuery();
            
            rowsInserted = statement.executeUpdate();
            
        } catch (Exception e) {
            
            System.out.println("Fail1 in POEMapper - submitPOE");
            System.out.println(e.getMessage());
        }finally{
        
            try {
                
                statement.close();
                
            } catch (SQLException e) {
                
                System.out.println("Fail2 in POEMapper - submitPOE");
                System.out.println(e.getMessage());
            }
        
        }
        return rowsInserted == 1;
    }
    
}
