package com.glmht.excelDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glmht.excelDemo.entity.DataRinseTag;
import com.glmht.excelDemo.mapper.DataRinseTagMapper;
import com.glmht.excelDemo.service.DataRinseTagService;

@Service("DataRinseTagService")
public class DataRinseTagServiceImpl implements DataRinseTagService {
	@Autowired
	private DataRinseTagMapper dataRinseTagMapper;

	@Override
	public List<DataRinseTag> selectDataRinseTagAll() {
		// TODO Auto-generated method stub
		return dataRinseTagMapper.selectDataRinseTagAll();
	}

	@Override
	public DataRinseTag selectDataRinseTagById(Long id) {
		// TODO Auto-generated method stub
		return dataRinseTagMapper.selectDataRinseTagById(id);
	}

	@Override
	public int updateDataRinseTag(DataRinseTag dataRinseTag) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertDataRinseTag(DataRinseTag dataRinseTag) {
		// TODO Auto-generated method stub
		return dataRinseTagMapper.insertDataRinseTag(dataRinseTag);
	}

	@Override
	public void delDataRinseTag(Long id) {
		// TODO Auto-generated method stub
		dataRinseTagMapper.delDataRinseTag(id);
	}

}
