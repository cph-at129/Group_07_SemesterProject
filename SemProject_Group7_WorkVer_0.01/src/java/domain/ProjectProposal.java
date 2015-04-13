package domain;

public class ProjectProposal {

    private int proposalID;
    private String name;
    private String submissionDate;
    private String approvalDate;
    private String partnerName;

    public ProjectProposal(int proposalID, String name, String submissionDate, String partnerName) {

        this.proposalID = proposalID;
        this.name = name;
        this.submissionDate = submissionDate;
        this.partnerName = partnerName;

    }

    public ProjectProposal(int proposalID, String name, String submissionDate, String approvalDate, String partnerName) {

        this.proposalID = proposalID;
        this.name = name;
        this.submissionDate = submissionDate;
        this.approvalDate = approvalDate;
        this.partnerName = partnerName;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public int getProposalID() {
        return proposalID;
    }

    public void setProposalID(int proposalID) {
        this.proposalID = proposalID;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }
    
    @Override
    public String toString() {

        return proposalID + "  " + name + "  " + submissionDate + "  " + partnerName + "  ";

    }
    public String toString1() {

        return proposalID + "  " + name + "  " + submissionDate + "  " + approvalDate + "  " + partnerName + "  ";
    }
}
