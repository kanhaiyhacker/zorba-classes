package fileOperation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelAddNewColumn {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/students.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            writeToExcelFile(workbook, file);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static private void writeToExcelFile(XSSFWorkbook workbook, File file) throws IOException {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    if (alreadyHasGradeColumn(row)) return;
                    else {
                        Cell cell = row.createCell(row.getLastCellNum());
                        cell.setCellStyle(row.getCell(0).getCellStyle());
                        cell.setCellValue("Grade");
                    }
                } else {
                    double finalScore = row.getCell(row.getLastCellNum() - 1).getNumericCellValue();
                    Cell cell = row.createCell(row.getLastCellNum());
                    cell.setCellValue(getGrades(finalScore));
                }
            }
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
    }

    // check if already graded
    static private boolean alreadyHasGradeColumn(Row row) {
        String lastColumnName = row.getCell(row.getLastCellNum() - 1).getStringCellValue();
        return lastColumnName.equalsIgnoreCase("Grade");
    }

    // get grades for the student
    static public String getGrades(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C+";
        else if (marks >= 40) return "C";
        else if (marks >= 30) return "D+";
        else return "F";

    }

}
