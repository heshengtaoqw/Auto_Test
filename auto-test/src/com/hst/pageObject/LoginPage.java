package com.hst.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

public class LoginPage {

	private String name = "j_username";
	private String pwd = "j_password";
	private String submit = "Submit";
	private String loginErrorPage = "http://10.31.0.55/loginError";
								

	//登录方法
	
	public void login(WebDriver driver, String username, String password) throws Exception {

		System.out.println("用户名为: " + username + ", 密码为: " + password );
		driver.findElement(By.name(name)).sendKeys(username);
		driver.findElement(By.name(pwd)).sendKeys(password);
		
		// 点击登录
		Thread.sleep(2000);
		driver.findElement(By.name(submit)).click();
		//driver.findElement(By.xpath("//span[contains(text(),'登录')]")).click();
		// System.out.println(driver.getCurrentUrl());
	}

 
	//判断是否登录成功
	public boolean isLoginSuccess(WebDriver driver) throws Exception{
		
		boolean flag = false;
		try {
			
			if(driver.getCurrentUrl().equals(loginErrorPage)){
				System.out.println("登录失败");
				flag=false;
				return flag;
			}
			else if(driver.findElement(By.linkText("新建任务")).isDisplayed())
			{	
				System.out.println("登录成功");
				flag = true;
				return flag;
			}
			else{
				System.out.println("登录页面异常");
				flag=false;
				return flag;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return flag;
	}
}

/*
	public String loginStatus(WebDriver driver) throws Exception {
		
		try{			
			
			if(isLoginSuccess(WebDriver driver))
			String actualResult = driver.findElement(By.xpath("//class='main_txt'/span[1]")).getText();
			return actualResult;
		}

		catch(Exception e)
		{}
		return name;
		}

 

 

public  boolean isLoginPage(WebDriver driver) throws Exception {

boolean flag = false;

try {

if (driver.findElement(By.id(forLogin)).getAttribute("value").equals("登录")) {

flag = true;

return flag;

}

} catch (Exception e) {

//     System.out.println(e);

return flag;

}

return flag;

}

}
*/