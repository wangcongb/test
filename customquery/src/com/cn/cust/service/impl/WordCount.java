/**
 * Project Name:customquery
 * File Name:WordCount.java
 * Package Name:com.cn.cust.service.impl
 * Date:2017-9-30����11:35:38
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
 * ͳ��Ӣ�ĵ���
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(��ѡ). <br/>
 * Date: 2017-9-30 ����11:35:38 <br/>
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
		long startTime = System.currentTimeMillis();//��ȡ��ǰʱ��
		File file = new File(path);
		Map<String, Integer> map = new HashMap<String, Integer>();// ����ͳ�Ƹ������ʵĸ���
		String line = null;
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file),10 * 1024 * 1024);// 10M����
			while (br.ready()) {
				line = br.readLine();
				StringTokenizer token = new StringTokenizer(line);
				while (token.hasMoreTokens()) { // ѭ������
					// ����,�ո� ? . : "" '' \nȥ�ָ�
					String word = token.nextToken(", ?.!:\"\"''\n/=<>"); 											
					if (word.matches("^[a-zA-Z]*")) {// ȫӢ�������+1
						count++;
						// ͳ�����е��ʳ��ֵĴ���
						if (map.containsKey(word)) {
							int nums = map.get(word);
							map.put(word, nums + 1); // ���HashMap����������ʣ�����������������1
						} else
							map.put(word, 1); // ���û��������ʣ��������룬����Ϊ1
					}
				}

			}
			br.close();
			System.out.println("����Ӣ�ĵ�������"+count);
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				   System.out.println("Ӣ�ĵ��ʣ�" + entry.getKey() + "���ִ���Ϊ��" + entry.getValue());
				  }
			long endTime = System.currentTimeMillis();//����ʱ��
			System.out.println("��������ʱ�䣺"+(endTime-startTime)+"ms");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}