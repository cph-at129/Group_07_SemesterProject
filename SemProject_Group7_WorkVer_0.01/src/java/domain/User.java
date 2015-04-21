
package domain;

public class User {
    
    private int userID;
    private String login;
    private String password;
    private int partnerID;
    private String fName;
    private String lName;
    private String phone;
    private String type;

    public User(String login, String password, String fName, String lName, String phone, String type) {
        this.login = login;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.type = type;
    }

    public User(String login, String password) {
        
        this.login = login;
        this.password = password;
    }

    public User(int userID, String login, String password, int partnerID, String fName, String lName, String phone, String type) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.partnerID = partnerID;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
   @Override
    public String toString(){
    
        return  userID + "  " + login + "  " +  password + "  " + partnerID + "  " +  fName + "  " + lName + "  "  + phone;
     
    }
    public String toString1(){
    
        return  login + "  " +  password + "  " +  fName + "  " + lName + "  "  + phone;
     
    }
}
