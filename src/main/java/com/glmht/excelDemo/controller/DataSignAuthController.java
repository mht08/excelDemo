package com.glmht.excelDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glmht.excelDemo.entity.DataSignAuth;
import com.glmht.excelDemo.service.DataSignAuthService;

@RestController
public class DataSignAuthController {

	@Autowired
    private DataSignAuthService dataSignAuthService;
	
	@RequestMapping("/getDataSignAuth/{id}")
	public DataSignAuth bookInfo(@PathVariable("id") Long id) {
        return dataSignAuthService.getById(id);
    }
}
