<%--
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
            System.out.println("Item ID: " +request.getParameter(Integer.toString(i)));
            if(request.getParameter(Integer.toString(i)) != null){
                calk++;
            }
        }

        int [] getItems = new int[calk];
        int check = 0;

        for(int i = 0; i < size; i++){
            System.out.println("Item ID: " +request.getParameter(Integer.toString(i)));
            if(request.getParameter(Integer.toString(i)) != null){
                getItems[check] = Integer.parseInt(request.getParameter(Integer.toString(i)));
            }
        }


    %>

<table>



</table>

</body>
</html>
