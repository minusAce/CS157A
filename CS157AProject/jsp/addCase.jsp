<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Add Case</title></head>
<body>
    <h2>Add Case</h2>
    <form method="post" action="/CS157AProject/addCase">
        Title: <input name="title" required><br>
        Description: <input name="description" required><br>
        Date Opened: <input type="date" name="opened" required><br>
        Date Closed: <input type="date" name="closed" required><br>
        <input type="submit" value="Add Case">
    </form>
</body>
</html>
