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
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9)));

            }
            for (Project p : projectList) {

                System.out.println(p.toString());

            }

        } catch (Exception e) {

            System.out.println("Fail1 in ProjectMapper - getProjects");
            System.out.println(e.getMessage());

        } finally {

            try {
                statement.close();

            } catch (SQLException e) {

                System.out.println("Fail2 in ProjectMapper - getProjects");
                System.out.println(e.getMessage());
            }

        }
        return projectList;
    }

    public boolean createNewProject(Project pro, Connection con) {

        int rowsInserted = 0;

        String sqlString
                = "INSERT INTO project "
                + "VALUES(seq_project.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);

            statement.setString(1, pro.getProjectName());
            statement.setDate(2, null);
            statement.setDate(3, null);
            statement.setInt(4, pro.getBudget());
            statement.setInt(5, pro.getPartnerID());
            statement.setString(6, pro.getType());
            statement.setInt(7, pro.getQbid());
            statement.setString(8, pro.getCompleted());

            statement.executeQuery();

            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {

            System.out.println("Fail in ProjectMapper - createNewProject");
            System.out.println(e.getMessage());
        } finally {

            try {

                statement.close();

            } catch (SQLException e) {

                System.out.println("Fail2 in ProjectMapper - createNewProject");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;
    }
}
