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
		
		/*List<Personnel> allTeam = adminService.getAllTeam();
		map.put("allTeam", allTeam);*/
		
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
	 * @throws Exception 
	 */
	@RequestMapping(value="/personEidt/{id}" , method=RequestMethod.GET)
	public String personEidt(Personnel personnel,
			@PathVariable("id")int id,	
			@RequestParam(value="type",required=false,defaultValue="") String type,	
			@RequestParam(value="keyw",required=false,defaultValue="") String keyw,
			Map<String, Object> map,
			Model model) throws Exception {
		

		/*
		 * 判断是否是在   教师/审核人员    页表中操作
		 * */
		if(type!=null && type!="")		{			
			System.out.println("type-"+type);
			map.put("typesss",type);	
		}
		
		
		if(keyw!=null && keyw!="") {
			System.out.println("keyw-"+keyw);
			map.put("keyw",keyw);	
		}
		
		/*
		 * 判断是否是在 	模糊查询  页表中操作
		 * 
		System.out.println("wzwtestkeyw-"+keyw);	
		if(!keyw.equals("null") && !keyw.equals("")) {
		jumplotsinfopage(map, keyw);
	    return "adminindex";	
		}*/
		
		
		Personnel person = adminService.getpersonbyid(id);
		model.addAttribute("Personnel",person);	
			return "edit";
			
			
	}
	
	@RequestMapping(value="/personUpdate" , method=RequestMethod.PUT)
	public String personUpdate(
			Personnel personnel 
			,Model model,
			String typesss,
			String keyw,
			Map<String, Object> map
			) throws Exception {
		
		
		adminService.update(personnel);
		
		/*
		 * 判断是否是在   教师/审核人员    页表中操作
		 * */
		System.out.println("typesss-"+typesss);
		if(typesss!=null && typesss!="")		{
			String type2 = Type(typesss,map);				
			return "forward:/adminss/"+type2+"/"+pageInfo.getPageNum();
		}
		
		/*
		 * 判断是否是在 	模糊查询  页表中操作
		 * */
		System.out.println("wzwtestkeyw-"+keyw);	
		if(!keyw.equals("null") && !keyw.equals("")) {
		jumplotsinfopage(map, keyw);
	    return "adminindex";	
		}
		
		/*String types="";
		if(typesss!=null){
			
			System.out.println("types-"+types);
			if(typesss.equals("教师")) {
			
				typesss="teacher";
				map.put("checkedT", "checked");
				map.put("checkedA", "");
			}else {
				
				typesss="audit";
				map.put("checkedT", "");
				map.put("checkedA", "checked");
				
			}
			return "forward:/adminss/"+typesss+"/"+pageInfo.getPageNum();
		}*/
			return "redirect:/admin/"+pageInfo.getPageNum();				
	}
	
	@RequestMapping(value="/personEidt/{id}",method=RequestMethod.DELETE)
	public String deletePerson(Personnel personnel,
			@RequestParam(value="type",required=false) String type,
			@RequestParam(value="keyw",required=false,defaultValue="") String keyw,
			@PathVariable("id")int id,Model model,
			Map<String, Object> map
			) throws Exception {
		
			adminService.delete(id);
						
				System.out.println("type:"+type);
				if(type!=null && type!="")		{
					String type2 = Type(type,map);				
					return "forward:/adminss/"+type2+"/"+pageInfo.getPageNum();
				}
				
				/*
				 * 判断是否是在 	模糊查询  页表中操作
				 * */
				System.out.println("wzwtestkeyw-"+keyw);	
				if(!keyw.equals("null") && !keyw.equals("")) {
				jumplotsinfopage(map, keyw);
			    return "adminindex";	
				}
				/*
				 * 判断是否是在   教师/审核人员    页表中操作
				 * */
				if(type!=null && type!="")		{			
					System.out.println("type-"+type);
					map.put("typesss",type);	
				}
								
			return "forward:/admin/"+pageInfo.getPageNum();
	}
	
	
	
	@RequestMapping(value="/deleteMore")
	public String deletePerson(String check,Model model,
			@RequestParam(value="keyw",required=false,defaultValue="") String keyw,
			@RequestParam(value="type",required=false) String type,
			Map<String,Object> map
			) throws Exception {
	List<Personnel> list;
	System.out.println(check);
	if(check!=null) {
	adminService.deletemore(check);
	}
	
	/*
	 * 判断是否是在 	教师 或 审核人员  页表中操作
	 * */
	System.out.println("type:"+type);
	if(type!=null && type!="")		{
		String type2 = Type(type,map);				
		return "forward:/adminss/"+type2+"/"+pageInfo.getPageNum();
	}
	
	/*
	 * 判断是否是在 	模糊查询  页表中操作
	 * */
	System.out.println("wzwtestkeyw-"+keyw);	
	if(!keyw.equals("null") && !keyw.equals("")) {
	jumplotsinfopage(map, keyw);
    return "adminindex";	
	}
	
	
	
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
			map.put("map", "教师");
		}else {
			type="审核人员";
			map.put("checkedA", "checked");
			map.put("map", "审核人员");
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
			@RequestParam(value="keyw",required=false,defaultValue="") String keyw,
			String keywords,
			Map<String,Object> map,
			Personnel personnel,
			HttpServletRequest request,
			HttpSession session
			) {		
		List<Personnel> list;
		/*List<Personnel> allTeam = adminService.getAllTeam();
		map.put("allTeam", allTeam);*/
		
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
				
				System.out.println("keyw-"+keyw);
				map.put("keyw", keywords);
				map.put("personlist", list);
				map.put("keywords",keywords);	
					
			}
			
			
			
			return "adminindex";		
		}else {
			return "forward:/admin/1";
		}		
	}
	
	@RequestMapping(value="/updateMore/{team}")
	public String updateMore(String check,Model model,
			@PathVariable(value="team")String team,
			HttpServletRequest request,
			Map<String,Object> map,
			@RequestParam(value="type",required=false) String type,
			@RequestParam(value="keyw",required=false,defaultValue="") String keyw,
			 HttpSession session
			
			) throws Exception {
		List<Personnel> list;
		String teamname = new String(team.getBytes("iso-8859-1"),"utf-8");
		System.out.println("teamname-"+teamname);
		System.out.println("checked-"+check);
	
		if(check!=null) {//批量改动team 反正空点~
			list = adminService.selectlotbyid(check);
			List<Personnel> ls = new ArrayList<>();
				for (Personnel p : list) {
					Personnel personnel = new Personnel(p.getPid(),p.getName(),p.getType(),teamname,p.getIdname(),p.getPword());			
					ls.add(personnel);
				}
			adminService.MoreUpdate(ls);
		}
		/*
		 * 判断是否是在 	教师 或 审核人员  页表中操作
		 * */
		System.out.println("type:"+type);
		if(type!=null && type!="")		{
			String type2 = Type(type,map);				
			return "forward:/adminss/"+type2+"/"+pageInfo.getPageNum();
		}
		
		/*
		 * 判断是否是在 	模糊查询  页表中操作
		 * */
		System.out.println("wzwtestkeyw-"+keyw);	
		if(!keyw.equals("null") && !keyw.equals("")) {
		jumplotsinfopage(map, keyw);
	    return "adminindex";	
		}
		
		
		return "forward:/admin/"+pageInfo.getPageNum();
		
	}

	
	
	@ModelAttribute
	public void myModelAttribute(
	@RequestParam(value="id",required=false)Integer id,Model model,
	Map<String,Object> map

			) {	
		List<Personnel> allTeam = adminService.getAllTeam();
		map.put("allTeam", allTeam);
		if(id != null) {
			System.out.println("myModelAttribute--id："+id);
			Personnel personnel = adminService.getpersonbyid(id);
			model.addAttribute("personnel",personnel);
		}
	}
	
	public String Type(String type,Map<String, Object> map) throws UnsupportedEncodingException {
		String types=null;
		
				types = new String(type.getBytes("iso-8859-1"),"utf-8");
				System.out.println("types-"+types);
				if(types.equals("教师")) {				
					types="teacher";		map.put("checkedT", "checked");		 map.put("map", "教师");		
				}else {					
					types="audit";			map.put("checkedA", "checked");		 map.put("map", "审核人员");			
				}				
			return types;
	}
	
	public void jumplotsinfopage(Map<String, Object> map, String keyw) throws UnsupportedEncodingException {
		List<Personnel> list = null;
		String key = new String(keyw.getBytes("iso-8859-1"),"utf-8");
		Personnel personnel =new Personnel();
		if(Pattern.compile("[0-9]+").matcher(key).matches()){
					//这个if应该用不了了  因为id主键		
		}else{
				
			personnel.setName(key);			
			System.out.println(personnel);
			list = adminService.selectbykeywords(personnel);	
			if(list.isEmpty()) {
				personnel.setName(null);
				personnel.setTeam(key);
				System.out.println(personnel);
			    list = adminService.selectbykeywords(personnel);
				
			}		
		}
		
		
	    map.put("personlist", list);
		map.put("keywords",key);
		map.put("keyw", key);
	}
	
	@RequestMapping(value="/exit")
	public String exit() {
		return "../login";
		
	}
	
	
}
