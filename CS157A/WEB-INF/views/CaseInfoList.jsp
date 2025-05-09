<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="src.model.CaseInfo" %>
<%
    List<CaseInfo> listCaseInfo = (List<CaseInfo>) request.getAttribute("listCaseInfo");
%>
<html>
<head>
    <title>Case Info Management</title>
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
        <h3 class="text-center">List of Cases</h3>
        <hr>
        <div class="container text-left">
            <a href="<%= request.getContextPath() %>/caseinfo/register" class="btn btn-success">Add New Case Info</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Case ID</th>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Date Opened</th>
                    <th>Date Closed</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (listCaseInfo != null) {
                        for (CaseInfo caseInfo : listCaseInfo) {
                %>
                <tr>
                    <td><%= caseInfo.getCaseID() %></td>
                    <td><%= caseInfo.getTitle() %></td>
                    <td><%= caseInfo.getDescription() %></td>
                    <td><%= caseInfo.getDateOpened() %></td>
                    <td><%= caseInfo.getDateClosed() %></td>
                    <td>
                        <a href="<%= request.getContextPath() %>/caseinfo/edit?caseID=<%= caseInfo.getCaseID() %>">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="<%= request.getContextPath() %>/caseinfo/delete?caseID=<%= caseInfo.getCaseID() %>">Delete</a>
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
