package com.hst.util;

/*
 在编写完启动浏览器的相关代码后，我们再编写基础类，当有测试类要执行时就要继承这个基础类，继承它的两个方法。
 这个类的主要功能就是在执行TestSuite之前要先打开相关的浏览器，然后进行相关测试，执行完TestSuite的测试用例之后，我们要关闭浏览器。具体代码如下：
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
	
	
	@BeforeSuite
	public void start() throws Exception {
		try {
			driver = useBrowser.startFirefox(URL);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@DataProvider(name = "login")   //文件名
    public Object[][] dp() throws Exception {
        return readCSV("D:\\login1.txt");    //文件的路径
    }
	
	public static Object[][] readCSV(String fileName) throws Exception
	  {
		 List<Object[]> records = new ArrayList<Object[]>();
	        String record;
	        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
	        file.readLine();                           //忽略第一行
	        while ((record=file.readLine())!=null){        //遍历读取文件中除第一行以外的所有行的内容
	            String fields[] =  record.split(",");  //存储在名为records的ArrayList中
	            records.add(fields);                    //每一个recods中存储的对象为一个String数组
	        }
	        file.close();  //关闭文件对象

	        Object[][] results = new Object[records.size()][]; //定义函数返回值，即Object[][]
	        for (int i=0; i<records.size();i++){            //将存储测试数据的List转换为一个人Object的二维数组
	            results[i] = records.get(i);               //设置二维数组每行的值，每行是一个Object对象
	        }
	        return results;

	  }

 
	@AfterSuite
	public void end() throws Exception {
		useBrowser.tearDownBrowser();
	}
}