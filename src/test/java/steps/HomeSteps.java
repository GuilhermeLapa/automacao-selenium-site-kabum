package steps;

import core.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import page.HomePage;

public class HomeSteps {
	@Given("que acesso o site {string}")
	public static void queAcessoOSite(String url) {
		HomePage.acessarSite(url);
	}
	
	@When("ha o campo de busca")
	public static void haOCampoDeBusca() {
		HomePage.inicializarCampoBusca();
	}
	
	@When("escrevo valor para busca {string}")
	public static void escrevoValorParaBusca(String nomeProduto) {
		HomePage.escreverValorbusca(nomeProduto);
	}
	@And("verifico a lista de sugestoes")
	public static void verificoAListaDeSugestoes() {
		HomePage.verificarListaSugestoesBusca();
	}
	
	@And("clico na sugestao desejada {int}")
	public static void clicoNaSugestaoDesejada(int opcaoDesejada) {
		HomePage.clicarOpcaoSugestaoBusca(opcaoDesejada);
	}
	
	@After
	public void fecharBrowser() {
		WebDriverManager.fecharDriver();
	}
}
