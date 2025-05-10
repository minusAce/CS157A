<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="src.model.CaseEvidence" %>
<%
    List<CaseEvidence> listCaseEvidence = (List<CaseEvidence>) request.getAttribute("listCaseEvidence");
%>
<html>
<head>
    <title>Case Evidence Management</title>
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
            <h3 class="text-center">List of Case Evidence</h3>
            <hr>
            <div class="container text-left">
                <a href="<%= request.getContextPath() %>/caseevidence/register" class="btn btn-success">Add New Case Evidence</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Case ID</th>
                        <th>Evidence ID</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (listCaseEvidence != null) {
                            for (CaseEvidence caseEvidence : listCaseEvidence) {
                    %>
                    <tr>
                        <td><%= caseEvidence.getCaseID() %></td>
                        <td><%= caseEvidence.getEvidenceID() %></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/caseevidence/edit?caseID=<%= caseEvidence.getCaseID() %>">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="<%= request.getContextPath() %>/caseevidence/delete?caseID=<%= caseEvidence.getCaseID() %>">Delete</a>
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