package com.hst.testcase;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hst.pageObject.*;
import com.hst.util.*;


public class LoginTest extends BaseTest{

	LoginPage loginPage = new LoginPage();
	String LoginURL = "http://10.31.0.56/login";
	String username = null;
	String password = null;

	//��������1���˺�������ȷ
	@Test(dataProvider = "login")
	public void loginTest1(String testName, String username, String password) throws Exception{
		driver.get(LoginURL);
		System.out.println("��������1"+ testName);
		System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
		
		try {
			loginPage.login(driver,username,password);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			assertEquals(loginPage.isLoginSuccess(driver), true);
			}
		Thread.sleep(2000);
	}
	
	//��������2���˺ż����벻��ȷ
	@Parameters({"testName","username","password"})
	@Test
	public void loginTest2(String testName, String username, String password) throws Exception{
		driver.get(LoginURL);
		System.out.println("��������2"+ testName);
		System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
		
		try {
			loginPage.login(driver, username, password);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		finally {
			assertEquals(loginPage.isLoginSuccess(driver),false);
			}
	}
	
	
	
}