package com.example.demo.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestListProvider  {

    public final String pathName = "input.xlsx";

    public List<List<String>> getList() {
        DataFormatter formatter = new DataFormatter();
        List<List<String>> list = new ArrayList<>();
        try(FileInputStream fileInputStream = new FileInputStream(pathName)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                ArrayList<String> list1 = new ArrayList<>();
                list.add(list1);
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    list1.add(formatter.formatCellValue(cell));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
