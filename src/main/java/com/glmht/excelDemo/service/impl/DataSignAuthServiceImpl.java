package com.glmht.excelDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glmht.excelDemo.entity.DataSignAuth;
import com.glmht.excelDemo.mapper.DataSignAuthMapper;
import com.glmht.excelDemo.service.DataSignAuthService;

@Service
public class DataSignAuthServiceImpl implements DataSignAuthService {

	@Autowired
	private DataSignAuthMapper dataSignAuthMapper; 
	
	@Override
	public DataSignAuth getById(Long id) {
		return dataSignAuthMapper.getById(id);
	}

}
