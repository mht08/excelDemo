package com.glmht.excelDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glmht.excelDemo.entity.DataRinseTag;
import com.glmht.excelDemo.service.DataRinseTagService;


@RestController
@RequestMapping("/DataRinseTagController")
public class DataRinseTagController {
	@Autowired
    private DataRinseTagService dataRinseTagService;
	//查询一条数据
	@RequestMapping("/getDataRinseTag/{id}")
	public DataRinseTag bookInfo(@PathVariable("id") Long id) {
        return dataRinseTagService.selectDataRinseTagById(id);
    }
	@RequestMapping("/insertDataRinseTag")
	public int insertDataRinseTag(DataRinseTag dataRinseTag) {
		int num = dataRinseTagService.insertDataRinseTag(dataRinseTag);
		return num;
	}
}
