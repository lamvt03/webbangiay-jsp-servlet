<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shop</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.7.1/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>

<body>
	<div class="wrapper">
		<!-- 		header -->
		<jsp:include page="_header.jsp"></jsp:include>
		<!-- 		header -->

		<!-- container  -->
		<div class="container">
			<div class="row">

				<jsp:include page="_left-bar.jsp"></jsp:include>

				<!-- detail  -->
				<div class="col-sm-9">
					<div class="row">

						<div class="col-sm-5 card">
							<img
								src="${p.image }"
								alt="" class="card-img-top">
						</div>

						<div class="col-sm-7 card p-3">
							<div class="card-body">
								<h3 class="card-title">${p.title }</h3>
								<span class="text-warning m-2"><h4>US $ ${p.price }</h4></span>
								<h5 class="card-subtitle mb-2">Description</h5>
								<p class="card-text">${p.description}</p>
								<h5 class="card-subtitle">Quantity:</h5>
								<div class="row mt-2 mb-2">
									<div class="col-sm-4">
										<a class="btn btn-block bg-primary text-white text-uppercase"
											href="#">buy now</a>
									</div>
									<div class="col-sm-5">
										<a
											class="btn btn-block border border-primary text-primary text-uppercase"
											href="#">add to cart</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- detail  -->

		</div>
		
		<!-- container  -->
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
</body>

</html>