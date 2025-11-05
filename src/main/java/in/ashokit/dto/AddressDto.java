package in.ashokit.dto;

import lombok.Data;

@Data
public class AddressDto {

    private Integer addrId;
    private String hno;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String addrType;

}
