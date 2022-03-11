package org.assertsoftn;

import java.util.Date;

import org.basee.BaseClass;
import org.pages.LogInPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MultipleWebSites extends BaseClass {
@BeforeClass
private void befCls() {
chromeLaunch();
impWait(10);
}
@AfterClass
private void afterCls() {
quit();
}
@BeforeMethod
private void beMet() {
Date d=new Date();
System.out.println("Bef Time="+d);
}
@AfterMethod
private void aftMeth() {
Date d=new Date();
System.out.println("Aft Time="+d);
}


@Test(priority=1,enabled=true,invocationCount=1)
private void test1() throws InterruptedException {
urlLaunch("https://www.facebook.com");
SoftAssert s=new SoftAssert();
s.assertTrue(getCurrenturl().contains("facebook"));
LogInPage l=new LogInPage();
sendKeys(l.getUser(), "Gopukumar");
s.assertEquals(getAttribute(l.getUser()), "Gopukumar","Verify Name");
sendKeys(l.getPassword(), "1234567");
s.assertEquals(getAttribute(l.getPassword()), "1234567","Verify password");
click(l.getLogin());
staticWait(3000);
s.assertTrue(getCurrenturl().contains("privacy"),"Verify after url");
s.assertAll();
}

@Test(priority=2,enabled=true)
private void test2() {
urlLaunch("https://www.flipkart.com");
SoftAssert s=new SoftAssert();
s.assertTrue(getCurrenturl().contains(""),"verify login");
s.assertAll();
}
	
@Test(priority=3,enabled=true,invocationCount=1)	
private void test3() {
urlLaunch("https://www.amazon.com");
SoftAssert s=new SoftAssert();
s.assertTrue(getCurrenturl().contains(""),"verify login");
s.assertAll();
}	

@Test(priority=4,enabled=true,invocationCount=1)
private void test4() {
urlLaunch("https://www.snapdeal.com");
SoftAssert s=new SoftAssert();
s.assertTrue(getCurrenturl().contains(""),"Verify login");
s.assertAll();
}
	
@Test(priority=5,invocationCount=1)
private void test5() {
urlLaunch("https://www.instagram.com");
SoftAssert s=new SoftAssert();
s.assertTrue(getCurrenturl().contains(""),"Verify login");
s.assertAll();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
