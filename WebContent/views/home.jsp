<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop</title>
<link rel="stylesheet" href="../css/styles.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.7.1/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style>
.show_txt{
    display: inline-block;
    width: 100%;
    white-space: nowrap;
    overflow: hidden !important;
    text-overflow: ellipsis;
}
</style>
</head>
<body>

	<div class="wrapper">
	
		<!-- 		header -->
		<jsp:include page="_header.jsp"></jsp:include>
		<!-- 		header -->
		
		<!-- container  -->
		<div class="container">
		<div class="row">
			<!-- 			left-bar  -->
			<jsp:include page="_left-bar.jsp"></jsp:include>
			<!-- 			left-bar  -->
		
				<!-- item  -->
				<p style="color:red">${resultLength==0?"Không tìm thấy kết quả":""}</p>
				<div class="col-sm-9">
					<div class="row">
						<c:forEach items="${PList}" var="item">
							<div class="col-lg-4">
								<div class="card">
									<img class="card-img-top" src="${item.image}">
									<div class="card-body">
										<h4 class="card-title show_txt">
											<a href="${pageContext.request.contextPath }/detail?id=${item.id}" title="">${item.title}</a>
										</h4>
										<p class="card-text show_txt">${item.description}</p>
										<div class="row">
											<div class="col">
												<p class="btn btn-danger btn-block">${item.price}$</p>
											</div>
											<div class="col">
												<a href="#" class="btn btn-success btn-block">Add to
													cart</a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
				<!-- item  -->

			</div>
		</div>
		<!-- container  -->

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
</body>
</html>