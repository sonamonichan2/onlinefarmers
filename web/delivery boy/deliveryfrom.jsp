<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<html>
    <head>
		
<script type="text/javascript" src="selectitem.js"></script>
        <meta charset="utf-8">
        <title>Untitled Document</title>
       <style>
           
           .button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 10px 22px;
  text-align: center;

  text-decoration: none;
  display: inline-block;
  font-size: 16px;
 
  cursor: pointer;

}
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #333;
            }

            li {
                float: left;
            }
            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover:not(.active) {
                background-color: #111;
            }

            .active {
                background-color: #4CAF50;
            }
			#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th 
		   {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}
#customers tr:nth-child(odd){background-color: white;}
#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
        table {
    margin-top: -13px;
    margin-bottom: 10px;
    padding-right: 2px;
    padding-left: 2px;
}
       h3 {
    color: #26A41C;
    font-family: "Gill Sans", "Gill Sans MT", "Myriad Pro", "DejaVu Sans Condensed", Helvetica, Arial, sans-serif;
    font-weight: bolder;
    text-align: left;
}
		   #addItem{
    display: inline-block;
}
       #post {
    margin-top: 4px;
    color: #14AA0A;
    font-family: Cambria, "Hoefler Text", "Liberation Serif", Times, "Times New Roman", serif;
    font-weight: bold;
    text-align: left;
}
       #addItem fieldset {
    margin-left: 349px;
    color: #AF3918;
    margin-top: 10px;
    margin-bottom: 6px;
}
       #delete {
    float: right;
    margin-top: 6px;
}
       </style>
    </head>
	

	
    <body>
		
	<header>
		<ul>
            <li><a href="#home">Home</a></li>
            <li><a href="#Go to cart " class="active">Dashboard</a></li>
            <li><a href="#contact" >Contact</a></li>
            <li style="float:right"><a href="../logout">Logout</a></li>
        </ul>

<meta charset="utf-8">
<title>Seller dashboard</title>
		</header>

	<h3>Collect from sellers</h3>
    <table id="customers">
  <tr>
    <th>Name</th>
    <th>Address</th>
    <th>pincode</th>
	<th>phone number</th>
	  <th>amount</th>
	  
  </tr>
<%

    String fromemail=request.getParameter("fromemail");
    String toemail=request.getParameter("toemail");
    int itemid=Integer.parseInt(request.getParameter("itemid"));
   
  String url = "jdbc:oracle:thin:@localhost:1521:xe";
 
  String driver = "oracle.jdbc.driver.OracleDriver";
  String userName = "sathish"; 
  String password = "sathish";

  
  
  try
  {
    Class.forName("oracle.jdbc.driver.OracleDriver");

  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",userName,password);
  String strQuery="select * from registeruser where email='"+fromemail+"'";
 Statement st = conn.createStatement();
 ResultSet rs = st.executeQuery(strQuery);
 String strQuery3="select sum(totalprice) from productbuyer where selleremail='"+fromemail+"'and iscart=0";
 String strQuery4="select sum(totalprice) from productbuyer where selleremail='"+toemail+"'and iscart=0";
 while(rs.next())
 {
     out.println("<tr>");
     out.println("<td>"+rs.getString(1)+"</td>");
     out.println("<td>"+rs.getString(7)+"</td>");
     out.println("<td>"+rs.getString(8)+"</td>");
     out.println("<td>"+rs.getInt(5)+"</td>");
     rs=st.executeQuery(strQuery3);
      while(rs.next())
  {
      out.println("<td>"+rs.getInt(1)+"</td>");
      
  }
     out.println("</tr>");
     out.println("</table>");
     
out.println("<a href='pickup'><button class='button button2'>pickup order</button></a>");
 }

String strQuery2="select * from registeruserbuyer where email='"+toemail+"'";

	out.println("<h3>Deliver to customers</h3>");
   out.println("<table id='customers'>");
  out.println("<tr>");
  out.println("<th>Name</th>");
    out.println("<th>Address</th>");
    out.println("<th>pincode</th>");
	out.println("<th>phone number</th>");
        out.println("<th>total amount</th>");
	 
  out.println("</tr>");
rs = st.executeQuery(strQuery2);

  while(rs.next())
 {
     out.println("<tr>");
     out.println("<td>"+rs.getString(1)+"</td>");
     out.println("<td>"+rs.getString(7)+"</td>");
     out.println("<td>"+rs.getString(8)+"</td>");
     out.println("<td>"+rs.getInt(5)+"</td>");
     rs=st.executeQuery(strQuery4);
      while(rs.next())
  {
      out.println("<td>"+rs.getInt(1)+"</td>");
      
  }
     out.println("</tr>");
     
      }
  out.println("</table>");
} 

catch(Exception e)
{
    out.println(e);
        }
out.println("<a href='delivered'><button class='button'>Delivered</button></a>");
%>