package com.hst.util;

/*
 �ڱ�д���������������ش���������ٱ�д�����࣬���в�����Ҫִ��ʱ��Ҫ�̳���������࣬�̳���������������
 ��������Ҫ���ܾ�����ִ��TestSuite֮ǰҪ�ȴ���ص��������Ȼ�������ز��ԣ�ִ����TestSuite�Ĳ�������֮������Ҫ�ر������������������£�
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.hst.util.Browser;


public class BaseTest {
	
	public String LoginURL; //https://weibo.com/login.php
	private static String URL = "https://www.baidu.com";
	Browser useBrowser = new Browser();
	public static WebDriver driver;
	
	
	@BeforeSuite //BeforeSuite：在整个测试集运行之前运行；
	public void start() throws Exception {
		try {
			driver = useBrowser.startFirefox(URL);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@DataProvider(name = "login")   //�ļ���
    public Object[][] dp() throws Exception {
        return readCSV("D:\\login1.txt");    //�ļ���·��
    }
	
	public static Object[][] readCSV(String fileName) throws Exception
	  {
		 List<Object[]> records = new ArrayList<Object[]>();
	        String record;
	        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
	        file.readLine();                           //���Ե�һ��
	        while ((record=file.readLine())!=null){        //������ȡ�ļ��г���һ������������е�����
	            String fields[] =  record.split(",");  //�洢����Ϊrecords��ArrayList��
	            records.add(fields);                    //ÿһ��recods�д洢�Ķ���Ϊһ��String����
	        }
	        file.close();  //�ر��ļ�����

	        Object[][] results = new Object[records.size()][]; //���庯������ֵ����Object[][]
	        for (int i=0; i<records.size();i++){            //���洢�������ݵ�Listת��Ϊһ����Object�Ķ�ά����
	            results[i] = records.get(i);               //���ö�ά����ÿ�е�ֵ��ÿ����һ��Object����
	        }
	        return results;

	  }

 
	@AfterSuite
	public void end() throws Exception {
		useBrowser.tearDownBrowser();
	}
}