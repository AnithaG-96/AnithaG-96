package org.assertsoftn;

import java.awt.geom.QuadCurve2D;
import java.io.IOException;
import java.util.Date;

import org.basee.BaseClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewCls extends BaseClass {
@BeforeClass
private void befCkls() {
chromeLaunch();
impWait(10);
}
@AfterClass
private void aft() {
quit();
}
@BeforeMethod
private void be() {
Date d=new Date();
System.out.println("Bef Time"+d);
}
@AfterMethod
private void aftM(ITestResult ref) throws IOException {
Date d=new Date();
System.out.println("after time"+d);
int status = ref.getStatus();
if(status==2) {
	String name = ref.getName();
	screenShot(name);
}
}
@Test(priority=1,invocationCount=3,enabled=true)
private void test1() throws InterruptedException {
urlLaunch("https://www.adactinhotelapp.com/");
SoftAssert s=new SoftAssert();
s.assertTrue(getCurrenturl().contains("adactin"),"verify url");
staticWait(1000);
s.assertAll();
}
@Test(priority=1,enabled=true,invocationCount=5)
private void test2() {
System.out.println("Test 2 ");
}
@Test(priority=0,invocationCount=1,enabled=true)
private void test3() {
urlLaunch("https://www.facebook.com/");
SoftAssert s=new SoftAssert();
s.assertTrue(getCurrenturl().contains("adactin"),"verify Fb url");
s.assertAll();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
