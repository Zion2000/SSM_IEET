<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<link href="/WEB-INF/css/adminindex.css" rel="stylesheet" type="text/css"/>
 <% pageContext.setAttribute("ctp", request.getContextPath()); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>教师页面</title>
<script type="text/javascript" src="${ctp }/js/jquery-3.1.1.min.js">
</script>

<link href="${ctp }/css/adminindex.css" rel="stylesheet" type="text/css"/>
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
					<li class="item"> <span></span>
					</li>
					<li class="item"> <span>
							</span></li>
				</ul>

			</div>
		</div>
		<div class="page-content">
			<div class="header">教师页面</div>
			<div class="content-categories">
				
				
				
			</div>
					
			 
				
				
				
				<!-- 从这里开始插入代码！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！ -->
			
			
			<div>
				<ul class="action-list">
					<li class="item"><a href="${pageContext.request.contextPath}/upload"><img src="./icon/user.png" /> </a><span>教师上传</span></li>
					<li class="item"><a href="${pageContext.request.contextPath}/personnelInfo"><img src="./icon/user.png" /> </a><span>教师消息</span></li>
						
				</ul>			
			</div>
		
		
			<div>
			
				<div>
				<form action="${pageContext.request.contextPath}/FindBypid" >
				教师编号搜索:<input type="text"  name="pid"  placeholder="输入教师编号搜索">
				<input type="submit" value="查看消息">
				</form>
			
			</div>
			
			
						<div>
						<table border="2" width="300">
			<tr>
				<td>文件名</td>
				<td>日期名</td>
				<td>审核状态</td>
				
			</tr>
			<c:forEach items="${bases}" var="s">
				<tr>
					<td>${s.name }</td>
					<td>${s.bdate }</td> 
					<td>${s.bstatus }</td> 
					

					
					
					
				</tr>
			</c:forEach>
		</table>
			
			</div>
			
			</div>
				<br>
				   <h2>文件上传</h2>
				   <br>
				<form action="${pageContext.request.contextPath}/fileup?pidds=${pidds }" method="post" enctype="multipart/form-data">
			
				                文件:<input type="file" name="file"/><br/><br/>
				      <input type="submit" value="上传"/>
				</form>

			
				<!-- end -->
			</div>
		</div>
		

	</div>
</body>
</html>