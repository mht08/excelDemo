package com.glmht.excelDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glmht.excelDemo.entity.DataTagCatalog;
import com.glmht.excelDemo.mapper.DataTagCatalogMapper;
import com.glmht.excelDemo.service.DataTagCatalogService;

@Service("DataTagCatalogService")
public class DataTagCatalogServiceImpl implements DataTagCatalogService {

	@Autowired
	private DataTagCatalogMapper dataTagCatalogDao;

	@Override
	public List<DataTagCatalog> selectDataTagCatalogAll() {
		// TODO Auto-generated method stub
		return dataTagCatalogDao.selectDataTagCatalogAll();
	}

	@Override
	public DataTagCatalog selectDataTagCatalogById(Long id) {
		// TODO Auto-generated method stub
		return dataTagCatalogDao.selectDataTagCatalogById(id);
	}

	@Override
	public int updateDataTagCatalog(DataTagCatalog dataTagCatalog) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDataTagCatalog(DataTagCatalog dataTagCatalog) {
		// TODO Auto-generated method stub
		return dataTagCatalogDao.insertDataTagCatalog(dataTagCatalog);
	}

	@Override
	public void delDataTagCatalog(Long id) {
		// TODO Auto-generated method stub
		dataTagCatalogDao.delDataTagCatalog(id);
	}

	@Override
	public int maxNumber(String parentNumber) {
		// TODO Auto-generated method stub
		return dataTagCatalogDao.maxNumber(parentNumber);
	}

}
