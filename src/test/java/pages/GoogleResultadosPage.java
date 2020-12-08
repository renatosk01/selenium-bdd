package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class GoogleResultadosPage extends DriverFactory {

    WebDriverWait wait;
    WebElement textoDestaque;
    WebElement homeEveris;
    String elementoTextoDestaque = "//*[@id='kp-wp-tab-overview']/div/div/div/div/div[1]/div/div/div/div/span[1]";
    String textoDestaqueCapturado = "";
    String linkHomeEveris = "everis Brazil";

    public GoogleResultadosPage(){
        wait = new WebDriverWait(pegaDriver(), 15);
    }

    public void capturaTextoDestaque(){
        textoDestaque = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementoTextoDestaque)));
        textoDestaqueCapturado = textoDestaque.getText();
        System.out.println(textoDestaqueCapturado);
    }

    public void validaTextoDestaqueEveris(){
        assertTrue("Texto destaque não possui palavra everis", textoDestaqueCapturado.contains("everis"));
    }

    public void clicaOpcaoEverisHome(){
        homeEveris = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(linkHomeEveris)));
        homeEveris.click();
    }

}
