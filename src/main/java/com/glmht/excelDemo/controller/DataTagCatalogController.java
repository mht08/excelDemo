package com.glmht.excelDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glmht.excelDemo.entity.DataTagCatalog;
import com.glmht.excelDemo.service.DataTagCatalogService;

@RestController
@RequestMapping("/DataTagCatalogController")
public class DataTagCatalogController {
	@Autowired
	private DataTagCatalogService dataTagCatalogService;
	
	@RequestMapping("/selectDataTagCatalogById")
	public  DataTagCatalog selectDataTagCatalogById(Long id) {
		DataTagCatalog selectDataTagCatalogById = dataTagCatalogService.selectDataTagCatalogById(id);
		return selectDataTagCatalogById;
	}
	@RequestMapping("/selectDataTagCatalogALL")
	public List<DataTagCatalog> selectDataTagCatalogALL(){
		List<DataTagCatalog> selectDataTagCatalogAll = dataTagCatalogService.selectDataTagCatalogAll();
		return selectDataTagCatalogAll;
	}
	@RequestMapping("/insertDataTagCatalog")
	public int insertDataTagCatalog(DataTagCatalog dataTagCatalog) {
		int insertDataTagCatalog = dataTagCatalogService.insertDataTagCatalog(dataTagCatalog);
		return insertDataTagCatalog;
	}
}
