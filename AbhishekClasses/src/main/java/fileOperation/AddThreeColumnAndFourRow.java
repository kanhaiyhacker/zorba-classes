package fileOperation;

import model.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class AddThreeColumnAndFourRow {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/students.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            writeToExcelFile(workbook, file);
            fileInputStream.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeToExcelFile(XSSFWorkbook workbook, File file) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            ///  add column to table
            addThreeColumn(sheet);
            /// update old data in row
            updateOldColumns(sheet, scanner);
            ///  add new data in row
            addNewStudents(scanner, sheet);

        }

        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        out.close();
        scanner.close();

    }

    // update old colum with the new data
    private static void updateOldColumns(XSSFSheet sheet, Scanner scanner) {
        for (Row row : sheet) {
            if (row.getRowNum() == 0) continue;
            if (row.getLastCellNum() == 10) continue;
            for (int i = 0; i < 3; i++) {
                Cell cell = row.getCell(7 + i);
                ///  if cell is not already added or updated
                if (cell == null || cell.getStringCellValue() == null) {
                    Cell newCell = row.createCell(7 + i);
                    String cellValue = getStringInput(scanner, i, row.getCell(1).getStringCellValue());
                    newCell.setCellValue(cellValue);
                }
            }

        }
    }

    private static void addThreeColumn(XSSFSheet sheet) {
        if (sheet.getLastRowNum() > 0) {
            XSSFRow row = sheet.getRow(0);
            int lastColumn = row.getLastCellNum() - 1;

            if (row.getCell(lastColumn).getStringCellValue().equalsIgnoreCase("Grade")) {
                CellStyle cellStyle = row.getCell(row.getLastCellNum() - 1).getCellStyle();
                for (int j = 1; j <= 3; j++) {
                    Cell cell = row.createCell(lastColumn + j);
                    cell.setCellStyle(cellStyle);
                    switch (j) {
                        case 1:
                            cell.setCellValue("Location");
                            break;
                        case 2:
                            cell.setCellValue("Mobile");
                            break;
                        case 3:
                            cell.setCellValue("Email");
                            break;
                    }
                }


            }
        }
    }

    private static void addNewStudents(Scanner scanner, XSSFSheet sheet) {
        System.out.println("Enter number of students: ");
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            XSSFRow row = sheet.createRow(sheet.getLastRowNum() + i + 1);
            final Student student = getNewStudent(scanner);
            System.out.println(student);
            for (int j = 0; j < 10; j++) {
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
                    case 6:
                        cell.setCellValue(student.getGrade());
                        break;
                    case 7:
                        cell.setCellValue(student.getLocation());
                        break;
                    case 8:
                        cell.setCellValue(student.getMobile());
                        break;
                    case 9:
                        cell.setCellValue(student.getEmail());
                        break;
                    default:
                        break;

                }

            }
        }
    }

    private static Student getNewStudent(Scanner sc) {
        Student student = new Student();
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
        double finalScore = sc.nextDouble();
        student.setFinalScore(finalScore);
        student.setGrade(ExcelAddNewColumn.getGrades(finalScore));
        System.out.println("Enter student location: ");
        student.setLocation(sc.next());
        sc.nextLine();
        System.out.println("Enter student mobile: ");
        student.setMobile(sc.next());
        System.out.println("Enter student email: ");
        student.setEmail(sc.next());
        return student;
    }

    private static String getStringInput(Scanner sc, int t, String name) {
//        if (!name.isEmpty()) return "demo";
        String type = switch (t) {
            case 0 -> "location";
            case 1 -> "mobile";
            case 2 -> "email";
            default -> "";
        };
        System.out.printf("Enter %s %s: ", name, type);
        return sc.nextLine();
    }

}
