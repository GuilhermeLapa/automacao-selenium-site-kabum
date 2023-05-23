# encoding: iso-8859-1
@Testar
Feature: Carrinho

Scenario Outline: Validar Produto Adicionado ao Carrinho
	Given que acesso o site "<site>"
	And ha o campo de busca
	When escrevo valor para busca "<produto>"
	And verifico a lista de sugestoes
	And clico na sugestao desejada 1
	And sou direcionado para os detalhes do produto
	And verifico que ha o campo CEP
	And digito o CEP "<cep>"
	And verifico que ha o botao OK
	And clico no botao OK
	And verifico que ha o modal calcular frete
	And fecho o modal calcular frete
	And verifico que ha o botao Comprar
	And clico no botao Comprar
	And sou direcionado para o Precarrinho
	And verifico se ha opcao garantia estendida
	And verifico que ha o botao Ir Para o Carrinho
	And clico no botao Ir Para o Carrinho
	And sou direcionado para o Carrinho
	Then verifico que o produto selecionado esta no carrinho
	Examples: 
	| site                      | produto     | cep       |
	| https://www.kabum.com.br/ | notebook    | 50030-260 |
	| https://www.kabum.com.br/ | notebook lg | 50030-260 |
