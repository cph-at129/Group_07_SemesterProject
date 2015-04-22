/*
 provides an interface to the services offered by the system
 handles communication between user and system (input and output)
 typically Java Swing classes or an HTML browser
 uses the services of the Domain Layer

 */
package presentation;

import domain.Project;
import domain.controller.Controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UIServlet", urlPatterns = {"/UIServlet"})
public class UIServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessionObj = request.getSession();
        Controller con = (Controller) sessionObj.getAttribute("Controller");
        if (con == null) {
            // Session starts
            con = new Controller();
            sessionObj.setAttribute("Controller", con);
        } else {
            con = (Controller) sessionObj.getAttribute("Controller");
        }

        String command = request.getParameter("command");

        switch (command) {

            case "registerNewPartner":
                registerNewPartner(request, response, con);
                break;
            case "logIn":
                logIn(request, response, con);
                break;
            case "createNewProject":
                createNewProject(request, response, con);
                break;
            case "submitPOE":
                submitPOE(request, response, con);
                break;
            case "viewNewProjects":
                viewNewProjects(request, response, con);
                break;
            case "registerDellEmployee":
                registerDellEmployee(request, response, con);
        }

    }
    private void registerDellEmployee(HttpServletRequest request, HttpServletResponse response, Controller con)
            throws ServletException, IOException{
    
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String phone = request.getParameter("phone");
        
        boolean status = con.registerDellEmployee(login, password, fName, lName, phone);
        
    
    }
    
    private void viewNewProjects(HttpServletRequest request, HttpServletResponse response, Controller con)
            throws ServletException, IOException{
    
        //get projects in a collection
        ArrayList<Project> projectsList = con.getProjects();
        
        request.setAttribute("projectsList", projectsList);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("DellTemplate_ShowNewProjects.jsp");
        dispatcher.forward(request, response);
    
    }
    
    /*
     the method should save a new user in the database
      
     */

    private void registerNewPartner(HttpServletRequest request,
            HttpServletResponse response,
            Controller con) throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String companyName = request.getParameter("companyName");
        String country = request.getParameter("country");
        String phone = request.getParameter("phone");
        
        boolean status = con.registerNewPartner(login, password, fName, lName, companyName, country, phone);

        
        if (status) {
            //load the login page
            RequestDispatcher dispatcher = request.getRequestDispatcher("LogIn.html");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("IncorrectSignUp.html");
            dispatcher.forward(request, response);
        }
    }

    /*
     the method checks if the user has logged in successfully
     */
    private void logIn(HttpServletRequest request,
            HttpServletResponse response,
            Controller con) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        if(login.equals("admin")){
        
            boolean statusAdmin = con.logInAsAdmin(login, password);
            
            if(statusAdmin){
            
                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminTemplate.html");
                dispatcher.forward(request, response);
            
            }
        
        }
        boolean statusPartner = con.logInAsPartner(login, password);
        
        if(statusPartner){
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("PartnerTemplate.html");
            dispatcher.forward(request, response);
        
        }
        
        boolean statusDell = con.logIn(login, password);

        if (statusDell) {
            //load Dell or Partner information from the Database
            //and dispay it in jsp page

            loadDellTemplate(request, response);

            

        } else {
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("IncorrectLogIn.html");
            dispatcher.forward(request, response);
            
        }

    }

    private void loadDellTemplate(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{

        RequestDispatcher dispatcher = request.getRequestDispatcher("DellPage.html");
        dispatcher.forward(request, response);
        
    }
    /*
     the method saves the ProjectProposal in the Database
     and checks if it is saved successfuly or not 
     */

    private boolean createNewProject(HttpServletRequest request,
            HttpServletResponse response,
            Controller con) throws ServletException, IOException {

        

        //send the input to the Controller and check the status 
        //boolean status = con.submitProjectProposal(partnerName, country, activity);
        
        return true;
    }

    /*
     the method saves the POE in the Database 
     and checks if it's saved successfully or not
     */
    private boolean submitPOE(HttpServletRequest request,
            HttpServletResponse response,
            Controller con) throws ServletException, IOException {

        //boolean status = con.submitPOE();
        return true;
    }

    private boolean submitDocuments(HttpServletRequest request,
            HttpServletResponse response,
            Controller con) throws ServletException, IOException {

        //boolean status = con.submitDocuments();
        return true;

    }

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
