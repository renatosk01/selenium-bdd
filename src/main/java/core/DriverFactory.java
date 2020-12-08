package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public void iniciarDriver(){
        driver = new ChromeDriver();
    }

    public WebDriver pegaDriver(){
        return driver;
    }

}
