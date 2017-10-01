/**
 * Project Name:customquery
 * File Name:TellersController.java
 * Package Name:com.cn.cust.controller
 * Date:2017-9-29ÏÂÎç8:43:32
 * Copyright (c) 2017, 1095377095@qq.com All Rights Reserved.
 *
 */
package com.cn.cust.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.cust.entity.Tellers;
import com.cn.cust.service.TellersService;
    
    
@Controller    
@RequestMapping("/tellers")    
public class TellersController {    
    @Resource    
    private TellersService tellersService;    
    @RequestMapping("/query")    
    public String queryTellers(HttpServletRequest request,Model model){
    	String column=request.getParameter("column");
    	if(column.endsWith(",")){
    		column=column.substring(0, column.length()-1);
    	};
    	String condition=request.getParameter("condition");
    	
    	//String column=" user_name ";
    	//String condition=" user_id = '001'";
    	//String column=" user_id,user_name,user_state,dept_id,dept_name ";
    	//String condition=" crt_user = 'ÀîËÄ'";
    	List<Tellers> result = tellersService.queryTellers(column, condition);    
        model.addAttribute("result", result); 
      	  //System.out.println(uList.get(0).getUser_name());
        return "tellersList";    
    }    
        
    @RequestMapping("/tellersList")    
    public String tellersList(HttpServletRequest request,Model model){    
        List<Tellers> result = tellersService.getAllTellers();    
        model.addAttribute("result", result); 
        System.out.println(result.get(0).getDept_name());
        return "tellersList";    
    }    
       
    
    
    @RequestMapping("/showTellers")    
    public String showTellers(HttpServletRequest request,Model model){    
        //int tellersId = Integer.parseInt(request.getParameter("id")); 
    	int tellersId=001;
        Tellers tellers = tellersService.getTellersById(tellersId);    
        model.addAttribute("tellers", tellers);    
        return "showTellers";    
    }    
        
    @RequestMapping("/addTellersUI")    
    public String addTellersUI(){    
        return "addTellers";    
    }    
        
    @RequestMapping("/addTellers")    
    public String addTellers(HttpServletRequest request,Model model){    
        Tellers tellers = new Tellers();    
      //  tellers.setName(String.valueOf(request.getParameter("name")));    
     //   tellers.setPassword(String.valueOf(request.getParameter("password")));    
       // tellers.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));    
        tellersService.addTellers(tellers);    
        return "redirect:/tellers/tellersList";    
    }    
}    