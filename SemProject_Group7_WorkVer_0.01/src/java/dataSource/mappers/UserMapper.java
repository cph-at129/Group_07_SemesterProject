package dataSource.mappers;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public boolean registerUser(User ur, Connection con) {

        int rowsInserted = 0;

        String sqlString
                = "INSERT INTO user_"
                + " VALUES ( seq_user.nextval, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);

            statement.setString(1, ur.getLogin());
            statement.setString(2, ur.getPassword());

            if (ur.getPartnerID() == 0) {
                statement.setObject(3, null);
            } else {
                statement.setInt(3, ur.getPartnerID());
            }

            statement.setString(4, ur.getfName());
            statement.setString(5, ur.getlName());
            statement.setString(6, ur.getPhone());
            statement.setString(7, ur.getType());

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

    public boolean registerDellEmployee(User ur, Connection con) {

        int rowsInserted = 0;

        String sqlString
                = "INSERT INTO user_"
                + " VALUES ( seq_user.nextval, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = null;
        try {

            statement = con.prepareStatement(sqlString);

            statement.setString(1, ur.getLogin());
            statement.setString(2, ur.getPassword());
            if (ur.getPartnerID() == 0) {
                statement.setObject(3, null);
            } else {
                statement.setInt(3, ur.getPartnerID());
            }
            statement.setString(4, ur.getfName());
            statement.setString(5, ur.getlName());
            statement.setString(6, ur.getPhone());
            statement.setString(7, ur.getType());

            statement.executeQuery();

            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {

            System.out.println("Fail1 in UserMapper - registerDellEmployee");
            System.out.println(e.getMessage());

        } finally {

            try {
                statement.close();

            } catch (SQLException e) {

                System.out.println("Fail2 in UserMapper - registerDellEmployee");
                System.out.println(e.getMessage());
            }

        }
        return rowsInserted == 1;

    }

    public boolean logIn(User ur, Connection con) {

        boolean correct = false;

        User userDetails = null;

        //check if the userID exist in the database
        String sqlString
                = "SELECT * "
                + "FROM user_ u "
                + "WHERE u.login = ? ";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);

            statement.setString(1, ur.getLogin());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                userDetails = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );

            }
            if (!ur.getPassword().isEmpty() && !userDetails.getPassword().isEmpty()) {
                if (ur.getPassword().equals(userDetails.getPassword())) {

                    correct = true;
                }
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
        return correct;
    }

    public boolean logInAsPartner(User ur, Connection con) {

        boolean status = false;

        User userDetails = null;

        //check if the userID exist in the database
        String sqlString
                = "SELECT * "
                + "FROM user_ u "
                + "WHERE u.login = ? ";

        String sqlString1
                = "SELECT u.type "
                + "FROM user_ u "
                + "WHERE u.login = ? ";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);

            statement.setString(1, ur.getLogin());
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                userDetails = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );

            }
            if (!ur.getPassword().isEmpty() && !userDetails.getPassword().isEmpty()) {
                if (ur.getPassword().equals(userDetails.getPassword())) {
                    if (userDetails.getType().equals("Partner")) {
                        status = true;
                    }
                }
            }
        } catch (Exception e) {

            System.out.println("Fail in UserMapper - logInAsPartner");
            System.out.println(e.getMessage());
        } finally {

            try {

                statement.close();

            } catch (SQLException e) {

                System.out.println("Fail2 in UserMapper - logInAsPartner");
                System.out.println(e.getMessage());
            }

        }
        return status;
    }

    public int getCurrentUserID(String currentUserLogin, Connection con) {
        
        int userID = 0;

        User userDetails = null;

        //check if the userID exist in the database
        String sqlString
                = "SELECT u.userID "
                + "FROM user_ u "
                + "WHERE u.login = ? ";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);

            statement.setString(1, currentUserLogin);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            
                userID = rs.getInt(1);
            
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
        return userID;
        
    }
}
