package com.briup.ssm.service.interfaces;

import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.exception.EstoreCommonException;


/*
 * 管理订单详细
 */
public interface ILineService {
	
  /* Line selectOrderLine (Long id) throws EstoreCommonException;
  void saveLine(Line id) throws EstoreCommonException;*/
	
  //删除订单的业务	
  void delLine(Long id) throws EstoreCommonException; 
}
