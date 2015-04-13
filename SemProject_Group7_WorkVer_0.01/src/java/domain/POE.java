/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Aleksandar
 */
public class POE {
    
    private int poeID;
    private int partnerID;
    private String submissionDate;
    private String approvalDate;

    public POE(String submissionDate, String approvalDate) {
        this.submissionDate = submissionDate;
        this.approvalDate = approvalDate;
    }

    public POE(int poeID, int partnerID, String submissionDate, String approvalDate) {
        this.poeID = poeID;
        this.partnerID = partnerID;
        this.submissionDate = submissionDate;
        this.approvalDate = approvalDate;
    }
    

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public int getPoeID() {
        return poeID;
    }

    public void setPoeID(int poeID) {
        this.poeID = poeID;
    }
    
    @Override
    public String toString(){
    
        return  poeID + "  " +  partnerID + "  " +  submissionDate + "  " + approvalDate;
     
    }
    public String toString1(){
    
        return  submissionDate + "  " + approvalDate;
     
    }
}
