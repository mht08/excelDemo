package com.glmht.excelDemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.glmht.excelDemo.entity.DataTagHierarchyDetail;


@Mapper
public interface DataTagHierarchyDetailMapper {
	/**
	 * 查询所有
	 * @return
	 */
	public List<DataTagHierarchyDetail> selectDataTagHierarchyDetailAll();
	
	/**
	 * 通过ID查询一条数据
	 * @param id
	 * @return
	 */
	public DataTagHierarchyDetail selectDataTagHierarchyDetailById(Long id);
	
	/**
	 * 修改数据
	 * @param menu
	 * @return
	 */
	public int updateDataTagHierarchyDetail(DataTagHierarchyDetail dataTagHierarchyDetail);
	
	/**
	 * 添加数据
	 * @param menu
	 * @return
	 */
	public int  insertDataTagHierarchyDetail(DataTagHierarchyDetail dataTagHierarchyDetail);
	
	/**
	 * 删除数据
	 * @param menu
	 * @return
	 */
	public void  delDataTagHierarchyDetail(Long id);
}
