package service;

import DTO.DataDto;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import repository.PdfToTextRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;

@ApplicationScoped
public class ImageToTextConverter {

    @Inject
    Converter converter;

    @Inject
    PdfToTextRepository pdfToTextRepository;

    public String convert(String imagePath) throws Exception {
        File imageFile = new File(imagePath);
        ITesseract instance = new Tesseract();
        File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // extract Tesseract OCR data
        instance.setDatapath(tessDataFolder.getAbsolutePath());
        String result = instance.doOCR(imageFile);
        DataDto example = converter.conv(result);
        pdfToTextRepository.save(example);
        return "success";
    }
}
