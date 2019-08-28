package com.glmht.excelDemo.service;

import java.util.List;

import com.glmht.excelDemo.entity.DataTagHierarchy;



public interface DataTagHierarchyService {
	/**
	 * 查询所有
	 * @return
	 */
	public List<DataTagHierarchy> selectDataTagHierarchyAll();
	
	/**
	 * 通过ID查询一条数据
	 * @param id
	 * @return
	 */
	public DataTagHierarchy selectDataTagHierarchyById(Long id);
	
	/**
	 * 修改数据
	 * @param menu
	 * @return
	 */
	public int updateDataTagHierarchy(DataTagHierarchy dataTagHierarchy);
	
	/**
	 * 添加数据
	 * @param menu
	 * @return
	 */
	public int  insertDataTagHierarchy(DataTagHierarchy dataTagHierarchy);
	
	/**
	 * 删除数据
	 * @param menu
	 * @return
	 */
	public void  delDataTagHierarchy(Long id);
}
