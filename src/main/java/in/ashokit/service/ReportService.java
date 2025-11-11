package in.ashokit.service;

import in.ashokit.dto.ReportFilterDto;

public interface ReportService {

    public byte[] generateReport(ReportFilterDto filterDto) throws Exception;
}
