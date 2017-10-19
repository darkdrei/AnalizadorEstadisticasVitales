/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.word;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author E7250
 */
public class Word2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        XWPFDocument document = new XWPFDocument();
        
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run  = paragraph.createRun();
        run.setText("Paquete");
        run.setFontSize(25);
        run.setFontFamily("Arial Black");
        run.setBold(true);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        
        XWPFTable table = document.createTable();
        table.setInsideHBorder(XWPFTable.XWPFBorderType.THICK, 3, 2, "9965F3");
        table.setCellMargins(10, 10, 0, 0);
        XWPFTableRow row0 = table.getRow(0);
        XWPFTableCell cell0 = row0.getCell(0);
        XWPFParagraph par = cell0.addParagraph();
        XWPFRun par_run = par.createRun();
        par_run.setFontFamily("Arial Black");
        par_run.setFontSize(20);
        cell0.setColor("9965F3");
        par_run.setText("Codigo del registro");
        par_run.setBold(true);
        
        XWPFTableCell cell1 = row0.createCell();
        XWPFParagraph par1 = cell1.addParagraph();
        XWPFRun par_run1 = par1.createRun();
        par_run1.setFontFamily("Arial Black");
        par_run1.setFontSize(20);
        cell1.setColor("9965F3");
        par_run1.setText("Fecha de entrega");
        par_run.setBold(true);
        
        XWPFTableRow row1 = table.createRow();
        XWPFTableCell cell11 = row1.getCell(0);
        cell11.setText("dsdsd");
//        run.setText(" and Nutela");
//        run.addBreak();
//        run.setText("Tengo hambre");
//        
//        XWPFParagraph paragraph2 = document.createParagraph();
//        XWPFRun run2  = paragraph2.createRun();
//        run2.setText("Estilo ninja");
        try{
            FileOutputStream output = new FileOutputStream("Respuesta.docx");
            document.write(output);
            output.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
