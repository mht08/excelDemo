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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.glmht.excelDemo.entity.DataRinseTag;
import com.glmht.excelDemo.entity.DataTag;
import com.glmht.excelDemo.entity.DataTagCatalog;
import com.glmht.excelDemo.entity.DataTagHierarchy;
import com.glmht.excelDemo.service.DataRinseTagService;
import com.glmht.excelDemo.service.DataTagCatalogService;
import com.glmht.excelDemo.service.DataTagHierarchyService;
import com.glmht.excelDemo.service.DataTagService;
import com.glmht.excelDemo.util.ImportExcel;

/**
 * Created by YYBJ on 2018/7/16. ZCL
 */
@Controller
@RequestMapping("/controller")
public class FileUploadController {

	@Autowired
	private DataTagCatalogService dataTagCatalogService;

	@Autowired
	private DataTagService dataTagService;
	@Autowired
	private DataTagHierarchyService dataTagHierarchyService;
	@Autowired
	private DataRinseTagService dataRinseTagService;

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
			Map<String, List<Map<String, Object>>> thereKeyDetail = new HashMap<String, List<Map<String, Object>>>();
			Map<String, List<Map<String, Object>>> thereKeyDetail1 = new HashMap<String, List<Map<String, Object>>>();
			Map<String, String> yMap = new HashMap<String, String>();
			yMap.put("样式一", "Y0000001");
			yMap.put("样式二", "Y0000002");
			yMap.put("样式三", "Y0000003");

