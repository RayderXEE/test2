package com.example.demo.test;

import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;
import java.util.function.Consumer;

public class ExcelConsumer implements Consumer<List<String>> {

    public final String pathName = "output.xlsx";

    public final Workbook workbook;
    private final Sheet sheet;

    public ExcelConsumer() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet();
    }

    @SneakyThrows
    @Override
    public synchronized void accept(List<String> list) {
        System.out.println(list);
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);

        for (String s : list) {
            Cell cell = row.createCell(row.getLastCellNum() == -1 ? 0 : (row.getLastCellNum()));
            cell.setCellValue(s);
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(pathName)) {workbook.write(fileOutputStream);}
    }
}
