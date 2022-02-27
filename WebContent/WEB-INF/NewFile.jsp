
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
			<div class="header">查看组织</div>
			<div class="content-categories">				
				<div class="label-wrapper">
					<input class="nav-item" name="nav" type="radio" id="opt-1">
					<label class="category" for="opt-1"><a href="${pageContext.request.contextPath}/personnelAll">待添加组织</a></label>
				</div>		
				<div class="label-wrapper">
				<div class="label-wrapper">
					<input class="nav-item" name="nav" type="radio" id="opt-1">
					<label class="category" for="opt-1"><a href=personnelAll1>查看组织</a></label>
				</div>		
				</div>				
			</div>	
			
				
			<div>
				
	
		<h2>组织信息</h2>
		<table border="1" width="300">
			<tr>
				<td>pid</td>
				<td>name</td>
				<td>type</td>
				<td>team</td>
				<td>idname</td>
				<td>pword</td>
			
				
			</tr>
			<c:forEach items="${personnels}" var="s">
				<tr>
					<td>${s.pid }</td>
					<td>${s.name }</td>
					<td>${s.type }</td>
					<td>${s.team }</td>
					<td>${s.idname }</td>
					<td>${s.pword }</td>
				
					
					
					
				</tr>
			</c:forEach>
		</table>
				<h2><a href="${pageContext.request.contextPath}//personnelAll1">刷新</a></h2>
			</div>

							
		</div>				
	</div>
</body>
</html>

	

	