package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DTO.DataDto;

@Repository
public interface PdfToTextRepository extends JpaRepository<DataDto, Integer> {

}