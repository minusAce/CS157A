<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Case Evidence List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Case Evidence List</h1>
        <a href="register" class="btn btn-primary mb-3">Register New Case Evidence</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Case ID</th>
                    <th>Evidence ID</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="caseEvidence" items="${listCaseEvidence}">
                    <tr>
                        <td>${caseEvidence.caseID}</td>
                        <td>${caseEvidence.evidenceID}</td>
                        <td>
                            <a href="edit?caseID=${caseEvidence.caseID}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="delete?caseID=${caseEvidence.caseID}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>