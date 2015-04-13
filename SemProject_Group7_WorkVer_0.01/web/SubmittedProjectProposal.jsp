<%-- 
    Document   : SubmittedProjectProposal
    Created on : 11-Apr-2015, 20:33:59
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
        
        <h1>Review of the submitted project proposal</h1><br/>
        <br/>
        <p>Partner name: <%= request.getAttribute("partnerName") %></p><br/>
        <br/>
        <p>Country <%= request.getAttribute("country") %></p><br/>
        <br/>
        <p>Activity: <%= request.getAttribute("activity") %></p><br/>
        <br/>
    </body>
</html>
