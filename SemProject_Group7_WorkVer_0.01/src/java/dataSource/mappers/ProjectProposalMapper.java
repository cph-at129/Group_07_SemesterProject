
/*
 THIS CLASS IS ORGANIZING THE DATA TRANSPORT
 BETWEEN THE DOMAIN LAYER AND THE DATABASE
 */
package dataSource.mappers;

import domain.ProjectProposal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * - THE CLASS MUST DEVELOP THE OBJECT MODEL AND THE DATABASE SCHEMA
 * INDEPENDETLY
 *
 * - should isolate SQL from Domain logic
 *
 * - maps between classes and tables
 */
public class ProjectProposalMapper {

    /*
     the method should submit new ProjectProposal to the Database
     */
    public boolean submitProjectProposal(ProjectProposal projectP, Connection con) {

        int rowsInserted = 0;
        
        String SQLString2
                = "insert into projectprop "
                + "values (?,?,?)";
        
        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(SQLString2);

            statement.setString(1, projectP.getPartnerName());
            statement.setString(2, projectP.getCountry());
            statement.setString(3, projectP.getActivity());
            
            statement.executeQuery();
            rowsInserted = statement.executeUpdate(SQLString2);

        } catch (Exception e) {
            System.out.println("Fail1 in ProjectProposalMapper - submitProjectProposal");
            System.out.println(e.getMessage());
        } finally
        {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail2 in ProjectProposalMapper - submitProjectProposal");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;

    }

    /*
     the method should open ProjectProposal from the database
     */
//    public ProjectProposal openProjectProposal(int projectID, Connection con) {
//
//      //build SELECT statement
//      //execute statement
//      //transfer projectProposal from Database to a ??Collection??
//      //return Domain object  
//    }
}
