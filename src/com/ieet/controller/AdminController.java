package com.ieet.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ieet.pojo.Base;
import com.ieet.pojo.Personnel;
import com.ieet.service.AdminService;
import com.ieet.service.BaseService;
import com.ieet.util.PageUtil;
import com.ieet.util.PersonnelListener;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.support.ExcelTypeEnum;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	BaseService baseService;
	
	private PageInfo<Personnel> pageInfo = new PageInfo<>(null, 5);

	@RequestMapping(value = "/admin/{pageNum}")
	public String toselectInfo(@PathVariable("pageNum") Integer pageNum, Map<String, Object> map,
			HttpServletRequest request) {

		PageHelper.startPage(pageNum, 5);
		List<Personnel> allpersons = adminService.getAllpersons();
		pageInfo = new PageInfo<>(allpersons, 5);
		String page = PageUtil.getPageInfo(pageInfo, request, "admin");

		map.put("personlist", allpersons);
		map.put("page", page);

		/*
		 * List<Personnel> allTeam = adminService.getAllTeam(); map.put("allTeam",
		 * allTeam);
		 */

		if (pageInfo.getPageNum() > 0) {
			System.out.println("testpage: " + pageInfo.getPageNum());
		}
		return "adminindex";
	}

	@RequestMapping(value = "/toaddperson")
	public String toaddperson(Model model) {

		List<Personnel> allpersons = adminService.getAllpersons();
		model.addAttribute("personlist", allpersons);
		model.addAttribute("Personnel", new Personnel());
		return "add";
	}

	/**
	 * 添加人员
	 */
	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public String addPost(Personnel personnel) {
		System.out.println(personnel.getType());
		int i = adminService.save(personnel);

		if (i > 0) {
			return "forward:/admin/" + pageInfo.getPages();
		} else {
			return "add";
		}
	}

	/**
	 * 修改人员信息
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/personEidt/{id}", method = RequestMethod.GET)
	public String personEidt(Personnel personnel, @PathVariable("id") int id,
			@RequestParam(value = "type", required = false, defaultValue = "") String type,
			@RequestParam(value = "keyw", required = false, defaultValue = "") String keyw, Map<String, Object> map,
			Model model) throws Exception {

		/*
		 * 判断是否是在 教师/审核人员 页表中操作
		 */
		if (type != null && type != "") {
			System.out.println("type-" + type);
			map.put("typesss", type);
		}

		if (keyw != null && keyw != "") {
			System.out.println("keyw-" + keyw);
			map.put("keyw", keyw);
		}

		/*
		 * 判断是否是在 模糊查询 页表中操作
		 * 
		 * System.out.println("wzwtestkeyw-"+keyw); if(!keyw.equals("null") &&
		 * !keyw.equals("")) { jumplotsinfopage(map, keyw); return "adminindex"; }
		 */

		Personnel person = adminService.getpersonbyid(id);
		model.addAttribute("Personnel", person);
		return "edit";

	}

	@RequestMapping(value = "/personUpdate", method = RequestMethod.PUT)
	public String personUpdate(Personnel personnel, Model model, String typesss, String keyw, Map<String, Object> map)
			throws Exception {

		adminService.update(personnel);

		/*
		 * 判断是否是在 教师/审核人员 页表中操作
		 */
		System.out.println("typesss-" + typesss);
		if (typesss != null && typesss != "") {
			String type2 = Type(typesss, map);
			return "forward:/adminss/" + type2 + "/" + pageInfo.getPageNum();
		}

		/*
		 * 判断是否是在 模糊查询 页表中操作
		 */
		System.out.println("wzwtestkeyw-" + keyw);
		if (!keyw.equals("null") && !keyw.equals("")) {
			jumplotsinfopage(map, keyw);
			return "adminindex";
		}

		/*
		 * String types=""; if(typesss!=null){
		 * 
		 * System.out.println("types-"+types); if(typesss.equals("教师")) {
		 * 
		 * typesss="teacher"; map.put("checkedT", "checked"); map.put("checkedA", "");
		 * }else {
		 * 
		 * typesss="audit"; map.put("checkedT", ""); map.put("checkedA", "checked");
		 * 
		 * } return "forward:/adminss/"+typesss+"/"+pageInfo.getPageNum(); }
		 */
		return "redirect:/admin/" + pageInfo.getPageNum();
	}

	@RequestMapping(value = "/personEidt/{id}", method = RequestMethod.DELETE)
	public String deletePerson(Personnel personnel, @RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "keyw", required = false, defaultValue = "") String keyw, @PathVariable("id") int id,
			Model model, Map<String, Object> map) throws Exception {
		System.out.println("id:"+id);
		
		//判断外键
		List<Base> baselist = baseService.querybyPid(id);
		System.out.println("wzwtestbaselist:"+baselist.isEmpty());
		if (baselist.isEmpty()) {
			adminService.delete(id);
		}else {
			int base = baselist.get(0).getPid();
			System.out.println(base);
			List<Personnel> list = adminService.selectbyid(base);
			String name = list.get(0).getName();
			map.put("Errormsg", "["+name+"]  此账号有文件已导入，不能删除");
		}
		
		
		System.out.println("type:" + type);
		if (type != null && type != "") {
			String type2 = Type(type, map);
			return "forward:/adminss/" + type2 + "/" + pageInfo.getPageNum();
		}

		/*
		 * 判断是否是在 模糊查询 页表中操作
		 */
		System.out.println("wzwtestkeyw-" + keyw);
		if (!keyw.equals("null") && !keyw.equals("")) {
			jumplotsinfopage(map, keyw);
			return "adminindex";
		}
		/*
		 * 判断是否是在 教师/审核人员 页表中操作
		 */
		if (type != null && type != "") {
			System.out.println("type-" + type);
			map.put("typesss", type);
		}
		
		
		
		return "forward:/admin/" + pageInfo.getPageNum();
	}

	@RequestMapping(value = "/deleteMore")
	public String deletePerson(String check, Model model,
			@RequestParam(value = "keyw", required = false, defaultValue = "") String keyw,
			@RequestParam(value = "type", required = false) String type, Map<String, Object> map) throws Exception {
		List<Personnel> list;
		System.out.println(check);
		if (check != null) {
			List<Base> querybyMorePid = baseService.querybyMorePid(check);
			//System.out.println(querybyMorePid);		
			if (querybyMorePid.isEmpty()) {
				adminService.deletemore(check);
			}else {
				String str="";
				for (Base base : querybyMorePid) {
						
					str+=base.getPid()+",";
					}
				
				str=str.substring(0,str.length()-1);
				System.out.println("str "+str);	
				List<Personnel> list2 = adminService.selectlotbyid(str);
				String msg="";
				for (Personnel personnel : list2) {
					msg+=personnel.getName()+",";
				}
				msg=msg.substring(0,msg.length()-1);
				System.out.println("msg "+msg);	
				map.put("Errormsg", "["+msg+"] 有文件已导入,不能删除");
			}
			
		}

		/*
		 * 判断是否是在 教师 或 审核人员 页表中操作
		 */
		System.out.println("type:" + type);
		if (type != null && type != "") {
			String type2 = Type(type, map);
			return "forward:/adminss/" + type2 + "/" + pageInfo.getPageNum();
		}

		/*
		 * 判断是否是在 模糊查询 页表中操作
		 */
		System.out.println("wzwtestkeyw-" + keyw);
		if (!keyw.equals("null") && !keyw.equals("")) {
			jumplotsinfopage(map, keyw);
			return "adminindex";
		}

		return "forward:/admin/" + pageInfo.getPageNum();
	}

	@RequestMapping(value = "/adminss/{type}/{pageNum}")
	public String selectteacher(@PathVariable("type") String type, Map<String, Object> map,
			@PathVariable("pageNum") int pageNum, HttpServletRequest request) {
		System.out.println(type);
		String str = type;
		if (type.equals("teacher")) {
			type = "教师";
			map.put("checkedT", "checked");
			map.put("map", "教师");
		} else {
			type = "审核人员";
			map.put("checkedA", "checked");
			map.put("map", "审核人员");
		}
		PageHelper.startPage(pageNum, 5);

		List<Personnel> list = adminService.selectbytype(type);
		pageInfo = new PageInfo<>(list, 5);
		String page = PageUtil.getPageInfo(pageInfo, request, "adminss/" + str);

		map.put("personlist", list);
		map.put("page", page);
		return "adminindex";
	}

	@RequestMapping(value = "/SearchAdmin")
	public String SearchAdmin(@RequestParam(value = "keyw", required = false, defaultValue = "") String keyw,
			String keywords, Map<String, Object> map, Personnel personnel, HttpServletRequest request,
			HttpSession session) {
		List<Personnel> list;
		/*
		 * List<Personnel> allTeam = adminService.getAllTeam(); map.put("allTeam",
		 * allTeam);
		 */

		if (keywords != null && keywords != "") {
			if (Pattern.compile("[0-9]+").matcher(keywords).matches()) {
				int parseInt = Integer.parseInt(keywords);
				personnel.setPid(parseInt);
				list = adminService.selectbykeywords(personnel);
				map.put("personlist", list);
			} else {

				personnel.setName(keywords);
				System.out.println(personnel);
				list = adminService.selectbykeywords(personnel);
				if (list.isEmpty()) {
					personnel.setName(null);
					personnel.setTeam(keywords);
					System.out.println(personnel);
					list = adminService.selectbykeywords(personnel);
				}

				System.out.println("keyw-" + keyw);
				map.put("keyw", keywords);
				map.put("personlist", list);
				map.put("keywords", keywords);

			}

			return "adminindex";
		} else {
			return "forward:/admin/1";
		}
	}

	@RequestMapping(value = "/updateMore/{team}")
	public String updateMore(String check, Model model, @PathVariable(value = "team") String team,
			HttpServletRequest request, Map<String, Object> map,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "keyw", required = false, defaultValue = "") String keyw, HttpSession session

	) throws Exception {
		List<Personnel> list;
		String teamname = new String(team.getBytes("iso-8859-1"), "utf-8");
		System.out.println("teamname-" + teamname);
		System.out.println("checked-" + check);

		if (check != null) {// 批量改动team 反正空点~
			list = adminService.selectlotbyid(check);
			List<Personnel> ls = new ArrayList<>();
			for (Personnel p : list) {
				Personnel personnel = new Personnel(p.getPid(), p.getName(), p.getType(), teamname, p.getIdname(),
						p.getPword());
				ls.add(personnel);
			}
			System.out.println("ls- "+ls);
			adminService.MoreUpdate(ls);
		}
		/*
		 * 判断是否是在 教师 或 审核人员 页表中操作
		 */
		System.out.println("type:" + type);
		if (type != null && type != "") {
			String type2 = Type(type, map);
			return "forward:/adminss/" + type2 + "/" + pageInfo.getPageNum();
		}

		/*
		 * 判断是否是在 模糊查询 页表中操作
		 */
		System.out.println("wzwtestkeyw-" + keyw);
		if (!keyw.equals("null") && !keyw.equals("")) {
			jumplotsinfopage(map, keyw);
			return "adminindex";
		}

		return "forward:/admin/" + pageInfo.getPageNum();

	}

	@ModelAttribute
	public void myModelAttribute(@RequestParam(value = "id", required = false) Integer id, Model model,
			Map<String, Object> map

	) {
		List<Personnel> allTeam = adminService.getAllTeam();
		map.put("allTeam", allTeam);
		if (id != null) {
			System.out.println("myModelAttribute--id：" + id);
			Personnel personnel = adminService.getpersonbyid(id);
			model.addAttribute("personnel", personnel);
		}
	}

	public String Type(String type, Map<String, Object> map) throws UnsupportedEncodingException {
		String types = null;

		types = new String(type.getBytes("iso-8859-1"), "utf-8");
		System.out.println("types-" + types);
		if (types.equals("教师")) {
			types = "teacher";
			map.put("checkedT", "checked");
			map.put("map", "教师");
		} else {
			types = "audit";
			map.put("checkedA", "checked");
			map.put("map", "审核人员");
		}
		return types;
	}

	public List<Personnel> jumplotsinfopage(Map<String, Object> map, String keyw) throws UnsupportedEncodingException {
		List<Personnel> list = null;
		String key = new String(keyw.getBytes("iso-8859-1"), "utf-8");
		Personnel personnel = new Personnel();
		if (Pattern.compile("[0-9]+").matcher(key).matches()) {
			// 这个if应该用不了了 因为id主键
		} else {

			personnel.setName(key);
			System.out.println(personnel);
			list = adminService.selectbykeywords(personnel);
			if (list.isEmpty()) {
				personnel.setName(null);
				personnel.setTeam(key);
				System.out.println(personnel);
				list = adminService.selectbykeywords(personnel);

			}
		}
		System.out.println(list);
		map.put("personlist", list);
		map.put("keywords", key);
		map.put("keyw", key);
		return list;
	}

	@RequestMapping(value = "/exportExcel")
	public void exportExcel(HttpServletResponse response,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "keyw", required = false, defaultValue = "") String keyw,
			Map map) throws IOException {
		

		String fileName = "Personnel信息表";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");

		
		List<Personnel> list = adminService.getAllpersons();
		/*
		 * 判断是否是在 教师 或 审核人员 页表中操作
		 */
		System.out.println("type:" + type);
		if (type != null && type != "") {
			String types = new String(type.getBytes("iso-8859-1"), "utf-8");
			System.out.println("types-" + types);
		 list = adminService.selectbytype(types);
		}

		/*
		 * 判断是否是在 模糊查询 页表中操作
		 */
		System.out.println("wzwtestkeyw-" + keyw);
		if (!keyw.equals("null") && !keyw.equals("")) {
			list=	jumplotsinfopage(map, keyw);
			
		}
		
		
		
		EasyExcel.write(response.getOutputStream()).head(Personnel.class).sheet("Personnel信息").doWrite(list);

	}
	@RequestMapping(value = "/exportAllExcel")
	public void exportallExcel(HttpServletResponse response,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "keyw", required = false, defaultValue = "") String keyw,
			Map map) throws IOException {
		

		String fileName = "Personnel信息表";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");		
		List<Personnel> list = adminService.getAllpersons();	
		EasyExcel.write(response.getOutputStream()).head(Personnel.class).sheet("Personnel信息").doWrite(list);

	}
	@RequestMapping(value = "/exportExcelModel")
	public void exportExcelModel(HttpServletResponse response) throws IOException {
		// List<Personnel> list = adminService.getAllpersons();
		ArrayList<Personnel> list = new ArrayList<Personnel>();
		Personnel personnel = new Personnel();
		personnel.setPid(0);
		personnel.setName("wzw");
		personnel.setType("教师");
		personnel.setTeam("xxx");
		personnel.setIdname("xxx");
		personnel.setPword("xxxxx");
		list.add(personnel);
		String fileName = "Personnel信息表";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");

		
		
		
		
		
		EasyExcel.write(response.getOutputStream()).head(Personnel.class).sheet("Personnel信息").doWrite(list);

	}

	@RequestMapping(value = "/importExcelpage")
	public String importExcelpage(Map<String, Object> map) {
		map.put("display", "none");
		return "importExcel";
	}

	
	@Autowired
	PersonnelListener personnelListener;
	
	@RequestMapping(value="/read")
    public String readExcel(
    		MultipartFile uploadFile
    		, Map<String, Object> map,
    		Model model
    		) {
	        ExcelReader excelReader = null;
	        try {
	            excelReader = EasyExcel.read(uploadFile.getInputStream(), Personnel.class, personnelListener).build();
	            ReadSheet readSheet = EasyExcel.readSheet(0).build();
	            excelReader.read(readSheet);
	        } catch (Exception e ) {						
				map.put("importExcelMsg", "未选择正确的Excel文件");	
				return "importExcel";		
			}finally {
	            if (excelReader != null) {
	                // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
	                excelReader.finish();
	                try {
						uploadFile.getInputStream().close();	
					} catch (IOException e) {						
						e.printStackTrace();
					}
	            }
	            }
		
		
		/*try {	     	
			EasyExcel.read(uploadFile.getInputStream(), Personnel.class, personnelListener).sheet().doRead();		  		 
		}catch (Exception e ) {						
			map.put("importExcelMsg", "未选择正确的Excel文件");	
			return "importExcel";		
		}*/
		 Map<String, Object> map2= personnelListener.map;
		 List<Personnel>  listwzw = (List) map2.get("listwzw");
		 System.out.println(listwzw);	 
		 if (listwzw!=null) {
			 
			 map.put("display", "block");
			model.addAttribute("listwzw", listwzw);
			model.addAttribute("xxx", "有重复idname 或者  不符合条件的列‘如下’---导入失败，请修改"); 			 
			 return "importExcel";
		}else {
			map.put("display", "none");
		}
		 
		 	
        return "adminindex";
    }
	
	
	

	@RequestMapping(value = "/exitadmin")
	public String exitt() {
		return "../login";
	}
	@RequestMapping(value = "/exitimportE")
	public String exitimportE() {
		return "adminindex";
	}
	
	
	@RequestMapping(value = "/OverWarite")
	public String OverWarite(
			String[] listwzw,Personnel personnel
			) {	
		
			System.out.println(listwzw);
		
			adminService.overwrite(listwzw);
			
		return "importExcel";
	}
	
}
