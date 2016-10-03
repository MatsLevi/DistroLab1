<%@ page import="dist1.ui.BasketServlet" %>
<%@ page import="dist1.ui.ItemView" %>
<%@ page import="dist1.ui.TokenView" %><%--
  User: mats, gunnlaugur
  Date: 10/2/16
  Time: 3:17 PM
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your basket</title>

    <h2>Items currently in your basket:</h2>

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

    <%
        TokenView tok = (TokenView) session.getAttribute("Token");
    %>
    <% 
        ItemView[] items = BasketServlet.getItems(tok);
    %>

    <form method="post" action="${pageContext.request.contextPath}/basketservlet">

        <table>

            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
                <th>Delete Box</th>
            </tr>

            <%
                for(int i = 0; i < items.length;i++){
                    out.write("<tr>");
                    out.write("<td>");out.write(items[i].getName());out.write("</td>");
                    out.write("<td>");out.write(items[i].getType());out.write("</td>");
                    out.write("<td>");out.write(Integer.toString(items[i].getPrice()));out.write("</td>");
                    out.write("<td>");out.write("<input type= checkbox name= \"");out.write(Integer.toString(i));
                    out.write("\" value= ");out.write(Integer.toString(items[i].getId()));out.write(">");out.write("</td>");
                    out.write("</tr>");
                }
            %>
        </table>

        Delete items:<br>

        <%
            session.setAttribute("basketArraySize", items.length);
        %>

        <input type="submit" name="button" value="Delete">

    </form>

    <form method="post" action="${pageContext.request.contextPath}/basketservlet">

        Return to store:<br>

        <input type="submit" name="button2" value="Return">

    </form>
</body>
</html>
