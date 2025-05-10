<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Object lawEnforcementPersonnelObj = request.getAttribute("LawEnforcementPersonnel");
    boolean editing = lawEnforcementPersonnelObj != null;
    src.model.LawEnforcementPersonnel lawEnforcementPersonnel = null;
    if (editing) {
        lawEnforcementPersonnel = (src.model.LawEnforcementPersonnel) lawEnforcementPersonnelObj;
    }
%>
<html>
<head>
    <title><%= editing ? "Edit Law Enforcement Personnel" : "Add New Law Enforcement Personnel" %></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4"><%= editing ? "Edit Law Enforcement Personnel" : "Add New Law Enforcement Personnel" %></h2>
        <form action="<%= editing ? "update" : "insert" %>" method="post">
            <div class="form-group">
                <label for="personnelID">Personnel ID</label>
                <input type="number" class="form-control" id="personnelID" name="personnelID"
                       value="<%= editing ? lawEnforcementPersonnel.getPersonnelID() : "" %>"
                       <%= editing ? "readonly" : "" %> required>
            </div>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name"
                       value="<%= editing ? lawEnforcementPersonnel.getName() : "" %>" required>
                   </div>
                   <div class="form-group">
                       <label for="role">Role</label>
                       <input type="text" class="form-control" id="role" name="role"
                              value="<%= editing ? lawEnforcementPersonnel.getRole() : "" %>" required>
                   </div>
                   <button type="submit" class="btn btn-primary"><%= editing ? "Update" : "Submit" %></button>
                   <a href="list" class="btn btn-secondary ml-2">Cancel</a>
        </form>
    </div>
</body>
</html>