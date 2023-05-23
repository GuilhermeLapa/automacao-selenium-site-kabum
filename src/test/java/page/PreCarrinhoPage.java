package page;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import core.TiposSeletores;
import core.WebDriverManager;

public class PreCarrinhoPage extends WebDriverManager {
	private static final String xpathBtnIrParaCarrinho= "//button[text()='IR PARA O CARRINHO']";
	
	private static WebElement btnIrParaCarrinho;
	
	public static void inicializarBtnIrParaOCarrinho() {
		btnIrParaCarrinho= encontrarElemento(TiposSeletores.XPATH, xpathBtnIrParaCarrinho);
	}
	
	public static void clicarBtnIrParaOCarrinho() {
		clicarElemento(btnIrParaCarrinho);
	}
	
	public static void verificarDirecionadoPaginaPreCarrinho() {
		aguardarPaginaSerCarregada(3000);
		
		//verifica a presença desses elementos na tela de precarrinho
		Assert.assertFalse(elementoAusente(TiposSeletores.XPATH, "//strong[text()='PRODUTO ADICIONADO NO CARRINHO']"));
		Assert.assertFalse(elementoAusente(TiposSeletores.XPATH, "//button[text()='CONTINUAR COMPRANDO']"));
		Assert.assertFalse(elementoAusente(TiposSeletores.XPATH, xpathBtnIrParaCarrinho));
	}
}
