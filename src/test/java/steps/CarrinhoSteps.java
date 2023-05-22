package steps;

import io.cucumber.java.en.When;
import page.CarrinhoPage;

public class CarrinhoSteps {
	@When("que acesso o site {string}")
	public static void queAcessoOSite(String enderecoSite) {
		CarrinhoPage.acessarSite(enderecoSite);
	}
}
