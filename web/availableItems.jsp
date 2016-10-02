<%--
  User: mats, gunnlaugur
  Date: 10/2/16
  Time: 1:29 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of items</title>

    <h2>Available items for sale:</h2>

    <br><br>

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 60%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #ddcccc;
        }
    </style>
</head>
<body>

    <form method="post" action="${pageContext.request.contextPath}/itemservlet">

    <table>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Price</th>
            <th>quantity</th>
            <th>Add to cart</th>
        </tr>
        <tr>
            <td>Kyckling</td>
            <td>Mat</td>
            <td>25</td>
            <td>5</td>
            <td><input type="checkbox" name="Mat" value="Kyckling"></td>
        </tr>
        <tr>
            <td>Oliver</td>
            <td>Mat</td>
            <td>5555</td>
            <td>55</td>
            <td><input type="checkbox" name="Mat" value="Oliver"></td>
        </tr>
    </table>

        <input type="submit" name="button1" value="Add">

    </form>

</body>
</html>
