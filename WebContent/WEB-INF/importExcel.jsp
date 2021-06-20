<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<% pageContext.setAttribute("ctp", request.getContextPath()); %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title>管理员页面</title>
		<script type="text/javascript" src="${ctp }/js/jquery-3.1.1.min.js">
		</script>

		<link href="${ctp }/css/default.css" rel="stylesheet" type="text/css" />
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
				<a href="${ctp}/exitimportE" style="position: absolute;left: 90%;">退出</a>
				<div class="edui-dialog-wrap admin-default">
					<div id="edui20_body" class="dialog-body admin-default" style="width: 652px; height: 250px;">
						<div class="dialog-shadow admin-default">
							<div id="edui20_titlebar" class="edui-dialog-titlebar admin-default">
								<div class="edui-dialog-draghandle admin-default">
									<span class="edui-dialog-caption admin-default" style="margin-left: 5% ;">附件</span>
									<span class="edui-dialog-caption admin-default" style="margin-left: 65%;">
										<a href="${ctp}/exportExcelModel">导出Excel模板</a>
									</span>

								</div>
							</div>
							<div id="edui20_content" class="edui-dialog-content admin-default">
								<div class="" style="margin:0 auto">

									<br />
									<form action="${pageContext.request.contextPath }/read" method="post"
										enctype="multipart/form-data">


										<div id="edui20_buttons" class="leile">
											<div id="edui23" class="edui-box edui-button  admin-default">
												<input type="file" name="uploadFile"
													accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
													class="edui-box edui-label admin-default"
													style="margin-top: 20%; " /><br /><br />
											</div>
										</div>



										<div id="edui20_buttons" class="dialog-buttons admin-default">
											<div id="edui22" class="edui-box edui-button edui-okbutton admin-default">
												<input type="submit" value="上传"
													class="edui-box edui-label admin-default" />
											</div>
											<div id="cancelbtn"
												class="edui-box edui-button edui-cancelbutton admin-default">
												<input type="submit" value="取消"
													class="edui-box edui-label admin-default" />
											</div>
										</div>

									</form>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div style="display: ${display}">
					<div class="content-categories">

						<div class="label-wrapper">
							<input class="nav-item" name="nav" type="radio" id="opt-2" checked>
							<label class="category" for="opt-2"><a>错误信息</a></label>
						</div>

					</div>



					<!-- 从这里开始插入代码！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！ -->





					<a style="color: red;">${importExcelMsg }</a>
					<a style="color: red;">${importExcelMsga }</a>
					<a style="color: red;">${xxx }</a>
					<%	 %>
					<% pageContext.setAttribute("ctp", request.getContextPath()); %>

					<form action="${ctp}/OverWarite" method="post">
						<%-- <input type="hidden" name="listwzw" value="${listwzw}"/>  --%>

						<table class="blue" align="" border=none>
							<tr>
								<td>编号</td>
								<td>名字</td>
								<td>职位</td>
								<td>队名</td>
								<td>账号</td>
								<td>密码</td>
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

						<!-- 						 
				     <input id="bb" type="submit" 
						  value="覆盖" 
						 >	 -->
					</form>
					<!-- end --><a>${uploadFilewzw}</a>
				</div>
			</div>
		</div>

		</div>
		<script type="text/javascript">
		$(function(){
			$("#cancelbtn").click(function(){		
				//$('input[type=checkbox]').prop('checked')
				window.location.reload();
				return false;
				});
			});
		</script>
		
		
	</body>
</html>
