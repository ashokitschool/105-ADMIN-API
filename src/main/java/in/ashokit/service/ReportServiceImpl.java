package in.ashokit.service;

import in.ashokit.dto.ReportFilterDto;

public class ReportServiceImpl implements ReportService{
    @Override
    public byte[] generateReport(ReportFilterDto filterDto) {
        return new byte[0];
    }
}
