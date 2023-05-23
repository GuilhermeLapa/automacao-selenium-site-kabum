package steps;

import io.cucumber.java.en.And;
import page.PreCarrinhoPage;

public class PreCarrinhoStep {
	@And("verifico que ha o botao Ir Para o Carrinho")
	public void verificoQueHaOBotaoIrParaOCarrinho() {
		PreCarrinhoPage.inicializarBtnIrParaOCarrinho();
	}
	
	@And("clico no botao Ir Para o Carrinho")
	public static void clicoNoBotaoIrParaOCarrinho() {
		PreCarrinhoPage.clicarBtnIrParaOCarrinho();
	}
	
	@And("sou direcionado para o Precarrinho")
	public static void souDirecionadoParaOPreCarrinho() {
		PreCarrinhoPage.verificarDirecionadoPaginaPreCarrinho();
	}
	
	@And("verifico se ha opcao garantia estendida")
	public static void verificoSeHaOpcaoGarantiaEstendida() {
		PreCarrinhoPage.opcaoGarantiaEstendida();
	}
}
