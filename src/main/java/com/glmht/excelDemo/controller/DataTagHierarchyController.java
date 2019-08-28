package com.glmht.excelDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glmht.excelDemo.entity.DataTagHierarchy;
import com.glmht.excelDemo.service.DataTagHierarchyService;



@RestController
@RequestMapping("/DataTagHierarchyController")
public class DataTagHierarchyController {
	@Autowired
	private DataTagHierarchyService dataTagHierarchyService;
	
	@RequestMapping("/selectDataTagHierarchyById")
	public  DataTagHierarchy selectDataTagHierarchyById(Long id) {
		DataTagHierarchy selectDataTagHierarchyById = dataTagHierarchyService.selectDataTagHierarchyById(id);
		return selectDataTagHierarchyById;
	}
	@RequestMapping("/selectDataTagHierarchyALL")
	public List<DataTagHierarchy> selectDataTagHierarchyALL(){
		List<DataTagHierarchy> selectDataTagHierarchyAll = dataTagHierarchyService.selectDataTagHierarchyAll();
		return selectDataTagHierarchyAll;
	}
	@RequestMapping("/insertDataTagHierarchy")
	public int insertDataTagHierarchy(DataTagHierarchy dataTagHierarchy) {
		int insertDataTagHierarchy = dataTagHierarchyService.insertDataTagHierarchy(dataTagHierarchy);
		return insertDataTagHierarchy;
	}


}
