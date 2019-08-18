package com.glmht.excelDemo.dao;

import java.util.List;

import com.glmht.excelDemo.entily.DataRinseTag;



public interface DataRinseTagDao {

	/**
	 * 查询所有
	 * @return
	 */
	public List<DataRinseTag> selectDataRinseTagAll();
	
	/**
	 * 通过ID查询一条数据
	 * @param id
	 * @return
	 */
	public DataRinseTag selectDataRinseTagById(Long id);
	
	/**
	 * 修改数据
	 * @param menu
	 * @return
	 */
	public int updateDataRinseTag(DataRinseTag dataRinseTag);
	
	/**
	 * 添加数据
	 * @param menu
	 * @return
	 */
	public int  insertDataRinseTag(DataRinseTag dataRinseTag);
	
	/**
	 * 删除数据
	 * @param menu
	 * @return
	 */
	public void  delDataRinseTag(Long id);
}
