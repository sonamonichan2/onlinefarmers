<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<!doctype html>
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
  margin-left: 200px;
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

	
	
	
	
	<div id="dashboard">
		<p>Delivering location set according to your home address</p>
		<h3>Deliveries</h3>
<table id="customers">
  <tr>
    <th>Date</th>
    <th><a>Delivering From<a></th>
    <th>Delivering to</th>
	<th>Payment</th>
	  <th>status</th>
	  
  </tr>
  <%
                 String url = "jdbc:oracle:thin:@localhost:1521:xe";
 
  String driver = "oracle.jdbc.driver.OracleDriver";
  String userName = "sathish"; 
  String password = "sathish";
try
{
   Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",userName,password);
 String username =(String)session.getAttribute("email");
 String strQuery="select * from productbuyer where iscart=0";
 System.out.println(strQuery);
 Statement st = conn.createStatement();
 ResultSet rs = st.executeQuery(strQuery);

 while(rs.next())
      {
    int itemid=rs.getInt(1);
    String fromemail=rs.getString(8);
    String toemail=rs.getString(2);
   
   
     out.println("<tr onclick='window.location='hi.html''>");

    out.println("<td>"+itemid+"</td>");
    out.println("<td>"+fromemail+"</td>");
    out.println("<td>"+toemail+"</td>");
    out.println ("<td>"+rs.getInt(5)+"</td>");
     out.println("<td> yet to be deliverd");
      out.println("<a href='deliveryfrom?fromemail="+fromemail+"&toemail="+toemail+"&itemid="+itemid+"'>");
      out.println("<input type='button' class='button' value='details'/>");
      out.println("</a>");  
            //   out.println("<a href='../picked?itemid="+itemid+"' > <img id='pick' src='pickeup.jpg' width='40px' height='40px'></a><a href='../delivered?itemid="+itemid+"' > <img id='delivered' src='tick.jpg' width='40px' height='40px'></a></td></tr>");
      }
    }     
catch(Exception e)
{
    out.println(e);
}
 %>
 
</table>
	</div>
        <div>
         
        </div>
	</body>
	</html>