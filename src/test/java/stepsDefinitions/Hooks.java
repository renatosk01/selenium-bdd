package stepsDefinitions;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.EvidenciaWord;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends DriverFactory {

    EvidenciaWord evidenciaWord = new EvidenciaWord();

    @Before
    public void instanciaDriver(Scenario scenario) {
        evidenciaWord.criaTabela();
        evidenciaWord.criaLinhaTabela("Nome do cenário", scenario.getName());
        evidenciaWord.criaLinhaTabela("Descrição", "Cenário 1");
//        evidenciaWord.criaLinhaTabela("Nome do cenário", scenario.getName());
        iniciarDriver();

    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException, AWTException {
        SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyyMMdd-HHmmss-SSS");
        String fileName = formatoDeData.format(new Date());
        String shotName = String.format("%s.png", fileName);
        File finalShotFile = new File("evidencias", shotName);
        File shotFile = ((TakesScreenshot) pegaDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(shotFile, finalShotFile);
        evidenciaWord.anexarEvidenciaWord("evidencias/" + shotName, scenario);
//        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
//        ImageIO.write(image, "png", new File("evidencias/"+ fileName + ".png"));

    }

//    @AfterStep
//    public void takeScreenshot(Scenario scenario) {
//        byte[] screenshot = ((TakesScreenshot) pegaDriver()).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", scenario.getName());
//    }

    @After
    public void finalizaDriver() throws IOException{
        evidenciaWord.salvarDocumentoWord("evidencia-word");
        pegaDriver().quit();
    }

}
