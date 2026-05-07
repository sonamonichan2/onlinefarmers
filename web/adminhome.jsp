<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Admin panel</title>
<link href="css/adminstyle.css" rel="stylesheet" type="text/css">
<link href="css/logn.css" rel="stylesheet" type="text/css" />
<style>
    body
    {
        background-image: url('adminback.jpg');
    }

    h6
    {
        color:red;
        font-weight: bold;
        font-size:20px;
        text-align: center;
     
        
    }
</style>


</head>

<body>
    <header><nav><ul><li>Home</li><li><a href='admindeliverycharge.jsp'> delivery charge</a></li><li><a href='adminremoveuser.jsp'>Remove User</a></li><li><a href="admindeactivateuser.jsp">Deactivate User</a></li><li><a href="admincreateuser.html">Create User</a></li><li>Reports</li></ul></nav>
	</header>
    <%
           String username= (String)session.getAttribute("username");
   if(username!=null)
   {
       response.sendRedirect("adminreport.jsp");
   }
String error=request.getParameter("error");
if(error!=null)
{
    out.println("<h6>");
    out.println(error);
    out.println("</h6>");
}


   
    %>
	 <div class="signin">

<form action="LoginAdmin">
<h2 style="color:#fff;">Log In-Admin panel</h2>
<input type="text" name="username" placeholder="Username"/><br /><br />
<input type="password" name="password" placeholder="Password" /><br /><br />
<input type="submit" value="Log In" /><br /><br />
<div id="container">
<a href="re.html" style=" margin-right:0px; font-size:13px; font-family:Tahoma, Geneva, sans-serif;">Reset password?</a>
    <a href="for.html" style=" margin-left:30px; font-size:13px; font-family:Tahoma, Geneva, sans-serif;">Forget password</a>
    </div><br /><br /><br /><br /><br /><br />


</form>
</div>

	</body>
</html>
