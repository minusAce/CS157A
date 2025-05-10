<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Retrieve the evidence object from the request
    Object evidenceObj = request.getAttribute("Evidence");
    boolean editing = evidenceObj != null;
    src.model.Evidence evidence = null;
    if (editing) {
        evidence = (src.model.Evidence) evidenceObj;
    }
%>
<html>
<head>
    <title><%= editing ? "Edit Evidence" : "Add New Evidence" %></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4"><%= editing ? "Edit Evidence" : "Add New Evidence" %></h2>
        <form action="<%= editing ? "update" : "insert" %>" method="post">
            <div class="form-group">
                <label for="evidenceID">Evidence ID</label>
                <input type="number" class="form-control" id="evidenceID" name="evidenceID"
                       value="<%= editing ? evidence.getEvidenceID() : "" %>"
                       <%= editing ? "readonly" : "" %> required>
            </div>
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" name="title"
                       value="<%= editing ? evidence.getTitle() : "" %>" required>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" name="description" required><%= editing ? evidence.getDescription() : "" %></textarea>
            </div>
            <div class="form-group">
                <label for="evidenceType">Evidence Type</label>
                <input type="text" class="form-control" id="evidenceType" name="evidenceType"
                       value="<%= editing ? evidence.getEvidenceType() : "" %>" required>
            </div>
            <div class="form-group">
                <label for="dateCollected">Date Collected</label>
                <input type="date" class="form-control" id="dateCollected" name="dateCollected"
                       value="<%= editing ? evidence.getDateCollected() : "" %>" required>
            </div>
            <button type="submit" class="btn btn-primary"><%= editing ? "Update" : "Submit" %></button>
            <a href="list" class="btn btn-secondary ml-2">Cancel</a>
        </form>
    </div>
</body>
</html>