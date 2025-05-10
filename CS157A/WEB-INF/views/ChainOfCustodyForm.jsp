<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Retrieve the chainOfCustody object from the request
    Object chainOfCustodyObj = request.getAttribute("ChainOfCustody");
    boolean editing = chainOfCustodyObj != null;
    src.model.ChainOfCustody chainOfCustody = null;
    if (editing) {
        chainOfCustody = (src.model.ChainOfCustody) chainOfCustodyObj;
    }
%>
<html>
<head>
    <title><%= editing ? "Edit Chain of Custody" : "Add New Chain of Custody" %></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4"><%= editing ? "Edit Chain of Custody" : "Add New Chain of Custody" %></h2>
        <form action="<%= editing ? "update" : "insert" %>" method="post">
            <div class="form-group">
                <label for="personnelID">Personnel ID</label>
                <input type="number" class="form-control" id="personnelID" name="personnelID"
                    value="<%= editing ? chainOfCustody.getPersonnelID() : "" %>"
                    <%= editing ? "readonly" : "" %> required>
            </div>
            <div class="form-group">
                <label for="evidenceID">Evidence ID</label>
                <input type="number" class="form-control" id="evidenceID" name="evidenceID"
                    value="<%= editing ? chainOfCustody.getEvidenceID() : "" %>" required>
            </div>
            <div class="form-group">
                <label for="dateLogged">Date Logged</label>
                <input type="datetime-local" class="form-control" id="dateLogged" name="dateLogged"
                    value="<%= editing ? chainOfCustody.getDateLogged() : "" %>" required>
            </div>
            <button type="submit" class="btn btn-primary"><%= editing ? "Update" : "Submit" %></button>
            <a href="list" class="btn btn-secondary ml-2">Cancel</a>
        </form>
    </div>
</body>
</html>
