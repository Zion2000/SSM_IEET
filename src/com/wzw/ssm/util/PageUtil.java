package com.wzw.ssm.util;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.ieet.pojo.Personnel;


public class PageUtil {

	
	/*
	 * 首页 上一页 1 2 3 4 5 下一页
	 * 
	 * */
public static String getPageInfo(
		PageInfo<Personnel> pageInfo,
		HttpServletRequest request ,
		String str){
	
	String path = request.getContextPath() + "/";//根路径
	StringBuilder builder = new StringBuilder();
	
	//拼接首页
	builder.append("<a href='"+path+""+str+"/1'>首页</a>");
	
	builder.append("&nbsp;");	builder.append("&nbsp;");
	//拼接上一页
	if(pageInfo.isHasPreviousPage()){
		builder.append("<a href='"+path+""+str+"/"+pageInfo.getPrePage()+"'>上一页</a>");
	}else{
		builder.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	}
	builder.append("&nbsp;");	builder.append("&nbsp;");
	//拼接页码
	int[] nums = pageInfo.getNavigatepageNums();
	System.out.println(nums.length);
	for (int i : nums) {
		if(i == pageInfo.getPageNum()){
		builder.append("<a style='color:red;' href='"+path+""+str+"/"+i+"'>"+i+"</a>");
		}else{
			builder.append("<a  href='"+path+""+str+"/"+i+"'>"+i+"</a>");
			
		}
		builder.append("&nbsp;");
	}
	builder.append("&nbsp;");	builder.append("&nbsp;");
	
	//下一页
	if(pageInfo.isHasNextPage()){
		builder.append("<a href='"+path+""+str+"/"+pageInfo.getNextPage()+"'>下一页</a>");
	}else{
		builder.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	}
	builder.append("&nbsp;");	builder.append("&nbsp;");
	//拼接尾页
	builder.append("<a href='"+path+""+str+"/"+pageInfo.getPages()+"'>尾页</a>");
	
	return builder.toString();
	
}

}
