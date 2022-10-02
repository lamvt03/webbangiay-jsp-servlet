<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shop</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	width: 100%;
	max-height: 100vh;
}

.wrapper {
	width: 400px;
	margin: 100px auto;
	background-color: #ccc;
	padding: 32px 16px;
	border-radius: 10px;
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.7.1/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<div class="wrapper">

	<!-- sign up form  -->
	<form action="${pageContext.request.contextPath}/sign-up" method="post" id="sign-up">
		<div class="h3 text-center">Sign up</div>

		<input name="username" class="form-control" type="text"
			placeholder="Username" required value="${enteredUsername}"> <input name="password"
			type="password" class="form-control" placeholder="Password" required>
		<input name="repeat-password" type="password" class="form-control"
			placeholder="Repeat password" required> <br>
			
		<p style="color: red">${msg }</p>
			
		<button type="submit" class="btn btn-block btn-primary">
			<i class="fas fa-user-plus"></i> Sign up
		</button>
		<a href="${pageContext.request.contextPath}/sign-in" id="back-btn" class="text-decoration-none"><i class="fas fa-angle-left"></i> Back</a>
	</form>
	<!-- sign up form  -->

</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>

</body>

</html>