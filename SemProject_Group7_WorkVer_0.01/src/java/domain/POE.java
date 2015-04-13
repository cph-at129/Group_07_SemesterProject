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
    private String submissionDate;
    
    public POE( int poeID, String submissionDate){
    
        this.poeID = poeID;
        this.submissionDate = submissionDate;
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
    
}
