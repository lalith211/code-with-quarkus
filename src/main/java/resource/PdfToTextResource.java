package resource;

import DTO.DataDto;
import io.smallrye.mutiny.Uni;
import org.glassfish.jersey.media.multipart.FormDataParam;
import service.Converter;
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

@Path("/")
@RequestScoped
public class PdfToTextResource {
    @Inject
    ImageToTextConverter imageToTextConverter;
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

//    @GET
//    @Path("/get-bill-details")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Uni<DataDto> gettingBillData(@PathParam("billNo") long billNo){
//        return DataDto.findById(billNo);
//    }
}