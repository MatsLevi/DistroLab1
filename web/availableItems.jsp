<%@ page import="dist1.ui.ItemServlet" %>
<%@ page import="dist1.ui.ItemView" %>
<%@ page import="dist1.ui.TokenView" %><%--
  User: mats, gunnlaugur
  Date: 10/2/16
  Time: 1:29 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%TokenView tok = (TokenView) session.getAttribute("Token");%>
    <%System.out.println("Token check: " +tok.getId());%>
    <% ItemView[] items = ItemServlet.getItems(tok);%>
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

        <%for(int i = 0; i < items.length;i++){
            out.write("<tr>");
            out.write("<td>");out.write(items[i].getName());out.write("</td>");
            out.write("<td>");out.write(items[i].getType());out.write("</td>");
            out.write("<td>");out.write(Integer.toString(items[i].getPrice()));out.write("</td>");
            out.write("<td>");out.write(Integer.toString(items[i].getQuantity()));out.write("</td>");
            out.write("<td>");out.write("<input type= checkbox name= \"");out.write(Integer.toString(i));
            out.write("\" value= ");out.write(Integer.toString(items[i].getId()));out.write(">");out.write("</td>");
            out.write("</tr>");

        }
        %>
    </table>

        <%
        session.setAttribute("arraySize", items.length);
         %>
        <input type="submit" name="button1" value="Add">

    </form>

</body>
</html>
