package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class HomeEverisPage extends DriverFactory {

    WebDriverWait wait;
    Actions builder;
    WebElement menuAboutUs;
    WebElement menuWhatWeDo;
    WebElement ancoraTechnology;
    String linkAboutUs = "about us";
    String linkWhatWeDo = "//*[@id='block-system-main-menu']/ul/li[1]";
    String linkTechnology = "technology";

    public HomeEverisPage(){
        wait = new WebDriverWait(pegaDriver(), 15);
        builder = new Actions(pegaDriver());
    }

    public void validaUrlEveris(){
        assertTrue("Url não contém everis", wait.until(ExpectedConditions.urlContains("everis")));
    }

    public void clicaMenuAboutUs(){
        menuAboutUs = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(linkAboutUs)));
        menuAboutUs.click();
    }

    public void hoverMenuWhatWeDo(){
        menuWhatWeDo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(linkWhatWeDo)));
        builder.moveToElement(menuWhatWeDo).build().perform();
    }

    public void clicaMenuTechnology(){
        ancoraTechnology = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkTechnology)));
        ancoraTechnology.click();
    }

}
