package com.briup.ssm.dao;

import java.util.List;
import java.util.Set;

import com.briup.ssm.common.bean.Line;

/*
 * 与数据库交互订单详细的Dao层
 */
public interface ILineDao  {
	
   //根据书本id查询订单详细（订单项）
   public  Line findLinebyBookId(Long id);
   //保存订单详细（订单项）
   public void saveLine(Line line);
   //删除订单详细（订单项）
   public void deleteLine(Long id);
   //通过订单id来查询订单详细
   public List<Line> selectbyOrderId(Long id);
}
