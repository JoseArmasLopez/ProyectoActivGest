package recursos;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Impresor {

    private final static Logger LOGGER = Logger.getLogger("mx.hash.impresionpdf.Impresor");

    public static void main(String[] args) {

        Impresor impresor = new Impresor();

        try {
            impresor.imprimir();
        } catch (PrinterException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de impresion", "Error", JOptionPane.ERROR_MESSAGE);
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    public void imprimir() throws PrinterException, IOException {
        // Indicamos el nombre del archivo Pdf que deseamos imprimir
        PDDocument document = PDDocument.load(new File("FormularioInscripcion.pdf"));

        //muestro en pdf el documento generado
        try {
            File path = new File ("cusoinscripcion.pdf");
            Desktop.getDesktop().open(path);
        }catch (IOException ex) {
            ex.printStackTrace();
        }

        PrinterJob job = PrinterJob.getPrinterJob();

        LOGGER.log(Level.INFO, "Mostrando el dialogo de impresion");
        if (job.printDialog() == true) {
            job.setPageable(new PDFPageable(document));

            LOGGER.log(Level.INFO, "Imprimiendo documento");
            job.print();
        }
    }


}
