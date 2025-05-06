<%@ page import="java.util.List" %>
<%@ page import="model.Case" %>
<%
    List<Case> cases = (List<Case>) request.getAttribute("cases");
%>
<h2>Case List</h2>
<table border="1">
    <tr><th>ID</th><th>Title</th><th>Description</th><th>Date Opened</th><th>Date Closed</th></tr>
    <% for (Case c : cases) { %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getTitle() %></td>
            <td><%= c.getDescription() %></td>
            <td><%= c.getDateOpened() %></td>
            <td><%= c.getDateClosed() %></td>
        </tr>
    <% } %>
</table>