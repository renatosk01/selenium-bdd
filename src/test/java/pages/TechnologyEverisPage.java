package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class TechnologyEverisPage extends DriverFactory {

    WebDriverWait wait;
    WebElement h1Technology;
    String textoTechnology = "//*[@id='header_bgmedia']//h1";

    public TechnologyEverisPage(){
        wait = new WebDriverWait(pegaDriver(), 15);
    }

    public void validaPaginaTechnology(){
        h1Technology = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textoTechnology)));
        assertEquals("technology", h1Technology.getText());
    }
}
