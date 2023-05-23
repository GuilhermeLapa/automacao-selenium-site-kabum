package page;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import core.TiposSeletores;
import core.WebDriverManager;

public class CarrinhoPage extends WebDriverManager {
	private static final String xpathNomeProdutoNoCarrinho= "//a[contains(@class, 'productName')]";
	
	private static WebElement nomeProdutoNoCarrinho;
	
	public static void verificarQueOProdutoSelecionadoEstaNoCarrinho() {
		nomeProdutoNoCarrinho= encontrarElemento(TiposSeletores.XPATH, xpathNomeProdutoNoCarrinho);
		Assert.assertEquals(HomePage.nomeProdutoSelecionadoListasugestoes.toUpperCase(), CarrinhoPage.nomeProdutoNoCarrinho.getText().toUpperCase());
	}
	
	public static void verificarDirecionadoPaginaCarrinho() {
		aguardarUrl(HomePage.url + "carrinho", 3000);
		aguardarPaginaSerCarregada(3000);
		Assert.assertTrue(driver.getCurrentUrl().toString().toUpperCase().contains("carrinho".toUpperCase()));
	}
}
