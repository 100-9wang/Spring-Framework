<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<p:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result page</title>
</head>
<body>
	<h1>업로드가 완료되었습니다.</h1>
	<label>아 이 디 : </label>
	<input type="text" name ="id" value ="${map.id}" readonly><br>
	<label>이 름 : </label>
	<input type="text" name ="name" value="${map.name}" readonly><br>
	
	
	<div class="result-images">
		<p:forEach var = "imageFileName" items="${map.fileList}" >
			<img src = "${contextPath}/download?imageFileName=${imageFileName}">
			<br><br>
		</p:forEach>
	</div>
	<a href = "${contextPath}/form">다시 업로드 하기</a>
</body>
</html>