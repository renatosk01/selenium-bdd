package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class CommonsBasePage extends DriverFactory{

    WebDriverWait wait = new WebDriverWait(pegaDriver(), 15);

    public WebElement validarElementoApareceu(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

//    public String recuperarTexto(String texto){
//        return texto;
//    }

    public void clicarElemento(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void preencheTextoElemento(By by, String texto){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(texto);
    }

    public void navegaAteSite(String site){
        pegaDriver().get(site);
        pegaDriver().manage().window().maximize();
    }

    public void scrollAteElemento(WebElement elemento){
        ((JavascriptExecutor)pegaDriver()).executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public void validaCondicaoVerdadeira(String mensagemFalha, Boolean condicao){
        assertTrue(mensagemFalha, condicao);
    }

}
