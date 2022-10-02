<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng ký thành công</title>
  <style>
    .wrapper{
      width: 800px;
      margin: 10px auto;
    }
    .bg-cute{
      padding-top: 400px;
      
      background: url('https://i.pinimg.com/564x/32/82/8a/32828a1554ad31ff44c5d4bd948cfdd7.jpg') no-repeat center / cover;
    }
  </style>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>

<body>
  <div class="wrapper mt-5 text-center d-flex flex-column">
    <div class="h1 r text-success mb-5">
      <i class="fa-solid fa-circle-check"></i> Đăng ký thành công
    </div>
    <div class="bg-cute"></div>
    <a href="${pageContext.request.contextPath}/sign-in" class="mt-3 text-decoration-none">Đăng nhập ngay</a>
  </div>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>
</body>

</html>