/**
 * Project Name:customquery
 * File Name:test.java
 * Package Name:com.cn.cust.controller
 * Date:2017-9-29����11:06:34
 * Copyright (c) 2017, 1095377095@qq.com All Rights Reserved.
 *
 */
package com.cn.cust.controller;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class test {
 /**
  * @param args
  * @throws Exception 
  */
 public static void main(String[] args) throws Exception {
	 // TODO Auto-generated method stub

	  //oracle.jdbc.driver.OracleDriver
	  Class.forName("oracle.jdbc.driver.OracleDriver");//��������
	  //Class.forName("sun.jdbc.odbc.JdbcodbcDriver");//��������
	  String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //����URL
	  Connection con = DriverManager.getConnection(url,"scott","460279");// ��������
	  Statement st = con.createStatement(); //����Statement
	  String column="USER_NAME";
  	String condition="USER_ID='001'";
	  String sql = "select "+column+ " from tellers where "+condition;
	  System.out.println(sql);
	  ResultSet result=st.executeQuery(sql);
while(result.next()){
	  System.out.println(result.getString("user_name"));
}
result.close();   
st.close();   
con.close(); 
 }
}