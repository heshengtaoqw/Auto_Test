package com.hst.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Browser {
	
  public static WebDriver driver;
  String url = "www.baidu.com";
  
  @BeforeTest
	public WebDriver startFirefox(String url) throws Exception {
	  	try{
		//默认支持火狐浏览器，能够正常打开，若不能打开火狐，则把下面的火狐的驱动放开
		//System.setProperty("webdriver.firefox.marionette","D:\\workspace\\tests\\src\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();	
			driver.get(url);
			System.out.println("成功打开火狐浏览器！");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
		} 
		catch (Exception e) {
			System.out.println("打开火狐浏览器时出错了"+e);
		}
			return driver;
  	}

	public void tearDownBrowser() throws Exception {
		try {
			Thread.sleep(2000);
			driver.close();
			System.out.println("成功关闭浏览器！");
		} 
		catch (Exception e) {
			System.out.println("关闭浏览器时出错了"+e);
		}
	}
}