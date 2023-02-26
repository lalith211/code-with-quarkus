package resource;

import DTO.DataDto;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PdfToTextRepository;
import service.ImageToTextConverter;
import service.PdfToImageConverter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Path("/")
@RequestScoped
public class PdfToTextResource {
    @Inject
    ImageToTextConverter imageToTextConverter;
    @Autowired
    PdfToTextRepository pdfToTextRepository;

    @POST
    @Path("/pdf-to-text")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String convertPdfToText(@FormDataParam("pdfFile") File pdfFile) throws IOException, Exception {
        String tempImagePath = "temp.png"; // temporary image file path
        PdfToImageConverter.convert(pdfFile.getAbsolutePath(), tempImagePath);
        String result = imageToTextConverter.convert(tempImagePath);
        Files.deleteIfExists(Paths.get(tempImagePath)); // delete temporary image file
        System.out.println(result);
        return result;
    }

    @GET
    @Path("/get-bill-details/{BillNo}")
    public Optional<DataDto> gettingBillData(@PathParam("BillNo") String billNo) {
        return this.pdfToTextRepository.findById(billNo);
    }

}