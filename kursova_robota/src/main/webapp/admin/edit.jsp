<%@ page import="org.example.kursova_robota.model.Currency" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Currency</title>
</head>
<body>
(AM)
<form action="controller" method="post">
    <%Currency editCurrency = (Currency) request.getAttribute("editCurrency");%>
    <input type="hidden" name="id" value="<%=editCurrency.getId()%>">
    <input type="hidden" name="command" value="edit">
    Currency: <input type="text" name="nameEditCurrency" value="<%=editCurrency.getName()%>">
    Price: <input type="text" name="priceEditCurrency" value="<%=editCurrency.getPrice()%>">
    Date: <input type="text" name="dateEditCurrency" value="<%=editCurrency.getDate()%>">
    <input type="submit" value="edit">
</form>
</body>
</html>



