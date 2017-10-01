/**
 * Project Name:customquery
 * File Name:TellersService.java
 * Package Name:com.cn.cust.service
 * Date:2017-9-29下午8:57:54
 * Copyright (c) 2017, 1095377095@qq.com All Rights Reserved.
 *
 */
package com.cn.cust.service;

import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.cust.entity.Tellers;


/**
 * ClassName: TellersService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * Date: 2017-9-29 下午8:57:54 <br/>
 *
 * @author CarlWang
 * @version 
 * @since JDK 1.7
 */
public interface TellersService {
	public Tellers getTellersById(int tellerId);    
    
    public void insertTellers(Tellers teller);    
    
    public void addTellers(Tellers teller);    
    
    public List<Tellers> getAllTellers();
    public List<Tellers> queryTellers(String column,String condition); 
}

