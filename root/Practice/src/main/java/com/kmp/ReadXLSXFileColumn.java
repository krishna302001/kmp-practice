package com.kmp;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReadXLSXFileColumn {
    public static void main(String[] args) throws IOException {
         String folderpath = "C:\\temp\\toDelete";
        folderpath = "C:\\ExcelSheets\\InputFiles";
        File dir = new File(folderpath);
        File[] fileArray = dir.listFiles();
        List<String> fileNameList = Arrays.stream(fileArray)
                .map(file -> file.getAbsolutePath())
                .collect(Collectors.toList());
        Set<String> assetTypeSet = new HashSet<>();
        for (String fileName : fileNameList) {

            FileInputStream file = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("Controlled Lists");

            if (sheet != null) {
                Row topRow = sheet.getRow(0);
                System.out.println(topRow.getCell(0) + " " + topRow.getCell(1) + " " + topRow.getCell(2) + fileName);

                for (int count = 1; count < sheet.getLastRowNum(); count++) {
                    Row row = sheet.getRow(count);
                    Cell cell = row.getCell(1);
                    if(cell!=null){
                        String assetType = cell.getStringCellValue();
                        if(assetType!=null){
                            System.out.println(assetType);
                            assetTypeSet.add(assetType);
                        }
                    }
                }
            }
        }
        List list = new ArrayList<>(assetTypeSet);
        Collections.sort(list);
        System.out.println(list.toString());
    }

    /*public static void main(String[] args) throws IOException {
        final String folderpath = "C:\\temp\\toDelete";
        File dir = new File(folderpath);
        File[] fileArray = dir.listFiles();
        List<String> fileNameList = Arrays.stream(fileArray)
                .map(file -> file.getAbsolutePath())
                .collect(Collectors.toList());
        Set<String> assetTypeSet = new HashSet<>();
        for (String fileName : fileNameList) {

            FileInputStream file = new FileInputStream(fileName);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheet("Controlled Lists");

            if (sheet != null) {
                Row topRow = sheet.getRow(0);
                System.out.println(topRow.getCell(0) + " " + topRow.getCell(1) + " " + topRow.getCell(2));

                for (int count = 1; count < sheet.getLastRowNum(); count++) {
                    Row row = sheet.getRow(count);
                    Cell cell = row.getCell(0);
                    if(cell!=null){
                        String assetType = cell.getStringCellValue();
                        if(assetType!=null){
                            System.out.println(assetType);
                            assetTypeSet.add(assetType);
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(assetTypeSet.toString());
    }*/
}
