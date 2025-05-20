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

        .signin {
            position: absolute;
            top: 10px;
            right: 10px;
        }
    </style>
</head>
<body>
<a href="admin/panel.jsp" class="signin">sing in</a>

<p>Exchange rate for today</p>
<table border="1">
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

        request.setAttribute("currencies", currencies);

        for (int i = 0; i < currencies.size(); i++) {
            if (Objects.equals(writeCurrencies.get(i).getDate(), LocalDate.now())) {
    %>
    <tr>
        <td><%= writeCurrencies.get(i).getName()%></td>
        <td><%= writeCurrencies.get(i).getPrice()%></td>
        <td>
            <form action="controller" method="get">
                <input type="hidden" name="command" value="showCurrency">
                <input type="hidden" name="id" value="<%= writeCurrencies.get(i).getId()%>">
                <input type="submit" value="more">
            </form>
        </td>
    </tr>
    <%
            }
        }%>
    </tbody>
</table>
</body>
</html>



