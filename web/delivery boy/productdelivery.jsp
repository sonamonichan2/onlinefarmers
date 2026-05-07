<!doctype html>
<html>
<head>
<html>
    <head>
		

        <meta charset="utf-8">
        <title>Untitled Document</title>
       <style>
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
	
    <%!
        String status="none";
	%>
    <body>
		
	<header>
		<ul>
            <li><a href="#home">Home</a></li>
            <li><a href="#Go to cart " class="active">Dashboard</a></li>
            <li><a href="#contact">Contact</a></li>
            <li style="float:right"><a href="#about">Logout</a></li>
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
    <th>Delivering From</th>
    <th>Delivering to</th>
	<th>Payment</th>
	  <th>status</th>
	  
  </tr>
  <tr>
    <td>Alfreds Futterkiste</td>
    <td>Maria Anders</td>
    <td>Germany</td>
	  <td></td>
	  <td>alive <a href="deleteproduct"> <img id="delete" src="delete.png" width="10px" height="10px"></a></td>
  </tr>
  <tr>
    <td>21/12/2019</td>
    <td> <a href="#fromaddress?status=blockfrom">sathishdgl96@gmail.com</td></a>
    <td>sathishdgl98</td>
	  <td>123</td>
	  <td>yet to delivered</td>
  </tr>
  <tr>
    <td>Centro comercial Moctezuma</td>
    <td>Francisco Chang</td>
    <td>Mexico</td>
	  <td></td>
	  <td></td>
  </tr>
  <tr>
    <td>Ernst Handel</td>
    <td>Roland Mendel</td>
    <td>Austria</td>
	  <td></td>
	  <td></td>
  </tr>
  <tr>
    <td>Island Trading</td>
    <td>Helen Bennett</td>
    <td>UK</td>
	  <td></td>
	  <td></td>
  </tr>
  <tr>
    <td>Königlich Essen</td>
    <td>Philip Cramer</td>
    <td>Germany</td>
	  <td></td>
	  <td></td>
  </tr>
  <tr>
    <td>Laughing Bacchus Winecellars</td>
    <td>Yoshi Tannamuri</td>
    <td>Canada</td>
	  <td></td>
	  <td></td>
  </tr>
 
</table>
        </div><%! String showfrom="none";%>
        <%
            if(request.getParameter("status").equals("blockfrom"))
            {
                String showfrom="block";
            }
            %>
		<div id="fromaddress" style="display:block<%=showfrom%>">
                    <h2>from address</h2>

		</div>
        		<div id="toaddress">
		
                            <h1>   to address</h1>

		</div>
        		<div id="statuschange">
                            <h>status change</h>

		</div>
	</body>
	</html>