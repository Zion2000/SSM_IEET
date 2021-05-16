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

<title>管理员页面</title>
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
			<div class="header">Today</div>
			<div class="" style="margin:0 auto">
				<form action="${pageContext.request.contextPath }/read" method="post" enctype="multipart/form-data">
				   <h2>文件上传</h2><a href="${ctp}/exitimportE" style="position: absolute;left: 90%;">退出</a>
				                文件:<input type="file" name="uploadFile"/><br/><br/>
				      <input type="submit" value="上传"/>
					</form>
			</div>
			<div class="content-categories">
				
				<div class="label-wrapper">
					<input class="nav-item" name="nav" type="radio" id="opt-2" checked>
					<label class="category" for="opt-2"><a ">错误信息</a></label>
				</div>
				
			</div>
					
	
				
				<!-- 从这里开始插入代码！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！ -->
		
					 
					
				
				
				<a style="color: red;">${importExcelMsg }</a> 
				<a style="color: red;">${importExcelMsga }</a>
				<a style="color: red;">${xxx }</a>
				<%	 %>		
				<% pageContext.setAttribute("ctp", request.getContextPath()); %>
				
	
					<table class="blue" align="" border=none>
						<tr>
							<td>Pid</td>
							<td>name</td>
							<td>type</td>
							<td>team</td>
							<td>idname</td>
							<td>pword</td>
						</tr>	
						<c:forEach items="${listwzw}" var="p">
					 	 <tr>				 	
						 	<td>${p.pid}</td> 
							<td>${p.name}</td>
							<td>${p.type}</td>
							<td>${p.team}</td>		
							<td>${p.idname}</td>
							<td>${p.pword}</td>						
					 	 </tr>
						</c:forEach>
					</table> 	
<!-- end -->
			</div>
		</div>
		

	</div>
</body>
</html>