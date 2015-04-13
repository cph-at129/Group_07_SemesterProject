/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource.mappers;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aleksandar
 */
public class UserMapper {

    public boolean logIn(User ur, Connection con) {

        int rowsInserted = 0;

        String SQLString
                = "INSERT INTO user "
                + "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(SQLString);

            statement.setString(1, ur.getUserID());
            statement.setString(2, ur.getPassword());
            statement.setString(3, ur.getfName());
            statement.setString(4, ur.getlName());
            statement.setString(5, ur.getPhone());

            statement.executeQuery();
            rowsInserted = statement.executeUpdate(SQLString);

        } catch (Exception e) {
            System.out.println("Fail1 in UserMapper - logIn");
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail2 in UserMapper - logIn");
                System.out.println(e.getMessage());
            }
        }
        return rowsInserted == 1;

    }

}
