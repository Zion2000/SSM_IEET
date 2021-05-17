package com.ieet.util;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.fastjson.JSON;
import com.ieet.dao.AdminDao;
import com.ieet.pojo.Personnel;
import com.ieet.service.AdminService;

// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
@Component
@Scope("prototype")
public class PersonnelListener extends AnalysisEventListener<Personnel> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonnelListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 30;
    List<Personnel> list = new ArrayList<Personnel>();
    public Map<String,Object> map = new HashMap<>();
    
    
    @Autowired
    private AdminService adminService;
    
  
   
    
    @Override
    public void invoke(Personnel data, AnalysisContext context) {   	
    	System.out.println("解析到一条数据:");
  	
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }
    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
       
        System.out.println("所有数据解析完成！");
    }
    /**
     * 加上存储数据库
     */
    private void saveData() {       
        System.out.println("{}条数据，开始存储数据库！");
        List listwzw = adminService.readExcel(list);  
       
        map.put("listwzw", listwzw);
        System.out.println("存储数据库成功！");
      //结束了再清理一次
        list.clear();
    }
}