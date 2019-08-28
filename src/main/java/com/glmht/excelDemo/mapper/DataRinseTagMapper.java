package com.glmht.excelDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.glmht.excelDemo.entity.DataRinseTag;


@Mapper
public interface DataRinseTagMapper {

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
