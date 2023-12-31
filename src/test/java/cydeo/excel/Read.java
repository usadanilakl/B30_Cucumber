package cydeo.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Read {
    @Test
    public void read() throws IOException {
        FileInputStream in = new FileInputStream("Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getRow(0).getCell(0));
    }
}
