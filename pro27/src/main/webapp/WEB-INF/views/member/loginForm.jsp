<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<p:set var="contextPath" value="${pageContext.request.contextPath}" />
<p:set var="result" value="${param.result}"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 창</title>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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

        .form-group {
            margin-bottom: 1rem;
        }

        .footer-btns {
            margin-top: 20px;
        }

        .alert {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>로그인</h1>
        <p:choose>
            <p:when test="${result == 'loginFailed'}">
                <div class="alert alert-danger">
                    아이디나 비밀번호가 틀립니다. 다시 시도해주세요.
                </div>
            </p:when>
        </p:choose>
        <form name="frmLogin" method="post" action="${contextPath}/member/login.do">
            <div class="mb-3">
                <label for="id" class="form-label">아이디</label>
                <input type="text" class="form-control" id="id" name="id" required>
            </div>

            <div class="mb-3">
                <label for="pwd" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="pwd" name="pwd" required>
            </div>

            <div class="footer-btns">
                <button type="submit" class="btn btn-primary">로그인</button>
                <button type="reset" class="btn btn-warning">다시 입력</button>
            </div>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>
