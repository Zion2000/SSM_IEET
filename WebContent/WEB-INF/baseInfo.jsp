<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link media="all" rel="stylesheet" type="text/css"
			href="./css/adminindex.css" />
		<script src="./js/jquery-3.1.1.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>伤心的人没含金量</title>
		<script type="text/javascript">
			function doPost(to,p){//to:提交的action p是文件名参数
				var myForm=document.createElement("form");
				myForm.method="post";
				myForm.action=to;
				for(var i in p){
					var myInput=document.createElement("input");
					myInput.setAttribute("name",i);//设置input对象的name
					myInput.setAttribute("value",p[i]);//设置input对象的value值
					myForm.appendChild(myInput);
				}
				document.body.appendChild(myForm);
				//提交表单
				myForm.submit();
				document.body.removeChild(myForm); //提交表单之后，移除myForm元素
			}

			function sure() {
				var boo = confirm('确认审核通过吗？')
				if(boo) {
					alert('审核通过');
				}
				else {
					alert('润了润了');
				}
			}

			function Unsure() {
				var foo = confirm('确认审核不通过吗？')
				if(foo) {
					alert('审核失败');
				}
				else {
					alert('润了润了');
				}
			}
			
		</script>
		<style>
		th, tr, td, table {
			border: 10px solid blue;
		}
		</style>
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
					<li class="item"><img src="./icon/user.png" /> <span>Inbox</span>
					</li>
					<li class="item"><img src="./icon/user.png" /><a href="${pageContext.request.contextPath}/messageAll">查看消息</a> <span>
							审核消息</span></li>
			
					</li>
				</ul>
				
			</div>
		</div>
		<div class="page-content">
			<div class="header">Today</div>
			<div class="content-categories">
				<div class="label-wrapper">
				 <input id="cc" type="radio" 
						name="lifeType" value="0" 
						onclick="location.href='baseAll'" />未审核
				</div>
				
				<div class="label-wrapper">
				 <input id="aa" type="radio" 
						name="lifeType" value="1" 
						onclick="location.href='passWeb'" />审核成功
				</div>
				
				<div class="label-wrapper">
					<input id="bb" type="radio" 
						name="lifeType" value="-1" 
						onclick="location.href='failWeb'" />审核失败
				</div>
				
			</div>
			<table align="center">
				<tr>
				<td>Bid</td>
				<td>name</td>
				<td>Bdate</td>
				<td>Pid</td>
				<td>Bstatus</td>
				<td>审核</td>
			</tr>
			<c:forEach items="${bases}" var="s">
				<tr>
					<td>${s.bid }</td>
					<td><a href="javascript:doPost('filedown',{'fileName':'${s.name}.txt'})">${s.name}</a></td>
					<td>${s.bdate }</td>
					<td>${s.pid }</td>
					<td>${s.bstatus }</td>
					<td>
						<a href="${pageContext.request.contextPath}/pass.action?bid=${s.bid}" onclick="sure()">通过</a>
						<a href="${pageContext.request.contextPath}/fail.action?bid=${s.bid}" onclick="Unsure()">不通过</a>
					</td>
				</tr>
			</c:forEach>
	</table>

			</div>
		</div>
		<script type="text/javascript">
		
		function select(){
			var url = "./delete.jsp";
			 window.location.href= url;
			 }
		
		
</script>

	</div>
</body>
</html>