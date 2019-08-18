package com.glmht.excelDemo.dao;

import java.util.List;

import com.glmht.excelDemo.entily.DataTag;



public interface DataTagDao {
	/**
	 * 查询所有
	 * @return
	 */
	public List<DataTag> selectDataTagAll();
	
	/**
	 * 通过ID查询一条数据
	 * @param id
	 * @return
	 */
	public DataTag selectDataTagById(Long id);
	
	/**
	 * 修改数据
	 * @param menu
	 * @return
	 */
	public int updateDataTag(DataTag dataTag);
	
	/**
	 * 添加数据
	 * @param menu
	 * @return
	 */
	public int  insertDataTag(DataTag dataTag);
	
	/**
	 * 删除数据
	 * @param menu
	 * @return
	 */
	public void  delDataTag(Long id);
}
