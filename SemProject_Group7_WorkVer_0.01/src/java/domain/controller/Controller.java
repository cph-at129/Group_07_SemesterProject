/*
 provides interface to the application logic and data	
 interprets commands from Presentation Layer
 performs calculations and enforces business rules on basis of input and stored data
 uses the services of the Data Source Layer
 */
package domain.controller;

import dataSource.DBFacade;
import domain.POE;
import domain.Partner;
import domain.Project;
import domain.Proposal;
import domain.User;
import domain.passwordEncryption.PasswordEncryptor;
import java.util.ArrayList;


/*

 - provides a facade to the Domain Layer
 - holds the state of the business transaction
 - perform business logic
 - registers all objects affected during the business transaction with a Unit of Work object (through the DBFacade)
 - is Singleton to ensure unambiguous state

 */
public class Controller {

    private DBFacade dbf;
    private Proposal conProposal;
    private User conUser;
    private Project conProject;
    private POE conPOE;
    private Partner conPartner;

    public Controller() {

        dbf = DBFacade.getInstance();
        conProposal = null;
        conUser = null;
        conProject = null;
        conPOE = null;
        conPartner = null;

    }
    /*
     the method should return true if the new Partner is registered successfully
     in the Database
     */

    public boolean registerNewPartner(String login, String password, String fName, String lName,
            String companyName, String country, String phone) {

        String type = "Partner";

        conPartner = new Partner(companyName, country);

        boolean status = dbf.registerPartner(conPartner);

        if (status) {

            PasswordEncryptor pe = new PasswordEncryptor();
            String encryptedPassword = pe.encryptPassword_SHA1(password);

            conUser = new User(login, encryptedPassword, fName, lName, phone, type);

            status = dbf.registerUser(conUser);
        }
        return status;

    }

    public boolean registerDellEmployee(String login, String password, String fName, String lName, String phone) {

        String type = "Dell";
        
        PasswordEncryptor pe = new PasswordEncryptor();
        String encryptedPassword = pe.encryptPassword_SHA1(password);

        conUser = new User(login, encryptedPassword, fName, lName, phone, type);

        return dbf.registerDellEmployee(conUser);

    }

    public boolean logIn(String login, String password) {

        PasswordEncryptor pe = new PasswordEncryptor();
        String encryptedPassword = pe.encryptPassword_SHA1(password);

        conUser = new User(login, encryptedPassword);

        return dbf.logIn(conUser);

    }

    public boolean logInAsAdmin(String login, String password) {

        return logIn(login, password);

    }

    public boolean logInAsPartner(String login, String password) {

        PasswordEncryptor pe = new PasswordEncryptor();
        String encryptedPassword = pe.encryptPassword_SHA1(password);

        conUser = new User(login, encryptedPassword);

        return dbf.logInAsPartner(conUser);

    }

    public ArrayList<Project> getProjects() {

        return dbf.getProjects();

    }

////submit project proposal
//    public boolean submitProjectProposal(String partnerName, String country, String activity){
//        
//        conProposal = new Proposal(partnerName, country, activity);
//        
//        System.out.println("IN controller");
//        System.out.println(conProposal);
//        boolean status = dbf.submitProjectProposal(conProposal);
//        
//        return status;
//    }
}
