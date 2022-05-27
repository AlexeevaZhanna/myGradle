<%!
int square(int n){
 return n * n;
}
%>
<%
      String[] users = new String[]{"Петя", "Вася", "Олег"};
      String myHeader = "Список пользователей";
      %>
<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title><%= myHeader %></title>
</head>
<body>
<p> <%= myHeader %></p>

<ul>
<%
for (int i=0; i<100; i++) {
out.println("<li> Square for " + i + " = " + square(i) + "</li>");
}
%>
 </ul>
<ul>
<%
for(String user: users) {
out.println("<li>" + user + "</li>");
 }

%>
 </ul>
<p>Сегодня <%=new java.util.Date()%></p>

</body>
</html>