/*
 provides an interface to the services offered by the system
 handles communication between user and system (input and output)
 typically Java Swing classes or an HTML browser
 uses the services of the Domain Layer

 */
package presentation;

import domain.Controller;
import java.io.IOException;
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

            case "registerUser":
                registerUser(request, response, con);
                break;
            case "logIn":
                logIn(request, response, con);
                break;
            case "submitNewProjectProposal":
                submitProjectProposal(request, response, con);
                break;
            case "submitPOE":
                submitPOE(request, response, con);
                break;
        }

    }
    /*
     the method should save a new user in the database
      
     */

    private void registerUser(HttpServletRequest request,
            HttpServletResponse response,
            Controller con) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String phone = request.getParameter("phone");

        boolean status = con.registerUser(login, password, fName, lName, phone);

        if (status) {
            //load the login page
            
        } else {
            //reset the register page
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

        boolean status = con.logIn(login, password);

        if (status) {
            //load Dell or Partner information from the Database
            //and dispay it in jsp page

            loadDellTemplate(request, response);

            

        } else {
            //reset the login page
        }

    }

    private void loadDellTemplate(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException{

        RequestDispatcher dispatcher = request.getRequestDispatcher("DellTemplate.jsp");
        dispatcher.forward(request, response);
        
    }
    /*
     the method saves the ProjectProposal in the Database
     and checks if it is saved successfuly or not 
     */

    private boolean submitProposal(HttpServletRequest request,
            HttpServletResponse response,
            Controller con) throws ServletException, IOException {

        String partnerName = request.getParameter("partnerName");
        String country = request.getParameter("country");
        String activity = request.getParameter("activity");

        //send the input to the Controller and check the status 
        boolean status = con.submitProjectProposal(partnerName, country, activity);


        return status;
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
