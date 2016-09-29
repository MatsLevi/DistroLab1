<%--
  Created by IntelliJ IDEA.
  User: mats
  Date: 9/29/16
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<%! dist1.bo.SecureFacade SF = new dist1.bo.SecureFacade(); %>

    <br><br>

    <h2>Login or register on the server</h2>

    <br><br>

    <p>Enter username and password to login or register</p>

    <form>
        Username: <br>

        <input type="text" name="username" value=""><br>

        Last name:<br>

        <input type="text" name="password" value=""><br>

        <input type="submit" value="Login">
        <input type="submit" value="Register">

    </form>

</body>
</html>
