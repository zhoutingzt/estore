package com.briup.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.dao.ILineDao;
import com.briup.ssm.service.interfaces.ILineService;

/*
 * 订单详细管理
 */
@Service
public class LineServiceImpl implements ILineService {

	//注入lineDao层对象
	@Autowired
	ILineDao lineDao;
	
	/**
     * 通过id来删除订单详细
     * 
     * @param id 要删除的订单详细id
     */
	@Override
	public void delLine(Long id) throws EstoreCommonException {
		List<Line> linelist = lineDao.selectbyOrderId(id);
		if(linelist.size()==0){
			throw EstoreCommonException.getException(404);
		}
		lineDao.deleteLine(id);
	}

	
}
