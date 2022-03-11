package org.pages;

import org.basee.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends  BaseClass{
public LogInPage() {
	PageFactory.initElements(driver, this);
}

@FindBy(id="email")
private WebElement user;
 
@FindBy(id="pass")
private WebElement password	;

@FindBy(name="login")
private WebElement login;

public WebElement getUser() {
	return user;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLogin() {
	return login;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
