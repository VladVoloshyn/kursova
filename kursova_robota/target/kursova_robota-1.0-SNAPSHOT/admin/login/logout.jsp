<%@ page session="true" %>
<%
    session.invalidate(); // завершення сесії
    response.sendRedirect(request.getContextPath() + "/admin/panel.jsp"); // редірект на панель
%>
