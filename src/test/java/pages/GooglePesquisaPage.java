package pages;

import core.CommonsBasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class GooglePesquisaPage extends CommonsBasePage {

    static WebDriverWait wait;
    static WebElement pesquisaGoogle;
    static WebElement botaoPesquisaGoogle;
    By elementoPesquisaGoogle = By.name("q");
    By elementoBotaoPesquisa = By.name("btnK");

//    public GooglePesquisaPage(){
//        wait = new WebDriverWait(pegaDriver(), 15);
//    }

    public void navegaGoogle(){
        navegaAteSite("https://www.google.com");
//        pegaDriver().get("https://www.google.com");
//        pegaDriver().manage().window().maximize();
    }

    public void validaUrlGoogle(){
        validaCondicaoVerdadeira("url não carregou", pegaDriver().getCurrentUrl().contains("google"));
//        assertTrue("url não carregou", pegaDriver().getCurrentUrl().contains("google"));
    }

    public void validaPaginaGoogle(String palavra){
        validaCondicaoVerdadeira("palavra" + palavra + " não apareceu", pegaDriver().getPageSource().contains(palavra));
//        assertTrue("palavra pesquisa não apareceu", pegaDriver().getPageSource().contains("Pesquisa"));
    }

    public void pesquisaTexto(String textoPesquisar){
        preencheTextoElemento(elementoPesquisaGoogle, textoPesquisar);
//        pesquisaGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementoPesquisaGoogle)));
//        pesquisaGoogle.sendKeys("Everis");
    }

    public void realizaScrollBotao(){
        scrollAteElemento(validarElementoApareceu(elementoBotaoPesquisa));
//        botaoPesquisaGoogle = wait.until(ExpectedConditions.elementToBeClickable(By.name(elementoBotaoPesquisa)));
//        ((JavascriptExecutor)pegaDriver()).executeScript("arguments[0].scrollIntoView(true);", botaoPesquisaGoogle);
    }

    public void clicarBotaoPesquisa(){
        clicarElemento(elementoBotaoPesquisa);
//        botaoPesquisaGoogle.click();
    }

}
