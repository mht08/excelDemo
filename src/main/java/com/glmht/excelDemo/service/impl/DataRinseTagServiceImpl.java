package com.glmht.excelDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glmht.excelDemo.dao.DataRinseTagDao;
import com.glmht.excelDemo.entily.DataRinseTag;
import com.glmht.excelDemo.service.DataRinseTagService;

@Service("DataRinseTagService")
public class DataRinseTagServiceImpl implements DataRinseTagService {
	@Autowired
	private DataRinseTagDao dataRinseTagDao;

	@Override
	public List<DataRinseTag> selectDataRinseTagAll() {
		// TODO Auto-generated method stub
		return dataRinseTagDao.selectDataRinseTagAll();
	}

	@Override
	public DataRinseTag selectDataRinseTagById(Long id) {
		// TODO Auto-generated method stub
		return dataRinseTagDao.selectDataRinseTagById(id);
	}

	@Override
	public int updateDataRinseTag(DataRinseTag dataRinseTag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDataRinseTag(DataRinseTag dataRinseTag) {
		// TODO Auto-generated method stub
		return dataRinseTagDao.insertDataRinseTag(dataRinseTag);
	}

	@Override
	public void delDataRinseTag(Long id) {
		// TODO Auto-generated method stub
		dataRinseTagDao.delDataRinseTag(id);
	}

}
