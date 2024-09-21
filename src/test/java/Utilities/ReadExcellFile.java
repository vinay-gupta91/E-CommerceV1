package Utilities;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcellFile {

    private static XSSFWorkbook Workbook;
    private static XSSFSheet worksheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static FileInputStream ReadFile;

    private static String FilePath = ".\\TestData\\MyWorkshop.xlsx";

    public static int getRowCount(String SheetName) throws IOException {
        ReadFile = new FileInputStream(FilePath);
        Workbook = new XSSFWorkbook(ReadFile);
        worksheet = Workbook.getSheet(SheetName);
        int RowCount = worksheet.getLastRowNum();
        Workbook.close();
        return RowCount;
    }
    public static int getColumnCount(String SheetName) throws IOException {
        ReadFile = new FileInputStream(FilePath);
        Workbook = new XSSFWorkbook(ReadFile);
        worksheet = Workbook.getSheet(SheetName);
        int CellCount = worksheet.getRow(0).getLastCellNum();
        Workbook.close();
        return CellCount;
    }

    public static String getCellValue(String SheetName, int RowNo, int ColumnNo) throws IOException {
        ReadFile = new FileInputStream(FilePath);
        Workbook = new XSSFWorkbook(ReadFile);
        worksheet = Workbook.getSheet(SheetName);
        cell= worksheet.getRow(RowNo).getCell(ColumnNo);
        CellType cellType = cell.getCellType();
        switch (cellType){
            case STRING :
                return cell.toString();
            case NUMERIC:
                return Integer.toString((int) cell.getNumericCellValue());
            default:
                throw new RuntimeException("no value found");
        }
    }

}
