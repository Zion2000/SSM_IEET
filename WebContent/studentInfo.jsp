<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>学生信息</title>
	</head>
	<body>
		<h2><a href="studentAll">刷新</a></h2>
		<h2>学生信息</h2>
		<table border="1" width="300">
			<tr>
				<td>学号</td>
				<td>姓名</td>
				<td>年龄</td>
				<td>课程</td>
			</tr>
			<c:forEach items="${students}" var="s">
				<tr>
					<td>${s.sid }</td>
					<td>${s.sname }</td>
					<td>${s.age }</td>
					<td>${s.course }</td>
					<td>
					<a href="${pageContext.request.contextPath}/delete.action?sid=${s.sid}">删除</a></td>
					
					
					
				</tr>
			</c:forEach>
		</table>
	</body>
</html>