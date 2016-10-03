<%@ page import="dist1.ui.BasketServlet" %>
<%@ page import="dist1.ui.ItemView" %><%--
  User: mats, gunnlaugur
  Date: 10/2/16
  Time: 3:17 PM
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your basket</title>

    <h2>Items currently in your basket:</h2>

</head>
<body>

    <%
        int calk = 0;
        int size = (int)session.getAttribute("arraySize");
        System.out.println("array length in basket: " +size);

        for(int i = 0; i < size; i++){
            System.out.println("Item ID(first loop in basket): " +request.getParameter(Integer.toString(i)));
            if(request.getParameter(Integer.toString(i)) != null){
                calk++;
            }
        }

        int [] getItems = new int[calk-1];
        int check = 0;

        for(int i = 0; i < size; i++){
            System.out.println("Item ID(second): " +request.getParameter(Integer.toString(i)));
            if(request.getParameter(Integer.toString(i)) != null){
                getItems[check] = Integer.parseInt(request.getParameter(Integer.toString(i)));
                check++;
            }
        }

        for(int i = 0; i < calk; i++){System.out.println("intem check in basket:" +getItems[i]);}

        ItemView[] items = BasketServlet.getItems(getItems);
    %>

<table>

    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Price</th>
    </tr>


</table>

</body>
</html>
