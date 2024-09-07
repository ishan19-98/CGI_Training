<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Here</title>
</head>
<body>
<h2>Sign Up</h2>
<form action="signUp" method="get">
<label>EmailId</label>
<input type="email" name="emailid"/><br/>
<label>Password</label>
<input type="password" name="password"/><br/>
<label>Type of User</label>
Admin<input type="radio" name="typeofuser" id="admin" value="admin"/>
Customer<input type="radio" name="typeofuser" id="customer" value="customer"/><br/>
<input type="submit" value="SignUp"/>
<input type="reset" value="reset"/>
</form>
</body>
</html>