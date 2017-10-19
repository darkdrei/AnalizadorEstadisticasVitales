/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.word;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author E7250
 */
public class Word {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        XWPFDocument document = new XWPFDocument();
        
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run  = paragraph.createRun();
        run.setText("Paquete");
        run.setText(" and Nutela");
        run.addBreak();
        run.setText("Tengo hambre");
        
        XWPFParagraph paragraph2 = document.createParagraph();
        XWPFRun run2  = paragraph2.createRun();
        run2.setText("Estilo ninja");
        try{
            FileOutputStream output = new FileOutputStream("Respuesta.docx");
            document.write(output);
            output.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
