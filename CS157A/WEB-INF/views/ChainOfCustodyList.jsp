<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="src.model.ChainOfCustody" %>
<%
    List<ChainOfCustody> listChainOfCustody = (List<ChainOfCustody>) request.getAttribute("listChainOfCustody");
%>
<html>
<head>
    <title>Chain of Custody Management</title>
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
            <h3 class="text-center">List of Chain of Custody</h3>
            <hr>
            <div class="container text-left">
                <a href="<%= request.getContextPath() %>/chainofcustody/register" class="btn btn-success">Add New Chain of Custody</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Personnel ID</th>
                        <th>Evidence ID</th>
                        <th>Date Logged</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (listChainOfCustody != null) {
                            for (ChainOfCustody chain : listChainOfCustody) {
                    %>
                    <tr>
                        <td><%= chain.getPersonnelID() %></td>
                        <td><%= chain.getEvidenceID() %></td>
                        <td><%= chain.getDateLogged() %></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/chainofcustody/edit?personnelID=<%= chain.getPersonnelID() %>&evidenceID=<%= chain.getEvidenceID() %>&dateLogged=<%= chain.getDateLogged() %>">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%= request.getContextPath() %>/chainofcustody/delete?personnelID=<%= chain.getPersonnelID() %>&evidenceID=<%= chain.getEvidenceID() %>&dateLogged=<%= chain.getDateLogged() %>">Delete</a>
                        </td>
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
