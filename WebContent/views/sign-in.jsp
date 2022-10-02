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

	<!-- sign in form  -->
	<form action="${pageContext.request.contextPath}/sign-in" method="post"
		id="sign-in">
		<div class="h3 text-center mb-3">Sign in</div>

		<input name="username" type="text" placeholder="Enter username"
			class="form-control"> <input name="password" type="password"
			placeholder="Enter password" class="form-control">

		<div class="form-check form-group">
			<input type="checkbox" name="rememberMe" id="checkbox"
				class="form-check-input"> <label class="form-check-label"
				for="checkbox">Remember me</label>
		</div>
		
		<p style="color: red">${msg}</p>
		
		<button type="submit" class="mt-2 btn btn-block btn-success">
			<i class="fas fa-sign-in-alt"></i> Sign in
		</button>
		<hr>
		<a href="${pageContext.request.contextPath }/sign-up" class="btn btn-block btn-primary"
			id="signup-btn">
			<i class="fas fa-user-plus"></i> Sign up
		</a>
	</form>
	<!-- sign in form  -->

</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
</body>

</html>