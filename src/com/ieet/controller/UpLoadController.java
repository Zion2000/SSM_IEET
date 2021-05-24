package com.ieet.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ieet.pojo.UpLoad;
import com.ieet.service.UpLoadService;

@Controller
public class UpLoadController {
	
	@Autowired
	UpLoadService uploadService;

	
	
	@RequestMapping("/fileup")
	public String fileupload(
			MultipartFile file,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="pidds" , required=false , defaultValue = "w") int pidds,
			Model model) throws IllegalStateException, IOException {
		System.out.println("pidds-"+pidds);
		System.out.println("fileupload");
		
		ModelAndView mv = new ModelAndView("message");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());

        // uploads文件夹位置
        String rootPath = request.getSession().getServletContext().getRealPath("WEB-INF/upload");
        // 原始名称
        String originalFileName = file.getOriginalFilename();
        // 新文件名
        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        // 创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

        // 新文件
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        // 判断目标文件所在目录是否存在
        if( !newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        System.out.println("newFile："+newFile);
        // 将内存中的数据写入磁盘
        file.transferTo(newFile);
        // 完整的url
        
       
       String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       String format = df.format(new Date());// new Date()为获取当前系统时间
       mv.addObject("path", fileUrl);
       UpLoad base = new UpLoad(
    		   0,
    		   "0",
    		   originalFileName,
    		   format,
    		   fileUrl,
    		   pidds
    		   );
       System.out.println(base);
       uploadService.InsertFile(base);
       
       System.out.println("test");
       
       List<UpLoad> base2 = uploadService.FindBypid(pidds);
		System.out.println(base2);
		model.addAttribute("bases",base2);
		model.addAttribute("pidds",pidds);
       return "upload";
	}
	
	@RequestMapping(value="upload")
	public String a() {
		return null;
	}
	
}
