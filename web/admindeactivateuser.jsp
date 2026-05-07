<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="css/deactivateuser.css" rel="stylesheet" type="text/css">

</head>
	
<%
   String username= (String)session.getAttribute("username");
   if(username==null)
   {
       response.sendRedirect("adminhome.jsp?error=login before proceed");
   }
    %>
<body>
	<h3>Deactivate User</h3>
        <style>
    h6
    {
        color:red;
        font-weight: bold;
        font-size:20px;
        text-align: center;
    }
</style>

<%
String error=request.getParameter("status");
if(error!=null)
{
    out.println("<h6>");
    out.println(error);
    out.println("</h6>");
}
    %>
	<div id="admindeactivate">
		<form action="deactivateuser">
		<label>Enter E-mail:</label><input type="text"name="email">
		
		<select name="usertype">
			<option value="">select user</option>
			<option value="seller">seller</option>
			<option value="Buyer">Buyer</option>
			<option value="Delivery boy">Delivery Boy</option>
		</select><br><br>
	<input type="submit"name="Deactivate" value="deactivate"></div>
		</form><p>Note:Deactivating account means not deleting an account. Records remains in a database</p>
</body>
</html>