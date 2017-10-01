/**
 * Project Name:customquery
 * File Name:WordCount.java
 * Package Name:com.cn.cust.service.impl
 * Date:2017-9-30下午11:35:38
 * Copyright (c) 2017, 1095377095@qq.com All Rights Reserved.
 *
 */
package com.cn.cust.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 统计英文单词
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * Date: 2017-9-30 下午11:35:38 <br/>
 * 
 * @author CarlWang
 * @version
 * @since JDK 1.7
 */
public class WordCount {

	public static void main(String[] args) throws Exception {
		countWords("D:/pom.xml");
	}

	public static void countWords(String path) {
		long startTime = System.currentTimeMillis();//获取当前时间
		File file = new File(path);
		Map<String, Integer> map = new HashMap<String, Integer>();// 用于统计各个单词的个数
		String line = null;
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file),10 * 1024 * 1024);// 10M缓存
			while (br.ready()) {
				line = br.readLine();
				StringTokenizer token = new StringTokenizer(line);
				while (token.hasMoreTokens()) { // 循环遍历
					// 按照,空格 ? . : "" '' \n去分割
					String word = token.nextToken(", ?.!:\"\"''\n/=<>"); 											
					if (word.matches("^[a-zA-Z]*")) {// 全英文则计数+1
						count++;
						// 统计所有单词出现的次数
						if (map.containsKey(word)) {
							int nums = map.get(word);
							map.put(word, nums + 1); // 如果HashMap已有这个单词，则设置它的数量加1
						} else
							map.put(word, 1); // 如果没有这个单词，则新填入，数量为1
					}
				}

			}
			br.close();
			System.out.println("共有英文单词数："+count);
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				   System.out.println("英文单词：" + entry.getKey() + "出现次数为：" + entry.getValue());
				  }
			long endTime = System.currentTimeMillis();//结束时间
			System.out.println("程序运行时间："+(endTime-startTime)+"ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}