package fileOperation;

import model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteOperation {

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

    static void writeToExcelFile(XSSFWorkbook workbook,File file) throws IOException {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            Row row = sheet.createRow(sheet.getLastRowNum());
            Student student = getStudent();
            for (int j = 0; j < 6; j++) {
                Cell cell = row.createCell(j);
                switch (j) {
                    case 0:
                        cell.setCellValue(student.getId());
                        break;
                    case 1:
                        cell.setCellValue(student.getName());
                        break;
                    case 2:
                        cell.setCellValue(student.getSub1Score());
                        break;
                    case 3:
                        cell.setCellValue(student.getSub2Score());
                        break;
                    case 4:
                        cell.setCellValue(student.getSub3Score());
                        break;
                    case 5:
                        cell.setCellValue(student.getFinalScore());
                        break;

                }

            }
        }
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();
    }


    static private Student getStudent() {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id: ");
        student.setId(sc.nextInt());
        System.out.println("Enter student name: ");
        student.setName(sc.next());
        System.out.println("Enter student score in subject 1: ");
        student.setSub1Score(sc.nextDouble());
        System.out.println("Enter student score in subject 2: ");
        student.setSub2Score(sc.nextDouble());
        System.out.println("Enter student score in subject 3: ");
        student.setSub3Score(sc.nextDouble());
        System.out.println("Enter student final score: ");
        student.setFinalScore(sc.nextDouble());
        return student;

    }
}
