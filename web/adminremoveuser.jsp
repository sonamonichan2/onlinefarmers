<%-- 
    Document   : removeuser
    Created on : 10 Dec, 2019, 7:29:43 PM
    Author     : sathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
   String username= (String)session.getAttribute("username");
   if(username==null)
   {
       response.sendRedirect("adminhome.jsp?error=login before proceed");
   }
    %>
    <body>
        <h1>Delete User</h1>
    </body>
</html>
