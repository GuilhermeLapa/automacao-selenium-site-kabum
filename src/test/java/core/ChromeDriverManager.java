package core;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends WebDriverManager {
	private static final String browserPath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
	private static final String chromeDriverPath = "src\\test\\resources\\drivers\\chromedriver.exe";
	private static final String webDriverType = "webdriver.chrome.driver";
	
	public static ChromeOptions criarDriver() {
		//criamos as op��es de configura��o para uma inst�ncia do chrome driver
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-extensions");
		//setamos a localiza��o padr�o do .exe do browser
		options.setBinary(browserPath);
		//criamos uma propriedade para informar que vamos usar o driver do chrome e sua localiza��o nesse projeto
		System.setProperty(ChromeDriverManager.webDriverType, ChromeDriverManager.chromeDriverPath);
		
		return options;
		/*
		//instanciamos o driver como um driver do Chrome Browser
		WebDriverManager.driver= new ChromeDriver(options);
		
		//solicita ao webdriver que espere um determinado tempo padr�o 
		WebDriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		//solicita ao driver que maximize a tela assim que abri-la
		WebDriverManager.driver.manage().window().maximize();
		*/
	}
}
