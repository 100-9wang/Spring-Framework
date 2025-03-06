<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<p:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style>
	html, body {
		height: 100%;
		margin: 0;
		display: flex;
		justify-content: center;
		align-items: center;
		font-family: "Jua", serif;
	}

	.container {
		font-size: 1.25rem;
		text-align: center;
		width: 100%;
		max-width: 500px;
		padding: 20px;
		box-sizing: border-box;
		background-color: #f8f9fa;
		border-radius: 8px;
		box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	}

	h1 {
		font-size: 2rem;
		margin-bottom: 20px;
	}

	.form-label {
		text-align: left;
	}

	input.form-control {
		width: 100%;
	}

	.form-group {
		margin-bottom: 1rem;
	}

	.row {
		margin-bottom: 10px;
	}
</style>
<meta charset="UTF-8">
<title>회원 가입창</title>
</head>
<body>
	<div class="container">
		<form method="post" action="${contextPath}/member/addMember.do">
			<h1 class="text_center">회원 가입창</h1>

			<div class="mb-3 row">
				<label for="id" class="col-sm-4 col-form-label">아이디</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="id" name="id">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="pwd" class="col-sm-4 col-form-label">비밀번호</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="pwd" name="pwd">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="name" class="col-sm-4 col-form-label">이름</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="name" name="name">
				</div>
			</div>

			<div class="mb-3 row">
				<label for="email" class="col-sm-4 col-form-label">이메일</label>
				<div class="col-sm-8">
					<input type="email" class="form-control" id="email" name="email">
				</div>
			</div>

			<div class="text-center">
				<input class="btn btn-info" type="submit" value="회원가입">
				 <input class="btn btn-warning" type="reset" value="다시입력">
			</div>
		</form>
	</div>
</body>
</html>
