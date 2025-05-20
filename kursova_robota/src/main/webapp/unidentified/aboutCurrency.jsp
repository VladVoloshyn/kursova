<%@ page import="org.example.kursova_robota.model.Currency" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    Integer id = Integer.valueOf(request.getParameter("id"));
    Currency currency = (Currency) request.getAttribute("currency");
    Collection currencies = (Collection) request.getAttribute("currencies");
    ArrayList<Currency> currencyArrayList = new ArrayList<>(currencies);


    String nameCurrency = currency.getName();

    List<Currency> currenciesFilteredByName = currencyArrayList.stream()
            .filter(c -> c.getName().equals(nameCurrency))
            .sorted(Comparator.comparing(Currency::getDate))
            .toList();

    LocalDate from;
    LocalDate to;

    if (request.getParameter("from") == null) {
        from = currenciesFilteredByName.get(0).getDate();
    } else {
        from = LocalDate.parse(request.getParameter("from"));
    }
    if (request.getParameter("to") == null) {
        to = currenciesFilteredByName.get(currenciesFilteredByName.size()-1).getDate();
    } else {
        to = LocalDate.parse(request.getParameter("to"));
    }

    List<Currency> currenciesFilteredByDate = currenciesFilteredByName.stream()
            .filter(c -> c.getDate().isAfter(from))
            .filter(c -> c.getDate().isBefore(to))
            .toList();
    ArrayList<Currency> writeCurrencies = new ArrayList<>(currenciesFilteredByDate);
    Collections.reverse(writeCurrencies);

%>
<head>
    <title><%=nameCurrency%></title>
    <style>
        body {
            text-align: center;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        table {
            margin: 0 auto;
        }

        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<form action="controller" method="get">
    <input type="hidden" name="command" value="showCurrency">
    <input type="hidden" name="id" value="<%=id%>">
    From: <br> <input type="text" name="from" value="<%=from%>"> <br>
    To: <br> <input type="text" name="to" value="<%=to%>"> <br>
    <input type="submit" value="show">
</form>
<table border="1">
    <thead>
    <tr>
        <th>Price</th>
        <th>Date</th>
    </tr>
    </thead>
    <%
        for (int i = 0; i < writeCurrencies.size(); i++) {
    %>
    <tbody>
    <th><%=writeCurrencies.get(i).getPrice()%></th>
    <th><%=writeCurrencies.get(i).getDate()%></th>
    </tbody>
    <%
        };
    %>
</table>
</body>
</html>



