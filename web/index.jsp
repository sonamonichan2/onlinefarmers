<!DOCTYPE html>
<html>
<head>
<link href="css/indexes.css" rel="stylesheet" type="text/css">
</head>
<body>
<nav>
<ul>
  <li><a class="active" href="#home">Kuviyal</a></li>
  <li><a href="#news">Sell</a></li>
  <li><a href="#contact">Shop</a></li>
  <li><a href="#about" class="lastnav">Contact-us &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
 
</ul>
	</nav>
	<aside>

		<button class="open-button-Register" onclick="openFormRegister()">Register</button>
<div class="form-popup-Register" id="myFormRegister">
  <form class="form-container-Register">
    <h1>Register</h1>
	  <center><a href="signup.html"><button class="button" type="button">Seller</button></a> 
		  <a href="signupbuyer.html"><button class="button" type="button">Buyer</button></a>
		  <a href="signupdelivery.html"><button class="button" type="button">Delivery Agent</button></center></a>
    <button type="button" class="btn cancel" onclick="closeFormRegister()">Close</button>
  </form>
</div>

<script>
function openFormRegister() {
  document.getElementById("myFormRegister").style.display = "block";
}

function closeFormRegister() {
  document.getElementById("myFormRegister").style.display = "none";
}
</script>
		
		
		
		
<button class="open-button" onclick="openForm()">Login</button>
<div class="form-popup" id="myForm">
  <form class="form-container">
    <h1>Login</h1>
	  <center><a href="logn.jsp"><button class="button" type="button">Seller</button></a>
		  <a href="lognbuyer.jsp"><button class="button" type="button">Buyer</button></a>
		  <a href="logindelivery.html"><button class="button" type="button">Delivery Agent</button></a></center>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
</aside>
	<div id="zero">
		<h1>Order Vegetables Online</h1>
		<h3>Best vegetables, fruits and more at your door step</h3>
	</div>
	<div id="zerosub"><p><center>How E-farming works</center><br>
		<center>Ordering vegetables and fruits online has never been this easy</center></p>
	</div>
	<div class="row">
<div class="column"> <center> <img src="order.png" width="50%" height="50%" alt="image"> <br><p>Register and explore vegetables,fruits and pulses</p></center> <br></div>
<div class="column"><img src="harvesting.jpg" width="50%" height="70%" alt="reload"><p>Let farmer in your city picks your order</p></div>
	
	<div class="column"><img src="delivery.png" width="50%" height="70%" alt="reload"><p>Our delivery agent will bring you on next day</p></div>
	</div>
<footer id="footer"><li><a href="#news">Sell</a></li>
  <li><a href="#contact">Shop</a></li></footer>
</body>
</html>
