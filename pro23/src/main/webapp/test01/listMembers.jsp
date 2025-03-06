<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<p:set var="contextPath" value="${pageContext.request.contextPath}"></p:set>

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
	a {
		text-decoration-line: none;
	}

	a:link {
		color: black;
	}

	a:hover {
		color: red;
	}

	a:visited {
		color: gray;
	}

	.container {
		font-family: "Jua", serif;
		font-size: 1.25rem;
		font-style: normal;
	}


	.footer {
		text-align: center;
		margin-top: 20px;
	}

	.table-container {
		margin-bottom: 40px;
	}

	.footer .badge {
		font-size: 1.5rem; 
		padding: 15px 30px;
	}
	
	.footer .badge a:visited {
		color: white;
	}
	
</style>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<div class="container">
		<div class="table-container">
			<table class="table table-dark table-striped" align="center">
				<thead>
					<tr bgcolor="#6699FF" align="center">
						<th scope="col"></th>
						<th scope="col">아이디</th>
						<th scope="col">비밀번호</th>
						<th scope="col">이름</th>
						<th scope="col">이메일</th>
						<th scope="col">가입일</th>
					</tr>
				</thead>
				<tbody>
					<p:forEach var="member" items="${membersList}">
						<tr align="center">
							<th scope="row"></th>
							<td>${member.id}</td>
							<td>${member.pwd}</td>
							<td>${member.name}</td>
							<td>${member.email}</td>
							<td>${member.joinDate}</td>
					</p:forEach>
				</tbody>
			</table>
		</div>
		<div class="footer">
			<span class="badge rounded-pill text-bg-warning"> <a
				href="${contextPath}/member/memberForm.do">회원가입</a>
			</span>
		</div>
		</div>
</body>
</html>
