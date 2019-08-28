package com.glmht.excelDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glmht.excelDemo.entity.DataTagHierarchyDetail;
import com.glmht.excelDemo.mapper.DataTagHierarchyDetailMapper;
import com.glmht.excelDemo.service.DataTagHierarchyDetailService;

@Service("DataTagHierarchyDetailService")
public class DataTagHierarchyDetailServiceImpl implements DataTagHierarchyDetailService {
	@Autowired
	private DataTagHierarchyDetailMapper dataTagHierarchyDetailDao;

	@Override
	public List<DataTagHierarchyDetail> selectDataTagHierarchyDetailAll() {
		// TODO Auto-generated method stub
		return dataTagHierarchyDetailDao.selectDataTagHierarchyDetailAll();
	}

	@Override
	public DataTagHierarchyDetail selectDataTagHierarchyDetailById(Long id) {
		// TODO Auto-generated method stub
		return dataTagHierarchyDetailDao.selectDataTagHierarchyDetailById(id);
	}

	@Override
	public int updateDataTagHierarchyDetail(DataTagHierarchyDetail dataTagHierarchyDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDataTagHierarchyDetail(DataTagHierarchyDetail dataTagHierarchyDetail) {
		// TODO Auto-generated method stub
		return dataTagHierarchyDetailDao.insertDataTagHierarchyDetail(dataTagHierarchyDetail);
	}

	@Override
	public void delDataTagHierarchyDetail(Long id) {
		// TODO Auto-generated method stub
		dataTagHierarchyDetailDao.delDataTagHierarchyDetail(id);
	}

}
