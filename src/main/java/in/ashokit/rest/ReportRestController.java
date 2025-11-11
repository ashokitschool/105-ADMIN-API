package in.ashokit.rest;

import in.ashokit.dto.ReportFilterDto;
import in.ashokit.service.ReportService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportRestController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/orders/report")
    public ResponseEntity<byte[]> generateExcelReport(@RequestBody ReportFilterDto reportFilterDto) throws Exception {

        byte[] excelData = reportService.generateReport(reportFilterDto);

        String fileName = "Orders_Report_" + System.currentTimeMillis() + ".xls";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.ms-excel"));
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return ResponseEntity.ok()
                .headers(headers)
                .body(excelData);

    }
}
