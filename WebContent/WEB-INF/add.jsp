<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<% pageContext.setAttribute("ctp", request.getContextPath()); %>
		<form:form action="${ctp}/addPost" method="post" modelAttribute="Personnel">
		
			姓名：<form:input path="name"/><br/>		
			type：<br/>
				教师  ：<form:radiobutton path="type" value="教师"/>&nbsp&nbsp
				审核人员:<form:radiobutton path="type" value="审核人员"/><br/>
				
			team：<form:input path="team"/><br/>
			账号名：<input type="text" name=idname/><br/>
			密码：<input type="text" name="pword"/><br/>
			<input type="submit" value="保存" />
			
		</form:form>
</body>
</html>