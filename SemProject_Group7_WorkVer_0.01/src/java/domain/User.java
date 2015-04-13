
package domain;

public class User {
    
    private String userID;
    private String password;
    private String fName;
    private String lName;
    private String phone;
    
    public User(String userID, String password, String fName, String lName, String phone){
    
        this.userID = userID;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
   @Override
   public String toString(){
   
      return userID + "  " + password + "  " + fName + "  " + lName + "  " + phone;
   
   }
}
