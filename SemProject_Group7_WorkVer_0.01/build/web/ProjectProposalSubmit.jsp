<%-- 
    Document   : SubmitProjectProposal
    Created on : 09-Apr-2015, 13:05:10
    Author     : Aleksandar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Project Proposal Submit form</h1><br/>
        <br/>
        <form action="UIServlet">
        <p>Company name</p>
        <input type="text" name="partnerName"/><br/>
        <br/>
        <p>Country</p>
        <input type="text" name="country"/><br/>
        <br/>
        <p>Activity</p>
        <input type="text" name="activity"/><br/>
        <br/>
        <button type="submit">Submit</button><br/>
        </form>
    </body>
</html>
