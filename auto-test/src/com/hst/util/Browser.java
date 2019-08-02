package com.hst.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Browser {
	
  public static WebDriver driver;
  
  @BeforeTest //BeforeTest：在测试集中的每个Test之前运行
	public WebDriver startFirefox(String url) throws Exception {
	  	try{
		//Ĭ��֧�ֻ����������ܹ������򿪣������ܴ򿪻�����������Ļ���������ſ�
		//System.setProperty("webdriver.firefox.marionette","D:\\workspace\\tests\\src\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();	
			driver.get(url);
			System.out.println("�ɹ��򿪻���������");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Thread.sleep(2000);
		} 
		catch (Exception e) {
			System.out.println("�򿪻�������ʱ������"+e);
		}
			return driver;
  	}

	public void tearDownBrowser() throws Exception {
		try {
			Thread.sleep(2000);
			driver.close();
			System.out.println("�ɹ��ر��������");
		} 
		catch (Exception e) {
			System.out.println("�ر������ʱ������"+e);
		}
	}
}