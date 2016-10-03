<%--
  User: Mats & Gunnlaugur
  Date: 9/29/16
  Time: 10:08 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <br><br>

    <h2>Login or register on the server</h2>

    <br><br>

    <p>Enter username and password to login or register</p>

    <form method="post" action="${pageContext.request.contextPath}/loginservlet">
        Username: <br>

        <input type="text" name="username"><br>

        Password:<br>

        <input type="password" name="password"><br>
        <%
        session.setAttribute("Token", tv);
        %>
        <input type="submit" name="button1" value="Login">

    </form>

    <form method="post" action="${pageContext.request.contextPath}/registerServlet">
        Username: <br>

        <input type="text" name="username"><br>

        Password:<br>

        <input type="password" name="password"><br>

        <input type="submit" name="button2" value="Register">

    </form>

</body>
</html>
