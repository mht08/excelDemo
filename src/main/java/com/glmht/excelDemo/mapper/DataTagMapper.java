package com.glmht.excelDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.glmht.excelDemo.entity.DataTag;


@Mapper
public interface DataTagMapper {
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
