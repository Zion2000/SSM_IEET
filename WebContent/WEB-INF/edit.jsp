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
			<%-- /${Personnel.pid }--%> 
			<% pageContext.setAttribute("ctp", request.getContextPath()); %>
		<form:form action="${ctp}/personUpdate" method="post" modelAttribute="Personnel">
		<input type="hidden" name="_method" value="put"/>
		<input type="hidden" name="id" value="${Personnel.pid }"/>
		<input type="hidden" name="typesss" value="${typesss }"/>
		<input type="hidden" name="keyw" value="${keyw }"/>
			姓名：<form:input path="name"/><br/>		
			type：<br/>
				教师  ：<form:radiobutton path="type" value="教师"/>&nbsp&nbsp
				审核人员:<form:radiobutton path="type" value="审核人员"/><br/>
				
			team：<form:input path="team"/><br/>
			账号名：<form:input  path="idname"/><br/>
			密码：<form:input path="pword"/><br/>
			<input type="submit" value="保存" />
			
		</form:form>
			
</body>
</html>