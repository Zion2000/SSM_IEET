<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<link href="/WEB-INF/css/adminindex.css" rel="stylesheet" type="text/css"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>管理员页面</title>

<link media="all" rel="stylesheet" type="text/css"
	href="../css/adminindex.css" />
<script src="../js/jquery-3.1.1.min.js"></script>
</head>
<body>

	
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
					<li class="item"><img src="../icon/user.png" /> <span>Inbox</span>
					</li>
					<li class="item"><img src="../icon/user.png" /> <span>
							Today</span></li>
				</ul>

			</div>
		</div>
		<div class="page-content">
			<div class="header">Today</div>
			<div class="content-categories">
				
				<div class="label-wrapper">
					<input class="nav-item" name="nav" type="radio" id="opt-2" checked>
					<label class="category" for="opt-2">管理员界面</label>
				</div>
				
			</div>
					<div class="container">
				<form action="AdminServlet" method="post" accept-charset="UTF-8">

		
					 <ul>
		  <li>
					<label for="aa"class="radio-inline">
					 	 <input id="aa" type="radio" 
						name="lifeType" value="1" ${tcheckinput }
						onclick="location.href='AdminServlet?teacher=teacher&flag=2'" />教师
					</label> 
				</li>	 
					<li>
					<label for="bb" class="radio-inline"> 
						<input id="bb" type="radio"
						 name="lifeType" value="2" ${acheckinput }
						 onclick="location.href='AdminServlet?audit=audit&flag=1'"/>审核人员
					</label>
				</li>
		</ul>	
				</form>
			</div>	
			 
				<div class="serch-warp">
					<form action="AdminServlet?flag=${flag }" method="post">
					<input class="inputt" placeholder="key worlds" name="keywords" id="" type="text" />
					<input class="inputg" placeholder="" name="sub" value="查询" id="" type="submit" />
					</form>
				</div>
				
				
				<!-- 从这里开始插入代码！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！ -->
		
			 
				
				
				
			
				
				
			<div class="tasks-wrapper">
					<table class="blue" align="center" border=none>
						<tr>
							<td>Pid</td>
							<td>name</td>
							<td>type</td>
							<td>team</td>
							<td>EDIT</td>
							<td>DELETE</td>
						</tr>	
						<c:forEach items="${personlist}" var="p">
					 	 <tr>
						 	<td>${p.pid}</td> 
							<td>${p.name}</td>
							<td>${p.type}</td>
							<td>${p.team}</td>
							<td>EDIT</td>
							<td>DELETE</td>
					 	 </tr>
						</c:forEach>
					</table> 	 
							
				
					<a href="toaddperson">添加人员</a>
				<div class="list-page">
							
				</div>

				

				<!-- end -->
			</div>
		</div>
		

	</div>
</body>
</html>