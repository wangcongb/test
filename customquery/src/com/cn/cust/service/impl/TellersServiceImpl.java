/**
 * Project Name:customquery
 * File Name:TellersServiceImpl.java
 * Package Name:com.cn.cust.service.impl
 * Date:2017-9-29下午9:00:29
 * Copyright (c) 2017, 1095377095@qq.com All Rights Reserved.
 *
 */
package com.cn.cust.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.cn.cust.dao.TellersDao;
import com.cn.cust.entity.Tellers;
import com.cn.cust.service.TellersService;


/**
 * ClassName: TellersServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * Date: 2017-9-29 下午9:00:29 <br/>
 *
 * @author CarlWang
 * @version 
 * @since JDK 1.7
 */
@Service("tellersService")
public class TellersServiceImpl implements TellersService{
	 @Resource
	 private JdbcTemplate jdbcTemplate;
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

		 @Resource    
		    private TellersDao tellersDao; 
	    @Override
		public Tellers getTellersById(int tellersId) {    
	        return tellersDao.queryByPrimaryKey(tellersId);    
	    }    
	    
	    @Override
		public void insertTellers(Tellers tellers) {    
	        tellersDao.insertTellers(tellers);    
	    }    
	    
	    @Override
		public void addTellers(Tellers tellers) {    
	        tellersDao.insertTellers(tellers);    
	    }    
	    
	    @Override
		public List<Tellers> getAllTellers() {    
	        return tellersDao.getAllTellers();    
	    }

		
		@Override
		public List<Tellers> queryTellers(String column, String condition) {
			/*ResultSet result=null;
			List<Tellers> tellerslist= new ArrayList<Tellers>();
			 Connection conn =null;
			 Statement st =null;
			 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //定义URL
				   conn = DriverManager.getConnection(url,"scott","460279");// 建立连接
				   st = conn.createStatement(); //创建Statement
				  String sql = "select "+column+ " from tellers where "+condition;
				   result=st.executeQuery(sql);
				   Tellers tellers=null;
	               if(result.next()){
	            	   System.out.println(result.getString("user_name"));
	                	tellers=new Tellers();
	                	if(column.contains("user_id")){
	   	                	tellers.setUser_id(result.getString("user_id"));
	   	                }
	   	                if(column.contains("user_name")){
	   	                	tellers.setUser_name(result.getString("user_name"));
	   	                }
	   	                if(column.contains("user_state")){
	   	                	tellers.setUser_state(result.getString("user_state"));
	   	                }
	   	                if(column.contains("dept_id")){
	   	                	tellers.setDept_id(result.getInt("dept_id"));
	   	                }
	   	                if(column.contains("dept_name")){
	   	                	tellers.setDept_name(result.getString("dept_name"));
	   	                }
	   	                if(column.contains("passwd")){
	   	                	tellers.setPasswd(result.getString("passwd"));
	   	                }
	   	                if(column.contains("crt_user")){
	   	                	tellers.setCrt_user(result.getString("crt_user"));
	   	                }
	   	                if(column.contains("crt_date")){
	   	                	tellers.setCrt_date(result.getString("crt_date"));
	   	                }
	   	                if(column.contains("user_tel")){
	   	                	tellers.setUser_tel(result.getString("user_tel"));
	   	                }
	   	                if(column.contains("email")){
	   	                	tellers.setEmail(result.getString("email"));
	   	                }
	   	                if(column.contains("str_remark")){
	   	                	tellers.setStr_remark(result.getString("str_remark"));
	   	                }
	                	tellerslist.add(tellers);
	                }
	               result.close();   
	                st.close();   
	                conn.close(); 
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				
			}
			 catch (SQLException e) {
				
				e.printStackTrace();
				
			}finally{
            if(conn !=null){
                try {
                    conn.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if(st !=null){
                try {
                	st.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if(result !=null){
                try {
                	result.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
		}
			
			return  tellerslist;
		}*/
			List<Tellers> tellerslist= new ArrayList<Tellers>();
			 Tellers tellers=null;
			 String sql = "select "+column+ " from tellers where "+condition;
			 List<Map<String, Object>> result=jdbcTemplate.queryForList(sql);
			 for(int i=0;i<result.size();i++){
				 tellers=new Tellers();
             	if(column.contains("user_id")){
	                	tellers.setUser_id(result.get(i).get("user_id").toString());
	                }
	                if(column.contains("user_name")){
	                	tellers.setUser_name(result.get(i).get("user_name").toString());
	                }
	                if(column.contains("user_state")){
	                	tellers.setUser_state(result.get(i).get("user_state").toString());
	                }
	                if(column.contains("dept_id")){
	                	tellers.setDept_id(Integer.parseInt(result.get(i).get("dept_id").toString()));
	                }
	                if(column.contains("dept_name")){
	                	tellers.setDept_name(result.get(i).get("dept_name").toString());
	                }
	                if(column.contains("passwd")){
	                	tellers.setPasswd(result.get(i).get("passwd").toString());
	                }
	                if(column.contains("crt_user")){
	                	tellers.setCrt_user(result.get(i).get("crt_user").toString());
	                }
	                if(column.contains("crt_date")){
	                	tellers.setCrt_date(result.get(i).get("crt_date").toString());
	                }
	                if(column.contains("user_tel")){
	                	tellers.setUser_tel(result.get(i).get("user_tel").toString());
	                }
	                if(column.contains("email")){
	                	tellers.setEmail(result.get(i).get("email").toString());
	                }
	                if(column.contains("str_remark")){
	                	tellers.setStr_remark(result.get(i).get("str_remark").toString());
	                }
             	tellerslist.add(tellers);
			 }
			return tellerslist;
		}

}
	    

