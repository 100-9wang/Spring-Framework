<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<p:set var="contextPath" value="${pageContext.request.contextPath}"></p:set>

<html>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>회원 목록</title>
    <style>
        a {
            text-decoration-line: none;
            color: black;
        }
        a:hover {
            color: red;
        }
        a:visited {
            color: gray;
        }

        .container-fluid {
            font-family: "Jua", serif;
            font-size: 1.25rem;
        }

        .table-container {
            margin-bottom: 0;
        }

        .footer1 {
            text-align: center;
            margin-bottom: 15px;
        }

        .footer1 .badge {
            font-size: 1.5rem;
        }
        .footer1 .badge a:visited {
            color: white;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <%@ include file = "../header.jsp" %>

        <div class="table-container mt-5">
            <table class="table table-dark table-striped" align="center">
                <thead>
                    <tr bgcolor="#6699FF" align="center">
                        <th scope="col">아이디</th>
                        <th scope="col">비밀번호</th>
                        <th scope="col">이름</th>
                        <th scope="col">이메일</th>
                        <th scope="col">가입일</th>
                        <th scope="col">삭제하기</th>
                        <th scope="col">수정하기</th>
                    </tr>
                </thead>
                <tbody>
                    <p:forEach var="member" items="${membersList}">
                        <tr align="center">
                            <td>${member.id}</td>
                            <td>${member.pwd}</td>
                            <td>${member.name}</td>
                            <td>${member.email}</td>
                            <td>${member.joinDate}</td>
                            <td><span class="badge rounded-pill text-bg-info"> <a href="${contextPath}/member/removeMember.do?id=${member.id}">삭제하기</a> </span></td>
                            <td><span class="badge rounded-pill text-bg-info"> <a href="${contextPath}/member/modMember.do?id=${member.id}">수정하기</a> </span></td>
                        </tr>
                    </p:forEach>
                </tbody>
            </table>
        </div>

        <div class="footer1">
            <span class="badge rounded-pill text-bg-warning">
                <a href="${contextPath}/member/memberForm.do">회원가입</a>
            </span>
        </div>

        <%@ include file = "../footer.jsp" %>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>    
</body>
</html>
