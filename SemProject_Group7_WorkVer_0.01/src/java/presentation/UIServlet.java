/*
  provides an interface to the services offered by the system
  handles communication between user and system (input and output)
  typically Java Swing classes or an HTML browser
  uses the services of the Domain Layer

*/
package presentation;

import domain.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UIServlet", urlPatterns = {"/UIServlet"})
public class UIServlet extends HttpServlet {

    Controller con;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        con = con.getInstance();
        submitProjectProposal(request, response, con);
        
        
    }
    /*
      the method should check the provided input and return 
      the status
    */
//    private boolean logIn(String id, String password){
//    
//      
//    
//    }
    
    /*
      the method should take the filled form 
      and return true if the submit is successfull
    */
    private boolean submitProjectProposal(HttpServletRequest request, 
                                          HttpServletResponse response,
                                          Controller con){
       //get the input
       String partnerName = request.getParameter("partnerName");
       String country = request.getParameter("country");
       String activity = request.getParameter("activity");
       
        System.out.println("IN UISERVLET  " + partnerName);
       
       //send the input to the Controller and check the status 
       boolean status = con.submitProjectProposal(partnerName, country, activity);
       
       return status;
    }
    /*
      the method should return the projectProposal 
      according to the provided projectProposalID parameter
    */
//    private ProjectProposal reviewProjectProposal(projectProposalID){
//    
//      
//    
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
