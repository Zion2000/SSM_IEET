package com.ieet.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadController {
	@RequestMapping("/filedown")
	public void download(String fileName,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		//获得文件下载的路径
		String root=request.getSession().getServletContext().getRealPath("/");
		//根据下载路径和文件名实例化File类的对象
		File file=new File(root,fileName);
		//将文件内容转成字节数组
		byte[] data=FileUtils.readFileToByteArray(file);
		//设置response消息头
		response.setContentType("application/x-msdownload;");
		//处理文件名的中文名问题
		String fn=new String(file.getName().getBytes("UTF-8"),"ISO8859-1");
		response.setHeader("Content-disposition", "attachment;filename="+fn);
		response.setHeader("Content-Length", String.valueOf(file.length()));
		
		//读取文件内容
		response.getOutputStream().write(data);
	}
}
