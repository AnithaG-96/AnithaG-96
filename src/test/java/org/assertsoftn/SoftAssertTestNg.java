package org.assertsoftn;

import java.util.Date;

import org.basee.BaseClass;
import org.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTestNg  extends BaseClass{
@BeforeClass
private void beforeclass() {
chromeLaunch();
impWait(10);
}
@AfterClass
private void afterClass() {
quit();
}
@BeforeMethod
private void beforeMethod() {
Date d=new Date();
System.out.println("Before time....."+d);
}
@AfterMethod
private void afterMethod() {
Date d=new Date();
System.out.println("After Time...."+d);
}
@Test(priority=2,enabled=true,invocationCount=1)
private void test1() throws InterruptedException {
urlLaunch("https://www.facebook.com/");
SoftAssert s=new SoftAssert();
s.assertTrue(getCurrenturl().contains("facebook"),"Verify url");

LogInPage l=new LogInPage();

sendKeys(l.getUser(), "Aniii");
s.assertEquals(getAttribute(l.getUser()),"Aniii","Verify Name");

sendKeys(l.getPassword(), "1234");
s.assertEquals(getAttribute(l.getPassword()),"1234","Verify Password");

click(l.getLogin());
staticWait(4000);
s.assertTrue(getCurrenturl().contains(""),"Verify After url");
}
@Test(invocationCount=0)
private void test2() {
System.out.println("Test 2");
}
@Ignore
@Test
private void test3() {
System.out.println("Test 3");
}



























}
