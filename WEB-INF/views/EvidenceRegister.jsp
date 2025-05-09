<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Evidence Register</title>
  </head>

  <body>
    <div align="center">
      <h1>Case Info Register Form</h1>
      <form action="<%= request.getContextPath() %>/logEvidence" method="post">
        <table>
          <tr>
            <td>Evidence ID</td>
            <td><input type="number" name="evidenceID" /></td>
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
            <td>Evidence Type</td>
            <td><input type="text" name="evidenceType" /></td>
          </tr>
          <tr>
            <td>Date Collected</td>
            <td><input type="date" name="dateCollected" /></td>
          </tr>
          <tr>
            <td>Evidence Image</td>
            <td><input type="text" name="evidenceImage" /></td>
          </tr>
        </table>
        <input type="submit" value="Submit" />
      </form>
    </div>
  </body>
</html>
