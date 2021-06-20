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
			<div class="header">
			<a href="${ctp}/exitadmin" style="position: absolute;left: 90%;">退出</a>
			</div>
			<div class="content-categories">
				
				<div class="label-wrapper">
					<input class="nav-item" name="nav" type="radio" id="opt-2" checked>
					<label class="category" for="opt-2"><a href="${ctp}/admin/1">管理员界面</a></label>
				</div>
				
			</div>
					<div class="container">
				<form action="${ctp}/adminss" method="post" accept-charset="UTF-8">		
					 <ul>
		  <li>
					<label for="aa"class="radio-inline">
					 	 <input id="aa" type="radio"  ${checkedT }
						name="lifeType" value="教师" 
						 onclick="location.href='${ctp}/adminss/teacher/1'" >教师
					</label> 
				</li>	 
					<li>
					<label for="bb" class="radio-inline"> 
						<input id="bb" type="radio" ${checkedA }
						 name="lifeType" value="审核人员" 
						  onclick="location.href='${ctp}/adminss/audit/1'" >审核人员
					</label>
				</li>
		</ul>	
				</form>
			</div>	
			 
				<div class="serch-warp">
					<form action="${ctp}/SearchAdmin" method="post">
					<input class="inputt" placeholder="关键字" value="${keywords }" name="keywords" id="" type="text" />
					<input class="inputg" placeholder="" name="sub" value="查询" id="" type="submit" />
					</form>
					
				</div>
				
				
				<!-- 从这里开始插入代码！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！ -->
		
			
				<div class="list-page">
				<span><a href="${ctp}/deleteMore" id="deleteMore">批量删除</a>	</span>	
						&nbsp;&nbsp;&nbsp;
				<span>
				
					<select id="aaa">
						<c:forEach items="${allTeam }" var="a">
							<option >${a.team}</option>
						</c:forEach>
					</select> 
					<a href="${ctp}/updateMore/" id="updateMore">批量修改队名</a>
				</span>	
						&nbsp;&nbsp;&nbsp;
					<span><a href="${ctp}/toaddperson?type=${map}&keyw=${keyw}">添加人员</a></span>&nbsp;&nbsp;&nbsp;	
					<span><a href="${ctp}/exportAllExcel?type=${map}&keyw=${keyw}" >导出所有Excel</a></span>&nbsp;&nbsp;&nbsp;
					<span><a href="${ctp}/exportExcel?type=${map}&keyw=${keyw}" >导出当前页面的Excel</a></span>&nbsp;&nbsp;&nbsp;
					<span> <a href="${ctp}/importExcelpage" >导入Excel</a></span>
				<span>	<a style="color: red;">${Errormsg}</a> </span>
				</div>
				
					<div class="tasks-wrapper">
			<form id="moreoptionform" method="post" >
					<!-- <input type="hidden" name="_method" value="delete"/> -->	
				
				
		
					<table class="blue" align="center" border=none>
						<tr>
							<td>
							<input type="checkbox" id="selectAll"/>
							</td>
							<td>编号</td>
							<td>名字</td>
							<td>职位</td>
							<td>团队</td>
							<td>账号名</td>
							<td>编辑</td>
							<td>删除</td>
						</tr>	
						<c:forEach items="${personlist}" var="p">
					 	 <tr>
					 	 <td>
					 	 	<input type="checkbox" name="check" value="${p.pid }" id="selectzz"/>
					 	 </td>
						 	<td>${p.pid}</td> 
							<td>${p.name}</td>
							<td>${p.type}</td>
							<td>${p.team}</td>
							<td>${p.pword}</td>
							<td><a href="${ctp}/personEidt/${p.pid}?type=${map}&keyw=${keyw}">编辑</a></td>
							<td><a href="${ctp}/personEidt/${p.pid}?type=${map}&keyw=${keyw}" class="deleteBtn">删除 </a></td>
					 	 </tr>
						</c:forEach>
					</table> 	 	
													
				</form>							
					
				${page }	
				
				
				<form id="deleteform" action="${ctp}/personEidt/"  method="post" >
									<input type="hidden" name="_method" value="delete"/>									
				</form>	
			<%-- 	<form id="updateMoreform" action=""  method="post" >
						<input type="hidden" name="_method" value="PUT"/>									
								</form>	 --%>
				
				
				<script type="text/javascript">
				//alert("test");
				 $(function(){
					$(".deleteBtn").click(function(){
						var empName = $(this).parents("tr").find("td:eq(2)").text();
						if(confirm("确认删除[" + empName + "]吗?")) {
						$("#deleteform").attr("action",$(this).attr("href"));
						$("#deleteform").submit();
						
						}
						return false;
						});
					});  
				  
				 $(function(){
						$("#selectAll").click(function(){
					 
					$("[name='check']").prop("checked",$(this).prop("checked"));
						});
					});
				 $(function(){
						$("#deleteMore").click(function(){
							 var empNames = "";
							
								  $.each($("#selectzz:checked"), function() {
							      empNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
							     }); 
							     
						          empNames = empNames.substring(0, empNames.length - 1);		
								
						          				        										
							if(confirm("确认删除["  + empNames  + "]吗?")) {
								$('#deleteMore').attr('href','${ctp}/deleteMore/?type=${map}&keyw=${keyw}'); 
								$("#moreoptionform").attr("action",$(this).attr("href")).submit();			
												
							 } 
							 
							return false;
							
							});
						}); 
						
						
						
						$(function(){
							$("#updateMore").click(function(){		
								//$('input[type=checkbox]').prop('checked')
								
								var value =$("#aaa option:selected").text();  						
								$('#updateMore').attr('href','${ctp}/updateMore/'+value.toString()+'?type=${map}&keyw=${keyw}'); 
								$("#moreoptionform").attr("action",$(this).attr("href")).submit();
								return false;
								});
							});

					
						

						
				</script>
			
				<!-- end -->
			</div>
		</div>
		

	</div>
</body>
</html>