package utils;

import io.cucumber.java.Scenario;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;

public class EvidenciaWord {

    XWPFDocument documentoWord;
    XWPFParagraph paragrafoWord;
    XWPFTable tabelaWord;
    XWPFRun run;
    int contador = 0;

    public EvidenciaWord(){
        documentoWord = new XWPFDocument();
    }

    public void criaParagrafo(){
        paragrafoWord = documentoWord.createParagraph();
        run = paragrafoWord.createRun();
    }

    public void criaTabela(){
        tabelaWord = documentoWord.createTable();
        tabelaWord.setTableAlignment(TableRowAlign.CENTER);
        tabelaWord.setWidth(8000);
    }

    public void criaLinhaTabela(String identificador, String textoDescricao){
        criaParagrafo();
        XWPFTableRow linhaTabela;
        if(contador == 0)
        {
            linhaTabela = tabelaWord.getRow(0);
            contador++;
        }
        else {
            linhaTabela = tabelaWord.createRow();
        }
        linhaTabela.getCell(0).setText(identificador);
        linhaTabela.createCell();
        linhaTabela.getCell(1).setText(textoDescricao);

        run.addBreak();
    }

    public void anexarEvidenciaWord(String evidencia, Scenario scenario) {
        try{
            criaParagrafo();
            paragrafoWord.setAlignment(ParagraphAlignment.CENTER);
            InputStream screenshot = new FileInputStream(evidencia);
            run.addPicture(screenshot, Document.PICTURE_TYPE_PNG, scenario.getName(), Units.toEMU(350), Units.toEMU(250));
            run.addBreak();
        }catch (IOException | InvalidFormatException ex){
            ex.printStackTrace();
        }

    }

    public void salvarDocumentoWord(String nomeDocumento){
        try{
            OutputStream documentoFinalWord = new FileOutputStream("evidencias/"+nomeDocumento+".docx");
            documentoWord.write(documentoFinalWord);
            documentoWord.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
