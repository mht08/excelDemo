package com.glmht.excelDemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.glmht.excelDemo.entity.DataSignAuth;

@Mapper
public interface DataSignAuthMapper {
	
	DataSignAuth getById(@Param(value = "id") Long id);
	
}
