package dataSource.mappers;

import domain.Project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectMapper {

    ArrayList<Project> projectList;

    public ProjectMapper() {

        projectList = new ArrayList<Project>();

    }

    public ArrayList<Project> getProjects(Connection con) {

        String sqlString
                = "SELECT * FROM project";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                projectList.add(new Project(rs.getInt(1),
                rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5),
                rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
            
            }
            for (Project p : projectList) {
                
                System.out.println(p.toString());
                
            }

        } catch (Exception e) {
            
            System.out.println("Fail1 in ProjectMapper - getProjects");
            System.out.println(e.getMessage());

        }finally{
        
            try {
                statement.close();
                
            } catch (SQLException e) {
                
                System.out.println("Fail2 in ProjectMapper - getProjects");
                System.out.println(e.getMessage());
            }
        
        }
        return projectList;
    }

}
