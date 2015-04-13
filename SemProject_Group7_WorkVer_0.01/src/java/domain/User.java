
package domain;

public class User {
    
    private int userID;
    private String login;
    private String password;
    private int partnerID;
    private String fName;
    private String lName;
    private String phone;

    public User(String login, String password, String fName, String lName, String phone) {
        this.login = login;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
    }

    public User(int userID, String login, String password, int partnerID, String fName, String lName, String phone) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.partnerID = partnerID;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   @Override
    public String toString(){
    
        return  userID + "  " + login + "  " +  password + "  " + partnerID + "  " +  fName + "  " + lName + "  "  + phone;
     
    }
    public String toString1(){
    
        return  login + "  " +  password + "  " +  fName + "  " + lName + "  "  + phone;
     
    }
}
