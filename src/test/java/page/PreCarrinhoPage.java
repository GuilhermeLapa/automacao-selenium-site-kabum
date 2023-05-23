package page;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import core.TiposSeletores;
import core.WebDriverManager;

public class PreCarrinhoPage extends WebDriverManager {
	private static final String xpathBtnIrParaCarrinho= "//button[text()='IR PARA O CARRINHO']";
	private static final String xpathOpcaoGarantia12meses= "//p[text()=' +12 meses de garantia']";
	private static final String xpathRadioOpcaoGarantia12meses= "//input[@value='4042901']";//"//input[@name='garantia']";
	
	private static WebElement btnIrParaCarrinho;
	private static WebElement radioOpcaoGaranti12meses;
	
	public static void inicializarBtnIrParaOCarrinho() {
		btnIrParaCarrinho= encontrarElemento(TiposSeletores.XPATH, xpathBtnIrParaCarrinho);
	}
	
	public static void clicarBtnIrParaOCarrinho() {
		clicarElemento(btnIrParaCarrinho);
	}
	
	public static void verificarDirecionadoPaginaPreCarrinho() {
		aguardarPaginaSerCarregada(3000);
		
		//verifica a presença desses elementos na tela de precarrinho
		Assert.assertFalse(elementoAusente("//strong[text()='PRODUTO ADICIONADO NO CARRINHO']"));
		Assert.assertFalse(elementoAusente("//button[text()='CONTINUAR COMPRANDO']"));
		Assert.assertFalse(elementoAusente(xpathBtnIrParaCarrinho));
	}
	
	public static void opcaoGarantiaEstendida() {
		if(!elementoAusente(xpathOpcaoGarantia12meses)) {
			Assert.assertTrue(!elementoAusente(xpathRadioOpcaoGarantia12meses));
			
			radioOpcaoGaranti12meses= encontrarElemento(TiposSeletores.XPATH, xpathRadioOpcaoGarantia12meses);
			
			clicarElemento(radioOpcaoGaranti12meses);
		}
	}
}
