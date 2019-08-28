package com.glmht.excelDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glmht.excelDemo.entity.DataTag;
import com.glmht.excelDemo.mapper.DataTagMapper;
import com.glmht.excelDemo.service.DataTagService;

@Service("DataTagService")
public class DataTagServiceImpl implements DataTagService {
	@Autowired
	private DataTagMapper dataTagDao;

	@Override
	public List<DataTag> selectDataTagAll() {
		// TODO Auto-generated method stub
		return dataTagDao.selectDataTagAll();
	}

	@Override
	public DataTag selectDataTagById(Long id) {
		// TODO Auto-generated method stub
		return dataTagDao.selectDataTagById(id);
	}

	@Override
	public int updateDataTag(DataTag dataTag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDataTag(DataTag dataTag) {
		// TODO Auto-generated method stub
		return dataTagDao.insertDataTag(dataTag);
	}

	@Override
	public void delDataTag(Long id) {
		// TODO Auto-generated method stub
		dataTagDao.delDataTag(id);
	}
}
