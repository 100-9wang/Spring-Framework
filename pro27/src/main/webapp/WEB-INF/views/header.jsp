<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("utf-8");
%>    
<p:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            font-family: "Jua", serif;
        }
        .nav-link {
            color: white !important;
        }
        .nav-link:hover {
            color: #ddd !important;
        }
        .logo img {
            height: 150px;
        }
        .header {
            padding: 20px 0;
        }
        .header .container-fluid {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .logo {
            flex: 1;
            font-size: 55px;
            margin-right:20px;
        }
        .user-info {
            text-align: right;
            display: flex;
            align-items: center;
        }
        .user-info h3 {
            margin-right: 10px;
        }
        
        .user-info button {
            margin-top: -14px;
        }
        
        
    </style>
</head>
<body>
    <div class="header bg-white text-dark">
        <div class="container-fluid">
            <div class="logo">
                <a href="${contextPath}/main.do">
                    <img src="${contextPath}/resources/images/honey.png" alt="Logo" />
                </a>
                &nbsp;&nbsp;<a>Honey Bee</a>
            </div>
            <div class="user-info">
                <p:choose>
                    <p:when test="${isLogOn == true && member != null}">
                        <h3>반갑습니다, ${member.name}님</h3>
                        <a href="${contextPath}/member/logout.do">
                            <button class="btn btn-danger">로그아웃</button>
                        </a>
                    </p:when>
                    <p:otherwise>
                        <a href="${contextPath}/member/loginForm.do">
                            <button class="btn btn-success">로그인</button>
                        </a>
                    </p:otherwise>
                </p:choose>
            </div>
        </div>
    </div>   
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <p>Home</p>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
                <div class="offcanvas-header">
                    <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    	<li class="nav-item">
            				<a class="nav-link active" aria-current="page" href="${contextPath}/member/listMembers.do">회원 관리</a>
            			<li class="nav-item">
            				<a class="nav-link active" aria-current="page" href="#">상품 관리</a>	
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                게시판 관리
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
