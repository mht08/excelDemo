package com.glmht.excelDemo.service;

import java.util.List;

import com.glmht.excelDemo.entity.DataTagCatalog;



public interface DataTagCatalogService {
	/**
	 * 查询所有
	 * @return
	 */
	public List<DataTagCatalog> selectDataTagCatalogAll();
	
	/**
	 * 通过ID查询一条数据
	 * @param id
	 * @return
	 */
	public DataTagCatalog selectDataTagCatalogById(Long id);
	
	/**
	 * 修改数据
	 * @param menu
	 * @return
	 */
	public int updateDataTagCatalog(DataTagCatalog dataTagCatalog);
	
	/**
	 * 添加数据
	 * @param menu
	 * @return
	 */
	public int  insertDataTagCatalog(DataTagCatalog dataTagCatalog);
	
	/**
	 * 删除数据
	 * @param menu
	 * @return
	 */
	public void  delDataTagCatalog(Long id);
	
	/**
	 * 最大值
	 * @return
	 */
	public int maxNumber(String parentNumber);
}
