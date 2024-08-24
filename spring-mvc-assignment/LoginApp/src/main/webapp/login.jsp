<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h2>Sign In</h2>
<form action="signIn" method="post">
<label>EmailId</label>
<input type="email" name="emailid"/><br/>
<label>Password</label>
<input type="password" name="password"/><br/>
<label>Type of User</label>
Admin<input type="radio" name="typeofuser" id="admin" value="admin"/>
Customer<input type="radio" name="typeofuser" id="customer" value="customer"/><br/>
<input type="submit" value="SignIn"/>
<input type="reset" value="reset"/>
</form>
</body>
</html>