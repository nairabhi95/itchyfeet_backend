<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>ItchyFeet</title>
<style>
h1{
	text-align: center;
}
#searchBody{
	 background: url("uiResources/images/DSC_1007.JPG");
    background-size: cover;
    background-repeat: no-repeat;
    padding-top: 40px;
}
#loginbtn{
	float:right;
}
#registerbtn{
	float:right;
	margin: 0px 50px 0px 30px;
}
#header{
	height: 100px;
}
#mySearch{
    height:60px; 
    width:50%;
    margin: -20px -50px; 
    position:relative;
    top:20%; 
    left:25%;
}
</style>

<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="uiResources/scripts/public/angular.min.js"></script>
<script src="uiResources/scripts/private/angular/controller/searchController.js"></script>

</head>
<body id="searchBody" ng-app="searchApp">
<div class="container" ng-controller="searchController">

<div id="header">
<input type="search" id="mySearch" placeholder="Search for something..">
<a id="registerbtn" href="/itchyfeet/user/register">Register</a>
<button id="loginbtn" ng-click="" class="btn btn-primary btn-lg pull-right">Login</button>
 <!-- <md-button class="md-primary md-raised edgePadding" ng-click="openOffscreen()">
        Open From Top Left - Close Slide Down
      </md-button> -->
</div>
<h1>Andaman and Nicobar Islands</h1>
<div id="register" style="display:none">
<label>First Name</label><input type="text" name="firstName" placeholder="First Name">
<label>Last Name</label><input type="text" name="lastName" placeholder="Last Name">
<label>Email Id</label><input type="text" name="emailId" placeholder="Email Id">
<label>Password</label><input type="text" name="password" placeholder="Password">
<label>Confirm Password</label><input type="text" name="confirmPassword" placeholder="Confirm Password">
<label>Contact Number</label><input type="text" name="contactNumber" placeholder="Contact Number">
</div>

<div id="login" style="display:none">
<label>Username</label><input type="text" name="username" placeholder="Username">
<label>Password</label><input type="text" name="password" placeholder="Password">
</div>


<div style="height:10%; position:absolute; bottom:0px;">
<a href="/itchyfeet/login">Latest Experiences</a> | <a href="/itchyfeet/login">About Us</a></div>
</div>
</body>
</html>