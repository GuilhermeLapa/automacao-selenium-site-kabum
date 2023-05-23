package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import page.CarrinhoPage;

public class CarrinhoSteps {
	@Then("verifico que o produto selecionado esta no carrinho")
	public static void verificoQueOProdutoSelecionadoEstaNoCarrinho() {
		CarrinhoPage.verificarQueOProdutoSelecionadoEstaNoCarrinho();
	}
	
	@And("sou direcionado para o Carrinho")
	public static void souDirecionadoParaOCarrinho() {
		CarrinhoPage.verificarDirecionadoPaginaCarrinho();
	}
}
