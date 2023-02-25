package DTO;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "datadto")
public class DataDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billNo;

    private String date;

    private String name;

    private String truckNum;

    private String status;

    private String address;

    private String phone;

    private String amount;
}
