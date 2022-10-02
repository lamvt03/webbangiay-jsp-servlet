<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<!-- category -->
	<div class="col-sm-3">
		<div class="card-header text-white text-uppercase bg-primary">
			<i class="fa fa-list"></i> Categories
		</div>
		<ul class="list-group">
			<c:forEach items="${CList}" var="item">
				<li class="list-group-item  ${item.id == flat? "active": " "}" ><a
					class="text-dark" href="category?id=${item.id}">${item.name}</a></li>
			</c:forEach>
		</ul>

		<!-- last product  -->
		<div class="card mt-3 ">
			<div class="card-title bg-success text-uppercase p-3 text-white">last
				product</div>
			<img class="card-img-top" src="${LastProduct.image}">
			<div class="card-body p-3">
				<h4 class="card-subtitle">${LastProduct.title}</h4>
				<p class="card-text">${LastProduct.description}</p>
				<span class="btn btn-block btn-danger">${LastProduct.price}$</span>
			</div>
		</div>
		<!-- last product  -->
	</div>
<!-- category -->