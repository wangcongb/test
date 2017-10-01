/**
 * Project Name:customquery
 * File Name:TellersDao.java
 * Package Name:com.cn.cust.dao
 * Date:2017-9-29下午8:59:01
 * Copyright (c) 2017, 1095377095@qq.com All Rights Reserved.
 *
 */
package com.cn.cust.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cn.cust.entity.Tellers;


/**
 * ClassName: TellersDao <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * Date: 2017-9-29 下午8:59:01 <br/>
 *
 * @author CarlWang
 * @version 
 * @since JDK 1.7
 */
public interface TellersDao {
	 	public Tellers queryByPrimaryKey(Integer id);    
     
	    public List<Tellers> queryTellersByBatch(Map<String,Object> params);    
	        
	    public void insertTellers(Tellers tellers);    
	        
	    public void insertTellersByBatch(List<Tellers> list);    
	        
	    public void deleteByPrimaryKey(Integer id);    
	        
	    public void delteTellersByBatch(Map<String,Object> params);    
	        
	    public void updateByPrimaryKey(Integer id);    
	    
	    public List<Tellers> getAllTellers();
	   
	    public List<Tellers> queryTellers( String column,String condition);
}

