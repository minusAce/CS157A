<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Case Info Register</title>
</head>
<body>
 <div align="center">
  <h1>Case Info Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table>
    <tr>
     <td>Case ID</td>
     <td><input type="number" name="caseID" /></td>
    </tr>
    <tr>
     <td>Title</td>
     <td><input type="text" name="title" /></td>
    </tr>
    <tr>
     <td>Description</td>
     <td><input type="text" name="description" /></td>
    </tr>
    <tr>
     <td>Date Opened</td>
     <td><input type="date" name="dateOpened" /></td>
    </tr>
    <tr>
     <td>Date Closed</td>
     <td><input type="date" name="dateClosed" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>