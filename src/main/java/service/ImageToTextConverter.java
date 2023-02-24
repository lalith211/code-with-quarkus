package service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import java.io.File;
public class ImageToTextConverter {
    public static String convert(String imagePath) throws Exception {
        File imageFile = new File(imagePath);
        ITesseract instance = new Tesseract();
        File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // extract Tesseract OCR data
        instance.setDatapath(tessDataFolder.getAbsolutePath());
        String result = instance.doOCR(imageFile);
        return result;
    }
}