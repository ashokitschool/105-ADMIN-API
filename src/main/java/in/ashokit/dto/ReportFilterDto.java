package in.ashokit.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportFilterDto {

    private String orderStatus;

    private LocalDate fromDate;

    private LocalDate toDate;
}
