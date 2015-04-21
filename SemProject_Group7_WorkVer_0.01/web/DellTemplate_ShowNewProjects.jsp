<%--
    Document   : DellTemplate_ShowProjects
    Created on : 20-Apr-2015, 15:54:37
    Author     : Aleksandar
--%>

<%@page import="domain.Project"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projects</title>
    </head>
    <body>
        <h1>Here you can see your projects!</h1><br/>
        <% ArrayList<Project> projectsList = (ArrayList<Project>) request.getAttribute("projectsList");%>
        <div class="NewProjects">
            <div class="container">
                <form action="UIServlet">
                    <ul>
                        <% for (Project p : projectsList) {%>
                        <li>
                            <p>
                                <%= p.getProjectName()%>
                                <button type="button" name="openProjectDetailsButton">Open</button>
                            </p>
                        </li>
                        <% }%>
                    </ul>
                </form>
            </div>
        </div>
    </body>
</html>
