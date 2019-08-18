package com.glmht.excelDemo.entity;

import com.glmht.excelDemo.entity.common.BasicEntity;

/**
 * 	数据权限表
 * @author mahaitao
 *
 */
public class DataSignAuth extends BasicEntity{

	private static final long serialVersionUID = 4298746638775249740L;

	private String name;//权限名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
