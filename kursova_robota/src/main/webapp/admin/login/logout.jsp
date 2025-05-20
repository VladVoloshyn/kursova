<%@ page session="true" %>
<%
    session.invalidate();
    response.sendRedirect(request.getContextPath() + "/admin/panel.jsp");
%>
