package repository;

import DTO.DataDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfToTextRepository extends JpaRepository<DataDto, Long> {

}