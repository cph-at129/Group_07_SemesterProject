<%-- 
    Document   : DellTemplate
    Created on : 13-Apr-2015, 21:41:47
    Author     : Aleksandar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="DellTemplate.css">
        <title>Dell Template</title>
    </head>
    <body>
        <p>You logged in successfully!</p><br/>
        <div class="header">
            <h1>Welcome! Here you can manage your projects!</h1>
        </div>  
        <div class="nav">
            <div class="container">
                <form action="UIServlet">
                    <input type="hidden" name="command" value="viewNewProjects"/>    
                    <button type="submit" name="newProjectsButton">view new Projects</button><br/>
                    <input type="hidden" name="command" value="viewPendingPOE"/>
                    <button type="submit" name="pendingProjectsButton">view Pending POE's</button><br/>
                    <input type="hidden" name="command" value="createProject"/>
                    <button type="submit" name="createProjectButton">Create Project</button><br/>
                </form>
            </div>
        </div>
    </body>
</html>
