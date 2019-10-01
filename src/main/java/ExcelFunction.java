import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelFunction implements AnsiCode{

    // Set Excel File Name
    String fileName = "UrlData.xlsx";

    // Creating Workbook instances
    Workbook wb = new XSSFWorkbook();

    // Creating Sheets using sheet object
    Sheet sheetIssues = wb.createSheet("IssuesData");
    Sheet sheetList = wb.createSheet("ListData");

    public void save(){
        while (true) {
            // An output stream accepts output bytes and sends them to sink.
            try (OutputStream fileOut = new FileOutputStream(fileName)) {
                wb.write(fileOut);
                break;
            } catch (IOException ex) {
                System.out.println(ANSI_RED+"\nFailed to create Excel file !"+ANSI_RESET);
                System.out.println("Press Enter to retry...");
                try {
                    System.in.read();
                } catch (Exception e) {}
            }
        }
    }

    public void open(){
        File file = new File(fileName);
        Desktop desktop = Desktop.getDesktop();

        // Ensure if file exist or not
        try{
            desktop.open(file);
        } catch (Exception e) {
            System.out.println(ANSI_RED+file+" either not exist or can't open"+ANSI_RESET);
        }
    }


}
