package com.ieet.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ieet.pojo.Personnel;
import com.ieet.service.PersonnelService;
import com.sun.javafx.collections.MappingChange.Map;

@Controller
//@RequestMapping("personnel")
public class PersonnelController {
	@Autowired
	PersonnelService personnelService;
	
	@RequestMapping(value="/personnelAll",method=RequestMethod.GET)
	public String queryAll(Model model) {
		//students是包含了查询出来的学生信息的集合
		model.addAttribute("personnels", personnelService.queryAll());
		return "personnelInfo";
	}
	
//	@RequestMapping(value="/edit",method=RequestMethod.POST)
//	public String update(Personnel personnel,Model model) {
//		personnelService.update(personnel);
//		return "editdone";
//	}
	
	@RequestMapping(value="/personnelAll1",method=RequestMethod.GET)
	public String queryAll1(Model model) {
		//students是包含了查询出来的学生信息的集合
		model.addAttribute("personnels", personnelService.queryAll1());
		return "NewFile";
	}
	
	
//	@RequestMapping("/update")
//    public String update(Personnel personnel,HttpServletRequest request,Model model){
 //       if(personnelService.update(personnel)!=0)
 //       {
 //       	personnel=personnelService.findBypid(personnel.getPid());
 //           request.setAttribute("personnel",personnel);
 //           model.addAttribute("personnel",personnel);
 //           return "personnel/personnelAll1";
//        }
//        else {
 //           return "/error";                    
 //       }
	
	@RequestMapping(value="update/{pid}",method=RequestMethod.POST)
	public String update(@PathVariable("pid") int pid,HttpServletRequest request,Model model) {
		System.out.println(pid);
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String team = request.getParameter("team");
		String idname = request.getParameter("idname");
		String pword = request.getParameter("pword");
		
		//int age = Integer.parseInt(request.getParameter("age"));
		Personnel personnel=new Personnel(pid,name,type,team,idname,pword);
		System.out.println(personnel);
		personnelService.update(personnel);
		//model.addAttribute("personnels", personnelService.queryAll1());
		//return "redirect:editdone" ;
		model.addAttribute("personnels", personnelService.queryAll1());
		return "editdone" ;
	}
	
	
	
 //   @RequestMapping("/getpersonnel")
 //   public String getpersonnel(int pid,HttpServletRequest request,Model model){
 //       request.setAttribute("personnel",personnelService.findBypid(pid));
 //       model.addAttribute("personnel",personnelService.findBypid(pid));
 //       return "edit";
 //   }
	
	@RequestMapping("/queryByPid/{pid}")
	public String queryStudentByNo(@PathVariable("pid") int pid,Model model) {
		Personnel personnel = personnelService.findBypid(pid);
		model.addAttribute("personnel",personnelService.findBypid(pid));
		return "edit_1" ;
	} 
//	@RequestMapping(value="/edit", method=RequestMethod.GET)
//	public String editUser(int param,String team,Model model,int pid){
//		Personnel personnel=new Personnel();
//			if(param == 0){
//				personnel=personnelService.findBypid(pid);
//				model.addAttribute("personnel",personnel);
//				return "edit";
//			}else if(param == 1){
//				personnel.setPid(pid+"");
//				personnel.setTeam(team);
//				Boolean a = personnelService.update(personnel);
//				System.out.println(a);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "editdone";
//	}
	

	
	
	}



