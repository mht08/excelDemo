package com.glmht.excelDemo.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.glmht.excelDemo.util.ImportExcel;
 
/**
 * Created by YYBJ on 2018/7/16.
 * ZCL
 */
@Controller
@RequestMapping("/controller")
public class FileUploadController {
	
     //这个方法是进行页面跳转的 jsp页面在WEB-INF下不能直接访问
    @RequestMapping(value = "/intoload")
    public ModelAndView intoload(HttpServletRequest request, HttpServletResponse response)throws  Exception{
        System.out.println("111111111111111");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/uploadForm");
        return mv;
    }
    //上传文件会自动绑定到MultipartFile中
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(description);
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            return "1";
        } else {
            return "0";
        }
    }
    
    @RequestMapping("/staff/import")
    @ResponseBody
    public String importExcel(@RequestParam MultipartFile mFile){
        try {
            String fileName = mFile.getOriginalFilename();
            // 获取上传文件的输入流
            InputStream inputStream = mFile.getInputStream();
            // 调用工具类中方法，读取excel文件中数据
            List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);
            Map<String,List<String>> fristMap = new HashMap<String,List<String>>();
            
            // 记录二级目录对应生成方式
            Map<String,String> sencondKeyDetail = new HashMap<String,String>();
            
            for (Map<String, Object> map : sourceList) {
            	String firstKey = map.get("一级类目").toString();
            	String sencondKey = map.get("二级类目").toString();
            	
            	if(fristMap.containsKey(firstKey)) {
					List<String> list = fristMap.get(firstKey);
					list.add(sencondKey);
					fristMap.put(firstKey, list);
				} else {
					List<String> list = new ArrayList<String>();
					list.add(sencondKey);
					fristMap.put(firstKey, list);
				}
            	if(!sencondKeyDetail.containsKey(firstKey+"_"+sencondKey)) {
            		sencondKeyDetail.put(firstKey+"_"+sencondKey, map.get("生成方式").toString());
            	}
			}
            
            int fNumber = 1;
            for(Map.Entry<String,List<String>> entry:fristMap.entrySet()) {
            	// 一级目录
            	System.out.println("INSERT INTO data_tag_catalog (name,number,number_type,parent_number,parent_numbers,sort,level,creat_by,update_by) " + 
        			"VALUES ('"+entry.getKey()+"','"+fNumber+"',2,0,0,"+fNumber+",1,1,1);");
            	int sNumber = 1;
            	List<String> list = entry.getValue();
            	for(String s: list) {
            		
					String numberType = "2";
					if (sencondKeyDetail.get(entry.getKey()+"_"+s).equals("表类型标签")) {
						numberType = "1";
					}
            		System.out.println("INSERT INTO data_tag_catalog (name,number,number_type,parent_number,parent_numbers,sort,level,creat_by,update_by) " + 
                			"VALUES ('"+s+"','"+fNumber+"."+sNumber+"',"+numberType+","+fNumber+",0,"+fNumber+","+sNumber+",1,1,1);");
            		sNumber++;
            	}
            	fNumber++;
            }
            

            return "1";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "0";
        }

    }
 
}
