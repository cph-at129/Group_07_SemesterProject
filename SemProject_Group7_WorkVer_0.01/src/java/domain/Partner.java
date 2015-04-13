
package domain;


public class Partner {
    
    private int partnerID;
    private String companyName;
    private String country;
    private String address;

    public Partner(String companyName, String country, String address) {
        this.companyName = companyName;
        this.country = country;
        this.address = address;
    }

    public Partner(int partnerID, String companyName, String country, String address) {
        this.partnerID = partnerID;
        this.companyName = companyName;
        this.country = country;
        this.address = address;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString(){
    
        return  partnerID + "  " +  companyName + "  " +  country + "  " + address;
     
    }
    public String toString1(){
    
        return  companyName + "  " +  country + "  " + address;
     
    }
    
}
