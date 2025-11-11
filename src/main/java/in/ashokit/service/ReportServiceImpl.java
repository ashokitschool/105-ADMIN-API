package in.ashokit.service;

import in.ashokit.dto.ReportFilterDto;
import in.ashokit.entity.OrderEntity;
import in.ashokit.repo.OrderRepo;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public byte[] generateReport(ReportFilterDto filterDto) throws Exception {

        OrderEntity entity = new OrderEntity();

        if (filterDto.getOrderStatus() != null & !"".equals(filterDto.getOrderStatus())) {
            entity.setOrderStatus(filterDto.getOrderStatus());
        }

        List<OrderEntity> ordersList = orderRepo.findAll(Example.of(entity));


        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        HSSFRow headerRow = sheet.createRow(0);

        headerRow.createCell(0).setCellValue("S.No");
        headerRow.createCell(1).setCellValue("Order Tracking Number");
        headerRow.createCell(2).setCellValue("Customer Email");
        headerRow.createCell(3).setCellValue("Order Created Date");
        headerRow.createCell(4).setCellValue("Total Amount");
        headerRow.createCell(5).setCellValue("Total Quantity");
        headerRow.createCell(6).setCellValue("Order Status");
        headerRow.createCell(7).setCellValue("Razorpay Order ID");
        headerRow.createCell(8).setCellValue("Razorpay payment ID");

        int dataRowIndex = 1;
        int sno = 1;

        for (OrderEntity order : ordersList) {

            HSSFRow dataRow = sheet.createRow(dataRowIndex);

            dataRow.createCell(0).setCellValue(sno);
            dataRow.createCell(1).setCellValue(order.getOrderTrackingNum());
            dataRow.createCell(2).setCellValue(order.getCustomerEmail());
            dataRow.createCell(3).setCellValue(order.getDateCreated());
            dataRow.createCell(4).setCellValue(order.getTotalPrice());
            dataRow.createCell(5).setCellValue(order.getTotalQuantity());
            dataRow.createCell(6).setCellValue(order.getOrderStatus());
            dataRow.createCell(7).setCellValue(order.getRazorpayOrderId());
            dataRow.createCell(8).setCellValue(order.getRazorpayPaymentId());

            dataRowIndex++;
            sno++;

        }

        // write workbook data to byte[]
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);

        return bos.toByteArray();
    }
}
