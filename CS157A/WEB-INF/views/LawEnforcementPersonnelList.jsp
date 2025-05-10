<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="src.model.LawEnforcementPersonnel" %>
<%
    List<LawEnforcementPersonnel> listLawEnforcementPersonnel = (List<LawEnforcementPersonnel>) request.getAttribute("listLawEnforcementPersonnel");
%>
<html>
<head>
    <title>Law Enforcement Personnel Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <ul class="navbar-nav">
                <li><a href="<%= request.getContextPath() %>/list" class="nav-link">Investigation System</a></li>
            </ul>
        </nav>
    </header>
    <br>

    <div class="row">
        <div class="container">
            <h3 class="text-center">List of Law Enforcement Personnel</h3>
            <hr>
            <div class="container text-left">
                <a href="<%= request.getContextPath() %>/lawEnforcementPersonnel/register" class="btn btn-success">Add New Personnel</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Personnel ID</th>
                        <th>Name</th>
                        <th>Role</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    if (listLawEnforcementPersonnel != null) {
                        for (LawEnforcementPersonnel lawEnforcementPersonnel : listLawEnforcementPersonnel) {
                %>
                <tr>
                    <td><%= lawEnforcementPersonnel.getPersonnelID() %></td>
                    <td><%= lawEnforcementPersonnel.getName() %></td>
                    <td><%= lawEnforcementPersonnel.getRole() %></td>
                    <td>
                        <a href="<%= request.getContextPath() %>/lawEnforcementPersonnel/edit?personnelID=<%= lawEnforcementPersonnel.getPersonnelID() %>">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%= request.getContextPath() %>/lawEnforcementPersonnel/delete?personnelID=<%= lawEnforcementPersonnel.getPersonnelID() %>">Delete</a>                    </td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
