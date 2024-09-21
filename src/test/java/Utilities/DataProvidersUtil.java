package Utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProvidersUtil {

    String path = (".\\TestData\\MyWorkshop.xlsx");

    @DataProvider(name = "loginData")
    public String[][] getLoginData() throws IOException {
        return loadDataFromSheet("LoginSheet");

    }

    @DataProvider(name = "registerData")
    public String[][] getRegistrationData() throws IOException {
        return loadDataFromSheet("RegSheet");
    }

    private String[][] loadDataFromSheet(String sheetName) throws IOException {
        int rowCount = ReadExcellFile.getRowCount(sheetName);
        int columnCount = ReadExcellFile.getColumnCount(sheetName);

        String[][] data = new String[rowCount][columnCount];
        for (int rowIndex = 1; rowIndex<=rowCount; rowIndex++){
            for (int columnIndex=0; columnIndex<columnCount; columnIndex++){
                data[rowIndex-1][columnIndex] = ReadExcellFile.getCellValue(sheetName ,rowIndex, columnIndex );
            }
        }
        return data;
    }

}
