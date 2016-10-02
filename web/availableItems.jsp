<%@ page import="dist1.ui.ItemServlet" %>
<%@ page import="dist1.ui.ItemView" %><%--
  User: mats, gunnlaugur
  Date: 10/2/16
  Time: 1:29 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%! ItemView[] items = ItemServlet.getItems();%>
    <%System.out.println("Item 1: " +items[0] +" Item 3: " +items[3]);%>

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
            <td><input type="checkbox" name="Kyckling" value="Kyckling"></td>
        </tr>
        <tr>
            <td>Oliver</td>
            <td>Mat</td>
            <td>5555</td>
            <td>55</td>
            <td><input type="checkbox" name="Oliver" value="Oliver"></td>
        </tr>
    </table>

        <input type="submit" name="button1" value="Add">

    </form>

</body>
</html>
