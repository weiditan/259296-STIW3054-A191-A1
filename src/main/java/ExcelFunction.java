import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelFunction {
    public void create(){
        // Creating Workbook instances
        Workbook wb = new XSSFWorkbook();

        // Creating Sheets using sheet object
        Sheet sheet1 = wb.createSheet("IssuesData");
        Sheet sheet2 = wb.createSheet("ListData");

        // An output stream accepts output bytes and sends them to sink.
        try (OutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            System.out.println("\u001B[31m\nFailed to create Excel file !\u001B[0m");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("\u001B[31m\nFailed to create Excel file !\u001B[0m");
            System.exit(0);
        }
    }


}
