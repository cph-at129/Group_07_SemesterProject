
package domain;


public class Project {
    
    private int projectID;
    private String projectName;
    private String startDate;
    private String endDate;
    private int budget;
    private int partnerID;
    private String type;
    private int qbid;
    private String completed;
    
    public Project(String projectName, String startDate, String endDate, int budget, String completed) {
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.completed = completed;
    }

    public Project(int projectID, String projectName, String startDate, String endDate,
            int budget, int partnerID, String type,int qbid, String completed) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.partnerID = partnerID;
        this.type = type;
        this.qbid = qbid;
        this.completed = completed;
    }

    public int getQbid() {
        return qbid;
    }

    public void setQbid(int qbid) {
        this.qbid = qbid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    
    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
    
    @Override
    public String toString(){
    
        return  projectID + "  " + projectName + "  " +  startDate + "  " +  endDate 
                + "  " + budget + "  "  + partnerID + "  " + type + "  " + qbid + "  " + completed;
     
    }
    public String toString1(){
    
        return  projectName + "  " +  startDate + "  " +  endDate + "  " + budget + "  " + completed;
     
    }
}
