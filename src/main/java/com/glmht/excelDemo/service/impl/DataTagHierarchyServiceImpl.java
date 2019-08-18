package com.glmht.excelDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glmht.excelDemo.dao.DataTagHierarchyDao;
import com.glmht.excelDemo.entily.DataTagHierarchy;
import com.glmht.excelDemo.service.DataTagHierarchyService;

@Service("DataTagHierarchyService")
public class DataTagHierarchyServiceImpl implements DataTagHierarchyService {
	@Autowired
	private DataTagHierarchyDao dataTagHierarchyDao;

	@Override
	public List<DataTagHierarchy> selectDataTagHierarchyAll() {
		// TODO Auto-generated method stub
		return dataTagHierarchyDao.selectDataTagHierarchyAll();
	}

	@Override
	public DataTagHierarchy selectDataTagHierarchyById(Long id) {
		// TODO Auto-generated method stub
		return dataTagHierarchyDao.selectDataTagHierarchyById(id);
	}

	@Override
	public int updateDataTagHierarchy(DataTagHierarchy dataTagHierarchy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDataTagHierarchy(DataTagHierarchy dataTagHierarchy) {
		// TODO Auto-generated method stub
		return dataTagHierarchyDao.insertDataTagHierarchy(dataTagHierarchy);
	}

	@Override
	public void delDataTagHierarchy(Long id) {
		// TODO Auto-generated method stub
		dataTagHierarchyDao.delDataTagHierarchy(id);
	}
}
