package page;

import core.ChromeDriverManager;

public class CarrinhoPage {
	public static void acessarSite(String enderecoSite) {
		ChromeDriverManager chromeDriverManager= new ChromeDriverManager();
		
		chromeDriverManager.iniciarDriver();
		try {
		chromeDriverManager.getDriver().wait(5000);
		chromeDriverManager.fecharDriver();
		}
		catch(Exception e) {}
	}
}
