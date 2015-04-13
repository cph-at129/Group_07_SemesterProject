
package domain;

public class Proposal {
    
    private int proposalID;
    private String proposalName;
    private String submissionDate;
    private String approvalDate;
    private int partnerID;
    
    public Proposal(String proposalName, String submissionDate, String approvalDate){
    
      this.proposalName = proposalName;
      this.submissionDate = submissionDate;
      this.approvalDate = approvalDate;
    
    }

    public Proposal(int proposalID, String proposalName, String submissionDate, String approvalDate, int partnerID) {
        this.proposalID = proposalID;
        this.proposalName = proposalName;
        this.submissionDate = submissionDate;
        this.approvalDate = approvalDate;
        this.partnerID = partnerID;
    }

    public int getProposalID() {
        return proposalID;
    }

    public void setProposalID(int proposalID) {
        this.proposalID = proposalID;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }   

    public String getProposalName() {
        return proposalName;
    }

    public void setProposalName(String proposalName) {
        this.proposalName = proposalName;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }
    @Override
    public String toString(){
    
      return proposalName + "  " + submissionDate + "  " + approvalDate;
    
    }
    public String toString1(){
    
      return proposalID + "  " + proposalName + "  " + submissionDate + "  " + approvalDate + "  " + partnerID;
    
    }
}
