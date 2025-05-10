<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="src.model.Evidence" %>
<%
    List<Evidence> listEvidence = (List<Evidence>) request.getAttribute("listEvidence");
%>
<html>
<head>
    <title>Evidence Management</title>
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
            <h3 class="text-center">List of Evidence</h3>
            <hr>
            <div class="container text-left">
                <a href="<%= request.getContextPath() %>/evidence/register" class="btn btn-success">Add New Evidence</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Evidence ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Type</th>
                        <th>Date Collected</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (listEvidence != null) {
                            for (Evidence evidence : listEvidence) {
                    %>
                    <tr>
                        <td><%= evidence.getEvidenceID() %></td>
                        <td><%= evidence.getTitle() %></td>
                        <td><%= evidence.getDescription() %></td>
                        <td><%= evidence.getEvidenceType() %></td>
                        <td><%= evidence.getDateCollected() %></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/evidence/edit?evidenceID=<%= evidence.getEvidenceID() %>">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%= request.getContextPath() %>/evidence/delete?evidenceID=<%= evidence.getEvidenceID() %>">Delete</a>
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
