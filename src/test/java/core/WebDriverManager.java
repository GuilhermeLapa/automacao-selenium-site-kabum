package core;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
	protected static WebDriver driver;
	
	protected static void criarDriver(TiposBrowser nomeBrowser) {
		switch (nomeBrowser) {
		case Chrome:
			//instanciamos o driver como um driver do Chrome Browser
			driver= new ChromeDriver(ChromeDriverManager.criarDriver());
			break;
		default:
			break;
		}
		
		//solicita ao webdriver que espere um determinado tempo padrão 
		WebDriverManager.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		//solicita ao driver que maximize a tela assim que abri-la
		WebDriverManager.driver.manage().window().maximize();
	}
	
	protected static void fecharDriver() {
		if(driver != null) {
			driver.quit();
			driver= null;
		}
	}
	
	protected static WebDriver iniciarDriver(TiposBrowser nomeBrowser) {
		if(driver == null) {
			criarDriver(nomeBrowser);
		}
		
		return driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	protected static void acessarPaginaSite(String url) {
		driver.get(url);
	}
	
	protected static void aguardarPresencaElemeto(TiposSeletores tipoSeletor, String caminho, long tempoMiliseg) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(tempoMiliseg));
		
		switch (tipoSeletor) {
			case XPATH:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(caminho)));
				break;
			case CSS:
				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(caminho)));
				break;
		default:
			break;
		}
	}
	
	protected static void aguardarElemetoVisivel(TiposSeletores tipoSeletor, String caminho, long tempoMiliseg) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(tempoMiliseg));
		
		switch (tipoSeletor) {
			case XPATH:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(caminho)));
				break;
			case CSS:
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(caminho)));
				break;
		default:
			break;
		}
	}
	
	protected static void aguardarElemetoVisivel(WebElement elemento, long tempoMiliseg) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(tempoMiliseg));
		wait.until(ExpectedConditions.visibilityOf(elemento));
	}
	
	protected static void aguardarElemetoClicavel(WebElement elemento, long tempoMiliseg) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(tempoMiliseg));
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	
	protected static void aguardarElemetoClicavel(TiposSeletores tipoSeletor, String caminho, long tempoMiliseg) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(tempoMiliseg));
		
		switch (tipoSeletor) {
			case XPATH:
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(caminho)));
				break;
			case CSS:
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(caminho)));
				break;
		default:
			break;
		}
	}
	
	protected static void aguardarUrl(String url, long tempoMiliseg) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofMillis(tempoMiliseg));
		wait.until(ExpectedConditions.urlToBe(url));
	}
	
	protected static void clicarElemento(WebElement elemento) {
		aguardarElemetoVisivel(elemento, 5000);
		aguardarElemetoClicavel(elemento, 5000);
		
		try {
			elemento.click();
		}
		catch(Exception e) {
			Actions acao= new Actions(driver);
			acao.moveToElement(elemento);
			acao.click().perform();
		}
	}
	
	protected static WebElement encontrarElemento(TiposSeletores tipoSeletor, String caminho) {
		WebElement elemento= null;
		aguardarPresencaElemeto(tipoSeletor, caminho, 5000);
		
		switch (tipoSeletor) {
			case XPATH:
				driver.findElement(By.xpath(caminho));
				break;
			case CSS:
				driver.findElement(By.cssSelector(caminho));
				break;
			default:
				break;
		}
		
		return elemento;
	}
	
	protected static ArrayList<WebElement> encontrarListaElementos(TiposSeletores tipoSeletor, String caminho) {
		ArrayList<WebElement> listaElementos= new ArrayList<WebElement>();
		aguardarPresencaElemeto(tipoSeletor, caminho, 5000);
		
		switch (tipoSeletor) {
			case XPATH:
				driver.findElements(By.xpath(caminho));
				break;
			case CSS:
				driver.findElements(By.cssSelector(caminho));
				break;
			default:
				break;
		}
		
		return listaElementos;
	}
	
	protected static void escreverCampo(WebElement elemento, String valor) {
		aguardarElemetoVisivel(elemento, 5000);
		elemento.sendKeys(valor);
	}
}
