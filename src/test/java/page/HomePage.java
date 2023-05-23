package page;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import core.TiposBrowser;
import core.TiposSeletores;
import core.WebDriverManager;

public class HomePage extends WebDriverManager {
	private static final String xpathCampoBusca= "//input[@id='input-busca']";
	private static final String xpathListasugestoes= "//div[contains(@class, 'DropdownSearchbar')]/a";
	private static final String xpathReferenciaProdListasugestoes= "//div[contains(@class, 'DropdownSearchbar')]/a[";
	
	public static String url;
	private static WebElement campoBusca;
	private static ArrayList<WebElement> listaSugestoes;
	public static String referenciaProdListasugestoes;
	public static String nomeProdutoSelecionadoListasugestoes;
	
	public static void acessarSite(String url) {
		HomePage.url= url;
		criarDriver(TiposBrowser.Chrome);
		acessarPaginaSite(url);
		aguardarUrl(url, 3000);
	}
	
	public static void inicializarCampoBusca() {
		campoBusca= encontrarElemento(TiposSeletores.XPATH, xpathCampoBusca);
	}
	
	public static void escreverValorbusca(String nomeProduto) {
		escreverCampo(campoBusca, nomeProduto);
		//digitarCadaLetra(campoBusca, nomeProduto);
	}
	
	public static void verificarListaSugestoesBusca() {
		aguardarElemetoVisivel(TiposSeletores.XPATH, xpathListasugestoes, 3000);
		listaSugestoes= encontrarListaElementos(TiposSeletores.XPATH, xpathListasugestoes);
	}
	
	private static void salvarProdSelecionadoListasugestoes(int opcaoSugestao) {
		referenciaProdListasugestoes= encontrarElemento(TiposSeletores.XPATH, xpathReferenciaProdListasugestoes + opcaoSugestao + "]").getAttribute("href").toString();
		nomeProdutoSelecionadoListasugestoes= encontrarElemento(TiposSeletores.XPATH, xpathReferenciaProdListasugestoes + opcaoSugestao + "]/div/div/div[2]").getText().toString();
	}
	
	public static void clicarOpcaoSugestaoBusca(int opcaoSugestao) {
		salvarProdSelecionadoListasugestoes(opcaoSugestao);
		clicarElemento(listaSugestoes.get(opcaoSugestao-1));
	}
}
