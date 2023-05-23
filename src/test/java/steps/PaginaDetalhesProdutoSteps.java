package steps;

import io.cucumber.java.en.And;
import page.PaginaDetalhesProdutoPage;

public class PaginaDetalhesProdutoSteps {
	@And("verifico que ha o campo CEP")
	public static void verificoQueHaOCampoCEP() {
		PaginaDetalhesProdutoPage.inicializarCampoCEP();
	}
	
	@And("verifico que ha o botao OK")
	public static void verificoQueHaOBotaoOK() {
		PaginaDetalhesProdutoPage.inicializarBtnOK();
	}
	
	@And("digito o CEP {string}")
	public static void digitoOCEP(String cep) {
		PaginaDetalhesProdutoPage.digitarCep(cep);
	}
	
	@And("clico no botao OK")
	public static void clicoNoBotaoOK() {
		PaginaDetalhesProdutoPage.clicarBtnOK();
	}
	
	@And("verifico que ha o modal calcular frete")
	public static void verificoQueHaOModalCalcularFrete() {
		PaginaDetalhesProdutoPage.inicializarElementosModalCalcularFrete();
	}
	
	@And("fecho o modal calcular frete")
	public static void fechoOModalCalcularFrete() {
		PaginaDetalhesProdutoPage.fecharModalCalcularFrete();
	}
	
	@And("verifico que ha o botao Comprar")
	public static void verificoQueHaOBotaoComprar() {
		PaginaDetalhesProdutoPage.inicializarElementosBtnComprar();
	}
	
	@And("clico no botao Comprar")
	public static void clicoNoBotaoComprar() {
		PaginaDetalhesProdutoPage.clicarBtnComprar();
	}
	
	@And("sou direcionado para os detalhes do produto")
	public static void souDirecionadoParaOsDetalhesDoProduto() {
		PaginaDetalhesProdutoPage.verificarDirecionadoPaginaDetalhesProduto();
	}
}
