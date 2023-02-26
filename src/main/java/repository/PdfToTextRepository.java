package repository;

import DTO.DataDto;
import org.springframework.data.repository.CrudRepository;

public interface PdfToTextRepository extends CrudRepository<DataDto, String> {

}