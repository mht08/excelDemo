package com.glmht.excelDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glmht.excelDemo.entity.DataTag;
import com.glmht.excelDemo.service.DataTagService;


@RestController
@RequestMapping("/DataTagController")
public class DataTagController {
	@Autowired
	private DataTagService dataTagService;
	
	@RequestMapping("/selectDataTagById")
	public  DataTag selectDataTagById(Long id) {
		DataTag selectDataTagById = dataTagService.selectDataTagById(id);
		return selectDataTagById;
	}
	@RequestMapping("/selectDataTagALL")
	public List<DataTag> selectDataTagALL(){
		List<DataTag> selectDataTagAll = dataTagService.selectDataTagAll();
		return selectDataTagAll;
	}
	@RequestMapping("/insertDataTag")
	public int insertDataTag(DataTag dataTag) {
		int insertDataTag = dataTagService.insertDataTag(dataTag);
		return insertDataTag;
	}

}
