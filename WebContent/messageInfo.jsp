<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>学生信息</title>
	</head>
	<body>
		<h2><a href="messageAll">刷新</a></h2>
		<h2>学生信息</h2>
		<table border="1" width="300">
			<tr>
				<td>Mid</td>
				<td>message</td>
				<td>name</td>
				<td>Pid</td>
			</tr>
			<c:forEach items="${messages}" var="s">
				<tr>
					<td>${s.mid }</td>
					<td>${s.message }</td>
					<td>${s.name }</td>
					<td>${s.pid }</td>
					<td>
					<a href="${pageContext.request.contextPath}/delete.action?sid=${s.mid}">删除</a></td>
					
					
					
				</tr>
			</c:forEach>
		</table>
	</body>
</html>