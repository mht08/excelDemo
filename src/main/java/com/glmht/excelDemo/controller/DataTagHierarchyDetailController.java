package com.glmht.excelDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glmht.excelDemo.entity.DataTagHierarchyDetail;
import com.glmht.excelDemo.service.DataTagHierarchyDetailService;


@RestController
@RequestMapping("/DataTagHierarchyDetailController")
public class DataTagHierarchyDetailController {
	@Autowired
	private DataTagHierarchyDetailService dataTagHierarchyDetailService;
	
	@RequestMapping("/selectDataTagHierarchyDetailById")
	public  DataTagHierarchyDetail selectDataTagHierarchyDetailById(Long id) {
		DataTagHierarchyDetail selectDataTagHierarchyDetailById = dataTagHierarchyDetailService.selectDataTagHierarchyDetailById(id);
		return selectDataTagHierarchyDetailById;
	}
	@RequestMapping("/selectDataTagHierarchyDetailALL")
	public List<DataTagHierarchyDetail> selectDataTagHierarchyDetailALL(){
		List<DataTagHierarchyDetail> selectDataTagHierarchyDetailAll = dataTagHierarchyDetailService.selectDataTagHierarchyDetailAll();
		return selectDataTagHierarchyDetailAll;
	}
	@RequestMapping("/insertDataTagHierarchyDetail")
	public int insertDataTagHierarchyDetail(DataTagHierarchyDetail dataTagHierarchyDetail) {
		int insertDataTagHierarchyDetail = dataTagHierarchyDetailService.insertDataTagHierarchyDetail(dataTagHierarchyDetail);
		return insertDataTagHierarchyDetail;
	}

}
