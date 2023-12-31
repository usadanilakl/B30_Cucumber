package cydeo.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Write {
    @Test
    public void test() throws IOException {
        FileInputStream in = new FileInputStream("Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFCell cell = sheet.createRow(1).createCell(0);
        cell.setCellValue("Bye");
        FileOutputStream out = new FileOutputStream("Data.xlsx");
        workbook.write(out);

        in.close();
        workbook.close();
        out.close();
    }
}
