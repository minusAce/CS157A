<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Retrieve the caseEvidence object from the request
    Object caseEvidenceObj = request.getAttribute("CaseEvidence");
    boolean editing = caseEvidenceObj != null;
    src.model.CaseEvidence caseEvidence = null;
    if (editing) {
        caseEvidence = (src.model.CaseEvidence) caseEvidenceObj;
    }
%>
<html>
<head>
    <title><%= editing ? "Edit Case Evidence" : "Add New Case Evidence" %></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4"><%= editing ? "Edit Case Evidence" : "Add New Case Evidence" %></h2>
        <form action="<%= editing ? "update" : "insert" %>" method="post">
            <div class="form-group">
                <label for="caseID">Case ID</label>
                <input type="number" class="form-control" id="caseID" name="caseID"
                    value="<%= editing ? caseEvidence.getCaseID() : "" %>"
                    <%= editing ? "readonly" : "" %> required>
            </div>
            <div class="form-group">
                <label for="evidenceID">Evidence ID</label>
                <input type="number" class="form-control" id="evidenceID" name="evidenceID"
                    value="<%= editing ? caseEvidence.getEvidenceID() : "" %>" required>
            </div>
            <button type="submit" class="btn btn-primary"><%= editing ? "Update" : "Submit" %></button>
            <a href="list" class="btn btn-secondary ml-2">Cancel</a>
        </form>
    </div>
</body>
</html>