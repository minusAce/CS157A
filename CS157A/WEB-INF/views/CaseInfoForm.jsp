<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Retrieve the caseInfo object from the request
    Object caseInfoObj = request.getAttribute("CaseInfo");
    boolean editing = caseInfoObj != null;
    src.model.CaseInfo caseInfo = null;
    if (editing) {
        caseInfo = (src.model.CaseInfo) caseInfoObj;
    }
%>
<html>
<head>
    <title><%= editing ? "Edit Case Info" : "Add New Case Info" %></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4"><%= editing ? "Edit Case Info" : "Add New Case Info" %></h2>
        <form action="<%= editing ? "update" : "insert" %>" method="post">
            <div class="form-group">
                <label for="caseID">Case ID</label>
                <input type="number" class="form-control" id="caseID" name="caseID"
                    value="<%= editing ? caseInfo.getCaseID() : "" %>"
                    <%= editing ? "readonly" : "" %> required>
            </div>
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title"
                    value="<%= editing ? caseInfo.getTitle() : "" %>" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" required><%= editing ? caseInfo.getDescription() : "" %></textarea>
            </div>
            <div class="form-group">
                <label for="dateOpened">Date Opened</label>
                <input type="date" class="form-control" id="dateOpened" name="dateOpened"
                    value="<%= editing ? caseInfo.getDateOpened() : "" %>" required>
            </div>
            <div class="form-group">
                <label for="dateClosed">Date Closed</label>
                <input type="date" class="form-control" id="dateClosed" name="dateClosed"
                    value="<%= editing ? caseInfo.getDateClosed() : "" %>">
            </div>
            <button type="submit" class="btn btn-primary"><%= editing ? "Update" : "Submit" %></button>
            <a href="list" class="btn btn-secondary ml-2">Cancel</a>
        </form>
    </div>
</body>
</html>
