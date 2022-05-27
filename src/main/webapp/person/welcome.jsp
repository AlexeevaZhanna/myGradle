<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<%
String name = request.getParameter("uname");
out.print("Добро пожаловать, "+name+"!");
%>