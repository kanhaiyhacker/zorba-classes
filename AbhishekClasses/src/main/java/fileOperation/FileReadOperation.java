package fileOperation;

import model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class FileReadOperation {
    // store the student data retrieve from the student Excel sheet.
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/students.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            readExcelFile(workbook);
            System.out.println(studentList);
            workbook.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    // method to read the excel file
    private static void readExcelFile(XSSFWorkbook workbook) {
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue;
                }
                studentList.add(getStudent(row));
            }

        }
    }


    // method to get the student for a single row
    private static Student getStudent(Row row) {
        Student student = new Student();
        for (Cell cell : row) {
            switch (cell.getColumnIndex()) {
                case 0:
                    student.setId((int) cell.getNumericCellValue());
                    break;

                case 1:
                    student.setName(cell.getStringCellValue());
                    break;
                case 2:
                    student.setSub1Score(cell.getNumericCellValue());
                    break;
                case 3:
                    student.setSub2Score(cell.getNumericCellValue());
                    break;
                case 4:
                    student.setSub3Score(cell.getNumericCellValue());
                    break;
                case 5:
                    student.setFinalScore(cell.getNumericCellValue());
                    break;
            }

        }
        return student;
    }

}
