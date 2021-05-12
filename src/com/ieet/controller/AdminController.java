package com.ieet.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ieet.pojo.Personnel;
import com.ieet.service.AdminService;

import com.wzw.ssm.util.PageUtil;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	private PageInfo<Personnel> pageInfo=new PageInfo<>(null,5);
	
	
	@RequestMapping(value="/admin/{pageNum}")
	public String toselectInfo(@PathVariable("pageNum")Integer pageNum ,Map<String,Object> map , HttpServletRequest request) {
		
		PageHelper.startPage(pageNum,5);
		List<Personnel> allpersons = adminService.getAllpersons();
		pageInfo = new PageInfo<>(allpersons,5);
		String page = PageUtil.getPageInfo(pageInfo, request,"admin");
		
		map.put("personlist", allpersons);
		map.put("page",page);
		
		List<Personnel> allTeam = adminService.getAllTeam();
		map.put("allTeam", allTeam);
		
		if(pageInfo.getPageNum()>0) {
			System.out.println("testpage: "+pageInfo.getPageNum());
		}
		return "adminindex";
	}
	
	@RequestMapping(value="/toaddperson")
	public String toaddperson(Model model) {
		
		List<Personnel> allpersons = adminService.getAllpersons();
		model.addAttribute("personlist", allpersons);
		model.addAttribute("Personnel",new Personnel());			
		return "add";
	}
	/**
	 * 	添加人员
	 */
	@RequestMapping(value="/addPost",method=RequestMethod.POST)
	public String addPost(Personnel personnel) {
		System.out.println(personnel.getType());
		int i = adminService.save(personnel);
		
		if(i>0) {
			return "forward:/admin/"+pageInfo.getPages();
		}else {
			return "add";
		}
	}
	
	/**
	 * 修改人员信息
	 */
	@RequestMapping(value="/personEidt/{id}" , method=RequestMethod.GET)
	public String personEidt(Personnel personnel,@PathVariable("id")int id,Model model) {
	
		Personnel person = adminService.getpersonbyid(id);
		model.addAttribute("Personnel",person);	
			return "edit";
			
			
	}
	
	@RequestMapping(value="/personUpdate/{id}" , method=RequestMethod.PUT)
	public String personUpdate(Personnel personnel,@PathVariable("id")int id,Model model) {
		
	
		System.out.println("personnel: "+personnel);		
		adminService.update(personnel);
		
			return "redirect:/admin/"+pageInfo.getPageNum();				
	}
	
	@RequestMapping(value="/personEidt/{id}",method=RequestMethod.DELETE)
	public String deletePerson(Personnel personnel,@PathVariable("id")int id,Model model) {
		
			adminService.delete(id);
			return "forward:/admin/"+pageInfo.getPageNum();
	}
	
	
	
	@RequestMapping(value="/deleteMore")
	public String deletePerson(String check,Model model) {
		
	System.out.println(check);	
	adminService.deletemore(check);
	
			return "forward:/admin/"+pageInfo.getPageNum();
	}
	
	@RequestMapping(value="/adminss/{type}/{pageNum}")
	public String selectteacher(
			@PathVariable("type")String type,			
			Map<String,Object> map,
			@PathVariable("pageNum")int pageNum,
			 HttpServletRequest request) {
		System.out.println(type);
		String str=type;
		if(type.equals("teacher")) {
			type="教师";
			map.put("checkedT", "checked");
		}else {
			type="审核人员";
			map.put("checkedA", "checked");
		}
		PageHelper.startPage(pageNum,5);
		
			List<Personnel> list = adminService.selectbytype(type);
			pageInfo = new PageInfo<>(list,5);
			String page = PageUtil.getPageInfo(pageInfo, request,"adminss/"+str);
			
			map.put("personlist", list);
			map.put("page", page);
		return "adminindex";		
	}
	
	
	@RequestMapping(value="/SearchAdmin")
	public String SearchAdmin(
			
			String keywords,
			Map<String,Object> map,
			Personnel personnel,
			 HttpServletRequest request,
			 HttpSession session
			) {		
		List<Personnel> list;
		List<Personnel> allTeam = adminService.getAllTeam();
		map.put("allTeam", allTeam);
		
		if(keywords!=null && keywords!="") {
			if(Pattern.compile("[0-9]+").matcher(keywords).matches()){
				int parseInt = Integer.parseInt(keywords);
				personnel.setPid(parseInt);
				list = adminService.selectbykeywords(personnel);
				map.put("personlist", list);
			}else{			
				
				personnel.setName(keywords);			
				System.out.println(personnel);
				list = adminService.selectbykeywords(personnel);	
					if(list.isEmpty()) {
					personnel.setName(null);
					personnel.setTeam(keywords);	
					System.out.println(personnel);
				    list = adminService.selectbykeywords(personnel);	
					}			
				map.put("personlist", list);
				map.put("keywords",keywords);	
				session.setAttribute("PSHlist", list);
				session.setAttribute("KEYwords", keywords);
			}
			return "adminindex";		
		}else {
			return "forward:/admin/1";
		}		
	}
	
	@RequestMapping(value="/updateMore/{team}")
	public String updateMore(String check,Model model,
			@PathVariable(value="team")String team,
			 HttpSession session
			
			) throws Exception {
			if(session.getAttribute("PSHlist")!=null) {
				List attribute = (List) session.getAttribute("PSHlist");
				System.out.println("attribute-"+attribute);
			}
		String teamname = new String(team.getBytes("iso-8859-1"),"utf-8");
		System.out.println(teamname);
		System.out.println(check);
		List<Personnel> list = adminService.selectlotbyid(check);
		List<Personnel> ls = new ArrayList<>();
		for (Personnel p : list) {
			Personnel personnel = new Personnel(p.getPid(),p.getName(),p.getType(),teamname,p.getIdname(),p.getPword());			
			ls.add(personnel);
		}
		System.out.println(ls.toString());
		adminService.MoreUpdate(ls);
		
		return "forward:/admin/"+pageInfo.getPageNum();
		
	}
	
	@ModelAttribute
	public void myModelAttribute(
	@RequestParam(value="id",required=false)Integer id,Model model) {
		
		
		
		if(id != null) {
			System.out.println("myModelAttribute--id："+id);
			Personnel personnel = adminService.getpersonbyid(id);
			model.addAttribute("personnel",personnel);
		}
	}
	
}
