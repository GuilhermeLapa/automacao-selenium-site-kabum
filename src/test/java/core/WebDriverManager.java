package core;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {
	protected static WebDriver driver;
	protected abstract void criarDriver();
	
	public void fecharDriver() {
		if(driver != null) {
			driver.quit();
			driver= null;
		}
	}
	
	public WebDriver iniciarDriver() {
		if(driver == null) {
			criarDriver();
		}
		
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
