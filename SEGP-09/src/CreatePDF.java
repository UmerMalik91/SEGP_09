
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
	public void createPDF(ArrayList<ArrayList<String>> Data,String fileName){ 
		try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(Data.get(0).size());
        
            int row=0;
            for(ArrayList<String> a: Data){
            	for (int i = 0; i <Data.get(0).size() ; i++) {
                    pdfTable.addCell(Data.get(row).get(i));
                }
            	row ++;
							}

            doc.add(pdfTable);
            doc.close();
            JOptionPane.showConfirmDialog(null, "All data converted  into PDF file",
                    "", JOptionPane.OK_OPTION);
        } catch (DocumentException ex) {
        	JOptionPane.showMessageDialog(null, "Could not open file",
        			"Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
        	JOptionPane.showMessageDialog(null, "Could not open file",
        			"Error", JOptionPane.ERROR_MESSAGE);
            
            
        }
		
	}

}
