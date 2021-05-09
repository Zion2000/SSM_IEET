<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新增学生信息</title>
	</head>
	<body>
		<label style="color:red">${msg}</label>
		<form action="studentAdd" method="post">
			学号：<input type="text" name="sid"/><br/>
			姓名：<input type="text" name="sname"/><br/>
			年龄：<input type="text" name="age"/><br/>
			课程：<input type="text" name="course"/><br/>
			<input type="submit" value="新增" />
		</form>
	</body>
</html>