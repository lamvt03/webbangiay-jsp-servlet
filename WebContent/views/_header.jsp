<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- navbar -->
<nav
	class="navbar navbar-expand-sm bg-dark justify-content-sm-between text-white clearfix">

	<!-- left  -->
	<span class="navbar-nav"><a class="btn-link"
		href="${pageContext.request.contextPath}">Shoes</a></span>
	<!-- left  -->

	<!-- center  -->
	<div class="navbar-nav">
		<form action="${pageContext.request.contextPath}/search" method="post"
			class="form-inline my-2 my-lg-0" accept-charset="utf-8">
			<div class="input-group input-group-sm">
				<input name="inpTxt" type="text" class="form-control"
					value="${inpTxt}" aria-label="Small"
					aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
				<div class="input-group-append">
					<button type="submit" class="btn btn-secondary btn-number">
						<i class="fa fa-search"></i>
					</button>
				</div>
			</div>
			<a class="btn btn-success btn-sm ml-3" href="show"> <i
				class="fa fa-shopping-cart"></i> Cart <span
				class="badge badge-light">3</span>
			</a>
		</form>

	</div>
	<!-- center  -->

	<!-- right -->

	<ul class="navbar-nav">
		<c:if test="${sessionScope.user.isSell() == true}"> 
			<li class="nav-item"><a class="nav-link" href="#">Product 
					Manager</a></li> 
		</c:if> 
		
		<c:if test="${sessionScope.user.isAdmin() == true}">
			<li class="nav-item"><a class="nav-link" href="#">Account
					Manager</a></li>
		</c:if>
		<c:if test="${sessionScope.user == null}">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/sign-in">Log in</a></li>
		</c:if>
		<c:if test="${sessionScope.user != null}">
			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/log-out">Log out</a></li>
		</c:if>

	</ul>
	<c:if test="${sessionScope.user != null}">
		<span><i class="fa fa-user"></i> Hello <cite>${sessionScope.user.username}</cite></span>
	</c:if>
	<!-- right -->

</nav>
<!-- navbar -->

<!-- header  -->
<div class="header container-fluid bg-light text-center p-3">
	<h1>Siêu thị giày chất lượng cao</h1>
	<p>Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phẩm
		từ Trung Quốc</p>
</div>
<!-- header  -->