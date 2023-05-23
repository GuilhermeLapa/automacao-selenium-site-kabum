package page;

import java.text.Normalizer;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import core.TiposSeletores;
import core.WebDriverManager;

public class PaginaDetalhesProdutoPage extends WebDriverManager {
	private static final String xpathCampoCep= "[data-testid='ZipCodeInput']";
	private static final String xpathBtnOk= "//button[@id='botaoCalcularFrete']";
	private static final String xpathModalCalcularFrete= "//div[@id='modalWrapper']/div";
	private static final String xpathModalCalcularFreteIconeX= "[data-testid='btnClose']";
	private static final String xpathBtnComprar= "//div[@id='blocoValores']//button[contains(text(),'COMPRAR')]";
	
	private static WebElement campoCep;
	private static WebElement btnOk;
	private static WebElement modalCalcularFrete;
	private static WebElement modalCalcularFreteIconeX;
	private static WebElement btnComprar;
	
	public static void inicializarCampoCEP() {
		campoCep= encontrarElemento(TiposSeletores.CSS, xpathCampoCep);
	}
	
	public static void inicializarBtnOK() {
		btnOk= encontrarElemento(TiposSeletores.XPATH, xpathBtnOk);
	}
	
	public static void digitarCep(String cep) {
		escreverCampo(campoCep, cep);
	}
	
	public static void clicarBtnOK() {
		clicarElemento(btnOk);
	}
	
	public static void inicializarElementosModalCalcularFrete() {
		//TO DO inicializar os outros elementos necessários
		aguardar(3000);
		modalCalcularFrete= encontrarElemento(TiposSeletores.XPATH, xpathModalCalcularFrete);
		modalCalcularFreteIconeX= encontrarElemento(TiposSeletores.CSS, xpathModalCalcularFreteIconeX);
	}
	
	public static void fecharModalCalcularFrete() {
		clicarElemento(modalCalcularFreteIconeX);
		aguardarPaginaSerCarregada(3000);
	}
	
	public static void inicializarElementosBtnComprar() {
		btnComprar= encontrarElemento(TiposSeletores.XPATH, xpathBtnComprar);
	}
	
	public static void clicarBtnComprar() {
		/*
		 * é necessário o try/catch para o clique no 
		 * botão comprar pois após fechar o modal há 
		 * um refresh na página que deixa os webelements obsoletos
		 */
		try {
			clicarElemento(btnComprar);
		}
		catch (Exception e) {
			btnComprar= encontrarElemento(TiposSeletores.XPATH, xpathBtnComprar);
			clicarElemento(btnComprar);
		}
	}
	
	public static String limparString(String valor) {
		/*
		 * método para remover caracteres especiais do nome do produto
		 * e então formatá-lo para comparar o nome do produto selecionado com 
		 * o nome que aparece na url de Detalhes do produto 
		 */
		String []caracteresParaRemocao= {",", " ", "'", ".", "´", "^", "~"};
		String resultado= valor;
		
		for(String caracter: caracteresParaRemocao) {
			if(resultado.contains(caracter)) {
				if(caracter.equals(" ")) {
					resultado= resultado.replace(caracter, "-");
				} else {
						resultado= resultado.replace(caracter, "");
					}
			}
		}
		
		resultado= removerAcentos(resultado);
		return resultado;
	}
	
	public static String removerAcentos(String valor) {
	    String stringNormalizada = Normalizer.normalize(valor, Normalizer.Form.NFD); 
	    Pattern padrao = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return padrao.matcher(stringNormalizada).replaceAll("");
	}
	
	public static void verificarDirecionadoPaginaDetalhesProduto() {
		String nomeProduto= limparString(HomePage.nomeProdutoSelecionadoListasugestoes);
		
		aguardarPaginaSerCarregada(3000);
		
		Assert.assertTrue(driver.getCurrentUrl().toString().toUpperCase().contains(nomeProduto.toUpperCase()));
	}
}
