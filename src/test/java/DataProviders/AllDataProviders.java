package DataProviders;

import Utilities.ReadExcellFile;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class AllDataProviders {

    @DataProvider(name = "loginData")
    public String[][] loginData() throws IOException {
        String path = (".\\TestData\\MyWorkshop.xlsx");

        int TTrow = ReadExcellFile.getRowCount(path, "LoginSheet");
        int TTcolumn = ReadExcellFile.getColumnCount(path, "LoginSheet");

        String[][] data = new String[TTrow][TTcolumn];
        for (int i = 1; i<=TTrow; i++){
            for (int j=0; j<TTcolumn; j++){
                data[i-1][j] = ReadExcellFile.getCellValue(path, "LoginSheet" ,i, j );
            }
        }
        return data;
    }


    @DataProvider(name = "registerData")
    public String[][] registerData() throws IOException {
        String path = ".\\TestData\\MyWorkshop.xlsx";

        int TTrow = ReadExcellFile.getRowCount(path, "RegSheet");
        int TTcolumn = ReadExcellFile.getColumnCount(path, "RegSheet");

        String[][] data = new String[TTrow][TTcolumn];
        for (int i = 1; i<=TTrow; i++){
            for (int j=0; j<TTcolumn; j++){
                data[i-1][j] = ReadExcellFile.getCellValue(path, "RegSheet" ,i, j );
            }
        }
        return data;
    }
}
