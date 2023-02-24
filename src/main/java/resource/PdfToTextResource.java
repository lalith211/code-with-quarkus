package resource;

import org.glassfish.jersey.media.multipart.FormDataParam;
import service.ImageToTextConverter;
import service.PdfToImageConverter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
@Path("/pdf-to-text")
public class PdfToTextResource {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String convertPdfToText(@FormDataParam("pdfFile") File pdfFile) throws IOException, Exception {
        String tempImagePath = "temp.png"; // temporary image file path
        PdfToImageConverter.convert(pdfFile.getAbsolutePath(), tempImagePath);
        String result = ImageToTextConverter.convert(tempImagePath);
        Files.deleteIfExists(Paths.get(tempImagePath)); // delete temporary image file
        System.out.println(result);
        return result;
    }
}