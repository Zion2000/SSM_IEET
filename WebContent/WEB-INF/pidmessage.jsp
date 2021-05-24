
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息通知</title>
<link media="all" rel="stylesheet" type="text/css" href="./css/adminindex.css" />
<script src="./js/jquery-3.1.1.min.js"></script>
</head>
<body  >
	<div class="task-manager">
		<div class="left-bar">
			<div class="upper-part">
				<div class="actions">
					<div class="circle"></div>
					<div class="circle-2"></div>
				</div>
			</div>
			<div class="left-content">
				<ul class="action-list">
					<li class="item"><a href="${pageContext.request.contextPath}/messageAdd"><img src="./icon/user.png" /> </a><span>发消息</span></li>
					<li class="item"><a href="${pageContext.request.contextPath}/findpid"><img src="./icon/user.png" /> </a><span>查消息</span></li>
					<li class="item"><a href="${pageContext.request.contextPath}/personnelAll"><img src="./icon/user.png" /> </a><span>待添加组织</span></li>
				</ul>
				
			</div>
		</div>
		<div class="page-content">
			<div class="header">教师查看消息界面</div>
			<div class="content-categories">				
				<div class="label-wrapper">
					<input class="nav-item" name="nav" type="radio" id="opt-1">
					<label class="category" for="opt-1"><a href="findpid.jsp">教师查看消息</a></label>
				</div>		
				<div class="label-wrapper">
				<form action="FirstSql">
					<input class="nav-item" name="nav" type="submit" id="opt-2" checked>
					<label class="category" for="opt-2" > 待开发</label>
					</form>			
				</div>				
			</div>		
			<div>
						<table border="2" width="300">
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

					
					
					
				</tr>
			</c:forEach>
		</table>
			
			</div>

							
		</div>				
	</div>
</body>
</html>

	

	