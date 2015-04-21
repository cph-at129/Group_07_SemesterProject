
package domain;


public class Partner {
    
    private int partnerID;
    private String companyName;
    private String country;

    public Partner(String companyName, String country) {
        this.companyName = companyName;
        this.country = country;

    }

    public Partner(int partnerID, String companyName, String country) {
        this.partnerID = partnerID;
        this.companyName = companyName;
        this.country = country;

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

    @Override
    public String toString(){
    
        return  partnerID + "  " +  companyName + "  " +  country;
     
    }
    public String toString1(){
    
        return  companyName + "  " +  country;
     
    }
    
}
