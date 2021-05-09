<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新增学生信息</title>
	</head>
	<body>
		<label style="color:red">${msg}</label>
		<form action="messageAdd" method="post">
	
			姓名：<input type="text" name="message"/><br/>
			年龄：<input type="text" name="name"/><br/>
			课程：<input type="text" name="Pid"/><br/>
			<input type="submit" value="新增" />
		</form>
	</body>
</html>