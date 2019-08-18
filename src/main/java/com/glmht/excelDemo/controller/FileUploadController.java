package com.glmht.excelDemo.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
 * Created by YYBJ on 2018/7/16. ZCL
 */
@Controller
@RequestMapping("/controller")
public class FileUploadController {

	// 这个方法是进行页面跳转的 jsp页面在WEB-INF下不能直接访问
	@RequestMapping(value = "/intoload")
	public ModelAndView intoload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("111111111111111");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/uploadForm");
		return mv;
	}

	// 上传文件会自动绑定到MultipartFile中
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(HttpServletRequest request, @RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws Exception {
		System.out.println(description);
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			return "1";
		} else {
			return "0";
		}
	}

	@RequestMapping("/staff/import")
	@ResponseBody
	public String importExcel(@RequestParam MultipartFile mFile) {
		try {
			// mfile.getOriginalFilename()是得到上传时的文件名。
			String fileName = mFile.getOriginalFilename();
			// 获取上传文件的输入流
			InputStream inputStream = mFile.getInputStream();
			// 调用工具类中方法，读取excel文件中数据
			List<Map<String, Object>> sourceList = ImportExcel.readExcel(fileName, inputStream);
			// 一级绑定二级关系
			Map<String, Set<String>> firstMap = new HashMap<String, Set<String>>();
			Map<String, Set<String>> firstMap1 = new HashMap<String, Set<String>>();

			Map<String, String> sencondKeyDetail = new HashMap<String, String>();
			// 二级关系内容的绑定
			Map<String, List<Map<String, Object>>> thereKeyDetail = new HashMap<String, List<Map<String, Object>>>();
			Map<String, List<Map<String, Object>>> thereKeyDetail1 = new HashMap<String, List<Map<String, Object>>>();
			
			Map<String,String> yMap = new HashMap<String,String>();
			yMap.put("样式一", "Y0000001");
			yMap.put("样式二", "Y0000002");
			yMap.put("样式三", "Y0000003");
			
			Map<String,String> onlineStatusMap = new HashMap<String,String>();
			onlineStatusMap.put("待上线", "1");
			onlineStatusMap.put("已上线", "2");
			
			for (Map<String, Object> map : sourceList) {
				String firstKey = map.get("一级类目").toString();
				String sencondKey = map.get("二级类目").toString();
				String key = firstKey + "_" + sencondKey;
				map.put("规则样式标识", yMap.get(map.get("规则样式标识")));
				map.put("部署状态", onlineStatusMap.get(map.get("部署状态")));
				
				if (map.get("生成方式").toString().equals("分析对象")) {
					if (firstMap.containsKey(firstKey)) {
						Set<String> set = firstMap.get(firstKey);
						set.add(sencondKey);
						firstMap.put(firstKey, set);
					} else {
						Set<String> set = new HashSet<String>();
						set.add(sencondKey);
						firstMap.put(firstKey, set);
					}
				} else {
					if (firstMap1.containsKey(firstKey)) {
						Set<String> set = firstMap1.get(firstKey);
						set.add(sencondKey);
						firstMap1.put(firstKey, set);
					} else {
						Set<String> set = new HashSet<String>();
						set.add(sencondKey);
						firstMap1.put(firstKey, set);
					}
				}
				if (map.get("生成方式").toString().equals("分析对象")) {
					if (thereKeyDetail1.containsKey(key)) {
						List<Map<String, Object>> set = thereKeyDetail1.get(key);
						set.add(map);
						thereKeyDetail1.put(key, set);
					} else {
						List<Map<String, Object>> set = new ArrayList<Map<String, Object>>();
						set.add(map);
						thereKeyDetail1.put(key, set);
					}
				} else {
					if (thereKeyDetail.containsKey(key)) {
						List<Map<String, Object>> set = thereKeyDetail.get(key);
						set.add(map);
						thereKeyDetail.put(key, set);
					} else {
						List<Map<String, Object>> set = new ArrayList<Map<String, Object>>();
						set.add(map);
						thereKeyDetail.put(key, set);
					}
				}
				if (!sencondKeyDetail.containsKey(key)) {
					sencondKeyDetail.put(key, map.get("生成方式").toString());
				}
			}
			int dataSourceId = 3;
			int fNumber = 3;
			Map<String, String> newSencondNumberMap = new HashMap<String, String>();

			for (Map.Entry<String, Set<String>> entry : firstMap.entrySet()) {
				// 一级关系
				System.out.println(
						" insert into data_tag_catalog (name,number,number_type,parent_number,parent_numbers,sort,level,create_by,update_by)"
								+ "VALUES" + "('" + entry.getKey() + "','" + fNumber + "',2,0,0,'" + fNumber
								+ "',1,1,1);");
				Set<String> list = entry.getValue();
				Set<String> ydlist = firstMap1.get(entry.getKey());
				int sNumber = 1;
				for (String s : list) {
					String numberType = "1";
					String sencondNumber = fNumber + "." + sNumber;
					// 二级，生产方式分析对象
					System.out.println(
							" insert into data_tag_catalog (name,number,number_type,parent_number,parent_numbers,sort,level,create_by,update_by)"
									+ "VALUES" + "('" + s + "','" + sencondNumber + "','" + numberType + "','" + fNumber
									+ "','0," + fNumber + "','" + sNumber + "',2,1,1);");

					int tNumber = 1;
					List<Map<String, Object>> list2 = thereKeyDetail1.get(entry.getKey() + "_" + s);
					if (list2 != null && list2.size() > 0) {
						for (Map<String, Object> map : list2) {
							String newThreKey = sencondNumber + "." + tNumber;
							String gly = "系统管理员";
							System.out.println(
									"insert into data_tag (name,number,first_catalog,catalog,type_catalog,update_mode,open_state,principal,principal_id,status,data_source_id,business_table,field_name,state_code,tag_type,online_status,create_by,update_by)"
											+ "VALUES" + "('" + map.get("标签名称") + "','" + newThreKey + "',"+fNumber+",'"
											+ sencondNumber + "','',1,1,'" + gly + "',1,1,"+dataSourceId+",'"
											+ map.get("关联数据表").toString() + "','" + map.get("字段名").toString() + "','"
											+ map.get("规则样式标识").toString() + "',1,"+map.get("部署状态").toString()+",1,1);");
							newSencondNumberMap.put(entry.getKey() + "_" + map.get("标签名称").toString() + "_" + map.get("关联数据表").toString(), newThreKey);
							System.out.println(
									"insert into data_tag_hierarchy (tag_id,usage_scenario,generative_rule,data_source_name,data_source_library,create_by,update_by)"
											+ "values" + "((select id from data_tag where number = '" + newThreKey
											+ "' )," + "'" + map.get("使用场景").toString() + "','"
											+ map.get("生成规则").toString() + "','" + map.get("关联数据表").toString()
											+ "','" + map.get("来源数据库").toString() + "',1,1);");
							
							tNumber++;
						}

					}
					sNumber++;
				}
				for (String s : ydlist) {
					String numberType = "2";
					String sencondNumber = fNumber + "." + sNumber;
					// 二级，生产方式分析对象
					System.out.println(
							" insert into data_tag_catalog (name,number,number_type,parent_number,parent_numbers,sort,level,create_by,update_by)"
									+ "VALUES" + "('" + s + "','" + sencondNumber + "','" + numberType + "','" + fNumber
									+ "','0," + fNumber + "','" + sNumber + "',2,1,1);");

					int tNumber = 1;
					List<Map<String, Object>> thereList1 = thereKeyDetail.get(entry.getKey() + "_" + s);
					if (thereList1 != null && thereList1.size() > 0) {
						for (Map<String, Object> map : thereList1) {
							String newThreKey = sencondNumber + "." + tNumber;
							String gly = "系统管理员";
							System.out.println(
									"insert into data_tag (name,number,first_catalog,catalog,type_catalog,update_mode,open_state,principal,principal_id,status,data_source_id,business_table,field_name,state_code,tag_type,online_status,create_by,update_by)"
											+ "VALUES" + "('" + map.get("标签名称") + "','" + newThreKey + "','"+fNumber+"','"
											+ sencondNumber + "','"
											+ newSencondNumberMap.get(entry.getKey() + "_" + map.get("类型").toString()+ "_" + map.get("关联数据表").toString())
											+ "',1,1,'" + gly + "',1,1,"+dataSourceId+",'" + map.get("关联数据表").toString() + "','"
											+ map.get("字段名").toString() + "','" + map.get("规则样式标识").toString()
											+ "',2,"+map.get("部署状态").toString()+",1,1);");
							
							System.out.println(
									"insert into data_rinse_tag (name,number,first_catalog,catalog,type_catalog,update_mode,open_state,principal,"
									+ "principal_id,status,data_source_id,business_table,field_name,state_code,tag_type,online_status,"
									+ " usage_scenario,generative_rule,create_by,update_by)"
											+ "VALUES" + "('" + map.get("标签名称") + "','" + newThreKey + "','"+fNumber+"','"
											+ sencondNumber + "','"
											+ newSencondNumberMap.get(entry.getKey() + "_" + map.get("类型").toString()+ "_" + map.get("关联数据表").toString())
											+ "',1,1,'" + gly + "',1,1,"+dataSourceId+",'" + map.get("关联数据表").toString() + "','"
											+ map.get("字段名").toString() + "','" + map.get("规则样式标识").toString()
											+ "',2,"+map.get("部署状态").toString()+",'"+map.get("使用场景").toString()+"','"+map.get("生成规则").toString()+"',1,1);");
							
							System.out.println(
									"insert into data_tag_hierarchy (tag_id,usage_scenario,generative_rule,data_source_name,data_source_library,create_by,update_by)"
											+ "values" + "((select id from data_tag where number = '" + newThreKey
											+ "' ),'" + map.get("使用场景").toString() + "','" + map.get("生成规则").toString()
											+ "','" + map.get("关联数据表").toString() + "','"
											+ map.get("来源数据库").toString() + "',1,1);");
							tNumber++;
						}

					}
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
