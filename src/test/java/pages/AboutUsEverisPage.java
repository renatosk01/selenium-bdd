package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class AboutUsEverisPage extends DriverFactory {

    WebDriverWait wait;
    WebElement textoH1AboutUs;
    String classNameAboutUsTitulo = "#block-system-main h1";

    public AboutUsEverisPage(){
        wait = new WebDriverWait(pegaDriver(), 15);
    }

    public void validaTextoAboutUs(){
        textoH1AboutUs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(classNameAboutUsTitulo)));
        assertEquals("about us", textoH1AboutUs.getText());
    }

}
