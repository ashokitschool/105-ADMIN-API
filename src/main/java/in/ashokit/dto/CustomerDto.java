package in.ashokit.dto;

import lombok.Data;


@Data
public class CustomerDto {

    private Integer customerId;
    private String name;
    private String email;
    private String phoneNo;

}
