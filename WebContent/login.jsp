<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<title>login</title>
 <% pageContext.setAttribute("ctp", request.getContextPath()); %>
<link href="${ctp }/css/login.css" rel="stylesheet" type="text/css"/>
<link href="${ctp }/css/bootstrap-3.1.1.min.css" rel="stylesheet" type="text/css"/>
</head>
<body style="text-align: center;">

	
							
<div class="container">
			<div class="row align-self-center" >
				<div class="col-md-offset-3 col-md-6">
<form class="form-horizontal" name="form1" action="${pageContext.request.contextPath}/adminlogin" method="post" accept-charset="UTF-8">
						<span class="heading">IEET</span>
						<div class="form-group">
							<input name="idname" type="text" class="form-control" placeholder="用户" id="username"
								value="" autocomplete='off' />
							${ErrorName}
							<!--autocomplete用来清除表单数据-->
						</div>
						<div class="form-group">
							<input name="pword" type="text" class="form-control" id="password" placeholder="密码"
								value="" autocomplete='off' />
							${ErrorPsw}
						</div>

						<a>${Errorid}</a>
						<div class="form-group">
							<label for="a" class="radio-inline">
								<input type="radio" name="identity"  id="a" value="1">教师改你尕爹
							</label>
							<label  for="b" class="radio-inline">
								<input type="radio" name="identity" id="b" value="2">审核人员
								</label>
							<label for="c" class="radio-inline">
								<input type="radio" name="identity" id="c" value="3">管理员
							</label>
			
						</div>



						<div class="form-group">

							<input class="submit" type="submit" id="btnSubmit" value="登录" onclick="login()">
						<h5 > <font color="red">${msg } </font></h5>	

						</div>


					</form>
					
				</div>
			</div>
		</div>
</body>
</html>