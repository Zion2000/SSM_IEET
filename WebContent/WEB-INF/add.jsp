<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
 <% pageContext.setAttribute("ctp", request.getContextPath()); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>管理员页面阿这</title>
<script type="text/javascript" src="${ctp }/js/jquery-3.1.1.min.js">
</script>
 <link href="${ctp }/css/default.css"   rel="stylesheet" type="text/css"/>
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
			<div class="header"></div>
			<div class="content-categories">
				
				<div class="label-wrapper">
					<input class="nav-item" name="nav" type="radio" id="opt-2" checked>
					<label class="category" for="opt-2"><a href="${ctp}/admin/1">管理员界面</a></label>
				</div>
				
			</div>
					
				
				
				<!-- 从这里开始插入代码！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！ -->
		
			
	
	<div class="page">
	
	    <div class="panel">
	        <div class="panel_visible">
		<% pageContext.setAttribute("ctp", request.getContextPath()); %>
		<h1 class="panel_title"> 添加 </h1>
		
		<form:form action="${ctp}/addPost?type=${type}" method="post" modelAttribute="Personnel">
		
			<label class="form_label" >姓名：</label>
			<form:input path="name" class="form_input" id="username" name="username" /><br/>		
			<label class="form_label" >职位：</label>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
				教师:<form:radiobutton path="type" value="教师"/>&nbsp &nbsp
				审核人员:<form:radiobutton path="type" value="审核人员"/><br/>
				
			<label class="form_label" >队名：</label>
			<form:input path="team" class="form_input"/><br/>
			<label class="form_label" >账号名：</label>
			<form:input  path="idname" class="form_input"/><br/>
			<label class="form_label" >密码：</label>
			<form:input path="pword" class="form_input"/><br/>
			<input type="submit" value="添加" class="form_btn" />
			
		</form:form>
			
	</div>
		 </div>	
	</div>
	   
	
			
			
		<!-- end -->
			</div>
		</div>
		

	</div>
</body>
</html>