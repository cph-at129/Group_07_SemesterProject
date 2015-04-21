
package dataSource.mappers;

import domain.Partner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PartnerMapper {
    
    public boolean registerPartner(Partner partnerMapper, Connection con){
    
        int rowsInserted = 0;

        String sqlString
                = "INSERT INTO partner"
                + " VALUES (seq_partner.nextval, ?, ?)";

        PreparedStatement statement = null;

        try {

            statement = con.prepareStatement(sqlString);
          
            statement.setString(1, partnerMapper.getCompanyName());
            statement.setString(2, partnerMapper.getCountry());

            statement.executeQuery();

            rowsInserted = statement.executeUpdate();

        } catch (Exception e) {

            System.out.println("Fail1 in PartnerMapper - registerPartner");
            System.out.println(e.getMessage());

        } finally {

            try {
                    statement.close();
                    
            } catch (SQLException e) {

                System.out.println("Fail2 in PartnerMapper - partnerMapper");
                System.out.println(e.getMessage());
            }

        }
        return rowsInserted == 1;
    }
    
}
