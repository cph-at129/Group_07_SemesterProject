
package domain;

public class ProjectProposal {
    
    private String partnerName;
    private String country;
    private String activity;
    
    
    public ProjectProposal(String partnerName, String country, String activity){
    
      this.partnerName = partnerName;
      this.country = country;
      this.activity = activity;
    
    }
    
    
    
    
    
    

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    @Override
    public String toString(){
    
      return partnerName + "  " + country + "  " + activity + "  ";
    
    }
}
