<%@ page import="java.util.Collection" %>
<%@ page import="org.example.kursova_robota.model.Currency" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange Rates</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            flex-direction: column;
        }
        table {
            margin: auto;
            border-collapse: collapse;
            width: 30%;
        }
        td, th {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<p>Welcome, Mr <%=request.getRemoteUser()%></p>
<form action="<%= request.getContextPath() %>/admin/login/logout.jsp" method="post">
    <button type="submit">Log out</button>
</form>
<p>Create Currency Panel</p>
<form action="controller" method="post">
    <input type="hidden" name="command" value="create">
    Currency: <br> <input type="text" name="currencyName" value=""> <br>
    Price: <br> <input type="text" name="currencyPrice" value=""> <br>
    Date: <br> <input type="text" name="currencyDate" value="<%= LocalDate.now()%>">
    <input type="submit" value="create">
</form>
<br>
<p>Exchange rate for today</p>
<table>
    <thead>
    <tr>
        <th>Currency</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <%
        Collection currencies = (Collection) request.getAttribute("currencies");
        ArrayList<Currency> writeCurrencies = new ArrayList<>(currencies);

        for (int i = 0; i < currencies.size(); i++) {
            if (Objects.equals(writeCurrencies.get(i).getDate(), LocalDate.now())) {
    %>
    <tr>
        <td><%= writeCurrencies.get(i).getName()%></td>
        <td><%= writeCurrencies.get(i).getPrice()%></td>
        <td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="delete">
                <input name="id" type="hidden" value="<%= writeCurrencies.get(i).getId()%>">
                <input type="submit" value="delete">
            </form>
        </td>
        <td>
            <form action="controller" method="get">
                <input type="hidden" name="command" value="edit">
                <input type="hidden" name="id" value="<%= writeCurrencies.get(i).getId()%>">
                <input type="submit" value="edit">
            </form>
        </td>
    </tr>
    <%
            }
        }%>
    </tbody>
</table>
<br> <hr> <br>

<p>All Currencies in DB</p>
<table border="1">
    <thead>
    <tr>
        <th>Currency</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (int i = 0; i < currencies.size(); i++) {
    %>
    <tr>
        <td><%= writeCurrencies.get(i).getName()%></td>
        <td><%= writeCurrencies.get(i).getPrice()%></td>
        <td>
            <form action="controller" method="post">
                <input type="hidden" name="command" value="delete">
                <input name="id" type="hidden" value="<%= writeCurrencies.get(i).getId()%>">
                <input type="submit" value="delete">
            </form>
        </td>
        <td>
            <form action="controller" method="get">
                <input type="hidden" name="command" value="edit">
                <input type="hidden" name="id" value="<%= writeCurrencies.get(i).getId()%>">
                <input type="submit" value="edit">
            </form>
        </td>
    </tr>
    <%
        }%>
    </tbody>
</table>
</body>
</html>