			Map<String, String> onlineStatusMap = new HashMap<String, String>();
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

			}
			int dataSourceId = 3;
			// 获取一级目录的最大值
			int fNumber = dataTagCatalogService.maxNumber("0");
			// 如果最大值为0设值为1
			if (fNumber == 0) {
				fNumber = 1;
				// 如果不为0再原有的值++
			} else {
				fNumber++;
			}
			Map<String, String> newSencondNumberMap = new HashMap<String, String>();
			for (Map.Entry<String, Set<String>> entry : firstMap.entrySet()) {
				DataTagCatalog dataTagCatalog = new DataTagCatalog();
				dataTagCatalog.setName(entry.getKey());
				dataTagCatalog.setNumber(String.valueOf(fNumber));
				dataTagCatalog.setNumberType("2");
				dataTagCatalog.setParentNumber("0");
				dataTagCatalog.setParentNumbers("0");
				dataTagCatalog.setSort(fNumber);
				dataTagCatalog.setLevel(1);
				dataTagCatalog.setCreateBy("1");
				dataTagCatalog.setUpdateBy("1");
				dataTagCatalogService.insertDataTagCatalog(dataTagCatalog);
				Set<String> list = entry.getValue();
				Set<String> ydList = firstMap1.get(entry.getKey());
				int sNumber = 1;
				for (String s : list) {
					String numberType = "1";
					String sencondNumber = fNumber + "." + sNumber;
					System.out.println(
							" insert into data_tag_catalog (name,number,number_type,parent_number,parent_numbers,sort,level,create_by,update_by)"
									+ "VALUES" + "('" + s + "','" + sencondNumber + "','" + numberType + "','" + fNumber
									+ "','0," + fNumber + "','" + sNumber + "',2,1,1);");
					DataTagCatalog dataTagCatalog1 = new DataTagCatalog();
					dataTagCatalog1.setName(s);
					dataTagCatalog1.setNumber(sencondNumber);
					dataTagCatalog1.setNumberType(numberType);
					dataTagCatalog1.setParentNumber(String.valueOf(fNumber));
					dataTagCatalog1.setParentNumbers("0" + "," + String.valueOf(fNumber));
					dataTagCatalog1.setSort(sNumber);
					dataTagCatalog.setLevel(2);
					dataTagCatalog.setCreateBy("1");
					dataTagCatalog.setUpdateBy("1");
					dataTagCatalogService.insertDataTagCatalog(dataTagCatalog1);
					int tNumber = 1;
					List<Map<String, Object>> list2 = thereKeyDetail1.get(entry.getKey() + "_" + s);
					if (list2 != null && list2.size() > 0) {
						for (Map<String, Object> map : list2) {
							String newThreKey = sencondNumber + "." + tNumber;
							String gly = "系统管理员";
							newSencondNumberMap.put(entry.getKey() + "_" + map.get("标签名称").toString() + "_"
									+ map.get("关联数据表").toString(), newThreKey);
							DataTag dataTag = new DataTag();
							dataTag.setName(String.valueOf(map.get("标签名称")));
							dataTag.setNumber(newThreKey);
							dataTag.setFirstCatalog(String.valueOf(fNumber));
							dataTag.setCatalog(sencondNumber);
							dataTag.setTypeCatalog("");
							dataTag.setUpdateMode("1");
							dataTag.setOpenState("1");
							dataTag.setPrincipal(gly);
							dataTag.setPrincipalId("1");
							dataTag.setStatus("1");
							dataTag.setDataSourceId(Long.valueOf(dataSourceId));
							dataTag.setBusinessTable(map.get("关联数据表").toString());
							dataTag.setFieldName(map.get("字段名").toString());
							dataTag.setStateCode(map.get("规则样式标识").toString());
							dataTag.setTagType("1");
							dataTag.setOnlineStatus(map.get("部署状态").toString());
							dataTag.setCreateBy("1");
							dataTag.setUpdateBy("1");
							dataTagService.insertDataTag(dataTag);
							DataTagHierarchy dataTagHierarchy = new DataTagHierarchy();
							dataTagHierarchy.setTagId(dataTag.getId());
							dataTagHierarchy.setUsageScenario(map.get("使用场景").toString());
							dataTagHierarchy.setGenerativeRule(map.get("生成规则").toString());
							dataTagHierarchy.setDataSourceName(map.get("关联数据表").toString());
							dataTagHierarchy.setDataSourceLibrary(map.get("来源数据库").toString());
							dataTagHierarchy.setCreateBy("1");
							dataTagHierarchy.setUpdateBy("1");
							dataTagHierarchyService.insertDataTagHierarchy(dataTagHierarchy);
							tNumber++;
						}
					}
					sNumber++;
				}
				for(String s:ydList) {
					String numberType = "2";
					String sencondNumber = fNumber + "." + sNumber;
					System.out.println(
							" insert into data_tag_catalog (name,number,number_type,parent_number,parent_numbers,sort,level,create_by,update_by)"
									+ "VALUES" + "('" + s + "','" + sencondNumber + "','" + numberType + "','" + fNumber
									+ "','0," + fNumber + "','" + sNumber + "',2,1,1);");
					DataTagCatalog dataTagCatalog2 = new DataTagCatalog();
					dataTagCatalog2.setName(s);
					dataTagCatalog2.setNumber(sencondNumber);
					dataTagCatalog2.setNumberType(numberType);
					dataTagCatalog2.setParentNumber(String.valueOf(fNumber));
					dataTagCatalog2.setParentNumbers("0" + "," + String.valueOf(fNumber));
					dataTagCatalog2.setSort(sNumber);
					dataTagCatalog2.setLevel(2);
					dataTagCatalog2.setCreateBy("1");
					dataTagCatalog2.setUpdateBy("1");
					dataTagCatalogService.insertDataTagCatalog(dataTagCatalog2);
					int tNumber = 1;
					List<Map<String, Object>> list2 = thereKeyDetail.get(entry.getKey() + "_" + s);
					if (list2 != null && list2.size() > 0) {
						for (Map<String, Object> map : list2) {
							String newThreKey = sencondNumber + "." + tNumber;
							String gly = "系统管理员";
							newSencondNumberMap.put(entry.getKey() + "_" + map.get("标签名称").toString() + "_"
									+ map.get("关联数据表").toString(), newThreKey);
							DataTag dataTag1 = new DataTag();
							dataTag1.setName(String.valueOf(map.get("标签名称")));
							dataTag1.setNumber(newThreKey);
							dataTag1.setFirstCatalog(String.valueOf(fNumber));
							dataTag1.setCatalog(sencondNumber);
							dataTag1.setTypeCatalog(newSencondNumberMap.get(entry.getKey() + "_"
									+ map.get("类型").toString() + "_" + map.get("关联数据表").toString()));
							dataTag1.setUpdateMode("1");
							dataTag1.setOpenState("1");
							dataTag1.setPrincipal(gly);
							dataTag1.setPrincipalId("1");
							dataTag1.setStatus("1");
							dataTag1.setDataSourceId(Long.valueOf(dataSourceId));
							dataTag1.setBusinessTable(map.get("关联数据表").toString());
							dataTag1.setFieldName(map.get("字段名").toString());
							dataTag1.setStateCode(map.get("规则样式标识").toString());
							dataTag1.setTagType("1");
							dataTag1.setOnlineStatus(map.get("部署状态").toString());
							dataTag1.setCreateBy("1");
							dataTag1.setUpdateBy("1");
							dataTagService.insertDataTag(dataTag1);
							
							DataRinseTag dataRinseTag = new DataRinseTag();
							dataRinseTag.setName(map.get("标签名称").toString());
							dataRinseTag.setNumber(newThreKey);
							dataRinseTag.setFirstCatalog(String.valueOf(fNumber) );
							dataRinseTag.setCatalog(String.valueOf(sencondNumber));
							dataRinseTag.setTypeCatalog( newSencondNumberMap.get(entry.getKey() + "_" + map.get("类型").toString()
									+ "_" + map.get("关联数据表").toString())
									);
							dataRinseTag.setUpdateMode("1");
							dataRinseTag.setOpenState("1");
							dataRinseTag.setPrincipal(gly);
							dataRinseTag.setPrincipalId("1");
							dataRinseTag.setStatus("1");
							dataRinseTag.setDataSourceId(Long.valueOf(dataSourceId));
							dataRinseTag.setBusinessTable( map.get("关联数据表").toString());
							dataRinseTag.setFieldName(map.get("字段名").toString() );
							dataRinseTag.setStateCode(map.get("规则样式标识").toString());
							dataRinseTag.setTagType("2");
							dataRinseTag.setOnlineStatus( map.get("部署状态").toString());
							dataRinseTag.setUsageScenario(map.get("使用场景").toString() );
							dataRinseTag.setGenerativeRule( map.get("生成规则").toString());
							dataRinseTag.setCreateBy("1");
							dataRinseTag.setUpdateBy("1");
							dataRinseTagService.insertDataRinseTag(dataRinseTag);
							
							DataTagHierarchy dataTagHierarchy1 = new DataTagHierarchy();
							dataTagHierarchy1.setTagId(dataTag1.getId());
							dataTagHierarchy1.setUsageScenario(map.get("使用场景").toString());
							dataTagHierarchy1.setGenerativeRule(map.get("生成规则").toString());
							dataTagHierarchy1.setDataSourceName(map.get("关联数据表").toString());
							dataTagHierarchy1.setDataSourceLibrary(map.get("来源数据库").toString());
							dataTagHierarchy1.setCreateBy("1");
							dataTagHierarchy1.setUpdateBy("1");
							dataTagHierarchyService.insertDataTagHierarchy(dataTagHierarchy1);
							tNumber++;
						}
					}
					sNumber++;
				}
				fNumber++;
			}
			return "1";
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0";
		}
	}

}
