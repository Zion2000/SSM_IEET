
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
			<div class="header">发送消息</div>
			<div class="content-categories">				
				<div class="label-wrapper">
					<input class="nav-item" name="nav" type="radio" id="opt-1">
					<label class="category" for="opt-1"><a href="${pageContext.request.contextPath}/messageAll">查看消息</a></label>
				</div>		
				<div class="label-wrapper">
				<form action="">
					<input class="nav-item" name="nav" type="submit" id="opt-2" checked>
					<label class="category" for="opt-2" > 待完善</label>
					</form>			
				</div>				
			</div>		

				
		<label style="color:red">${msg}</label>
		<form action="messageAdd" method="post">
		<table></table>
			
			<tr>发送人：<input type="text" name="name"/><tr/>
			<br><br><br>
			<tr>接受人：<input type="text" name="Pid"/><tr/>
			<br><br><br>
			<tr>文件编号：<input type="text" name="Bid"/><tr/>
			<br><br><br>
			<tr>写消息：<input style="height:100px;width:800px;" size="10" type="text" name="message"/><tr/>
			<br><br><br>
			<input  type="submit" value="新增" />
		
		</form>

			</table>			
							
		</div>				
	</div>
</body>
</html>

	

	