package dataSource.mappers;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public boolean registerUser(User ur, Connection con) {

        int rowsInserted = 0;

        System.out.println("In User Mapper ->>>>>>>>>>>>>>");
        System.out.println(ur.toString1());

        String sqlString
                = "INSERT INTO user_"
                + " VALUES (?,?,?,?,?,?,?)";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);

            statement.setInt(1, ur.getUserID());
            statement.setString(2, ur.getLogin());
            statement.setString(3, ur.getPassword());
            statement.setInt(4, ur.getPartnerID());
            statement.setString(5, ur.getfName());
            statement.setString(6, ur.getlName());
            statement.setString(7, ur.getPhone());

            statement.executeQuery();

            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {

            System.out.println("Fail1 in UserMapper - registerUser");
            System.out.println(e.getMessage());

        } finally {

            try {
                statement.close();
            } catch (SQLException e) {

                System.out.println("Fail2 in UserMapper - registerUser");
                System.out.println(e.getMessage());
            }

        }
        return rowsInserted == 1;
    }

    public boolean logIn(User ur, Connection con) {

        //check if the userID exist in the database
        String sqlString
                = "SELECT u.userID "
                + "FROM user_ u "
                + "WHERE u.login = ? ";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);

            statement.setString(1, ur.getLogin());
            ResultSet rs = statement.executeQuery();

            if (rs == null) {

                //login does not exist
                return false;

            }
        } catch (Exception e) {

            System.out.println("Fail in UserMapper - logIn");
            System.out.println(e.getMessage());
        } finally {

            try {

                statement.close();

            } catch (SQLException e) {

                System.out.println("Fail2 in UserMapper - logIn");
                System.out.println(e.getMessage());
            }

        }
        return true;
    }

}
