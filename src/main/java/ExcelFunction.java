import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.*;

public class ExcelFunction implements AnsiCode{

    XSSFWorkbook wb;
    XSSFSheet sheetList,sheetIssues;
    // Set Excel File Name
    String fileName = "UrlData.xlsx";


    public void create(){
        // Creating Workbook instances
        wb = new XSSFWorkbook();

        // Creating Sheets using sheet object
        wb.createSheet("ListData");
        wb.createSheet("IssuesData");

        //Save the Excel file
        saveExcel();
    }

    public void readExcel() {
        try {
            FileInputStream file = new FileInputStream(fileName);
            wb = new XSSFWorkbook(file);
            sheetList = wb.getSheet("ListData");
            sheetIssues = wb.getSheet("IssuesData");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveExcel(){
        while (true) {
            // An output stream accepts output bytes and sends them to sink.
            try (OutputStream fileOut = new FileOutputStream(fileName)) {
                wb.write(fileOut);
                break;
            } catch (IOException ex) {
                System.out.println(ANSI_RED + "\nFailed to create Excel file !" + ANSI_RESET);
                System.out.println("Press Enter to retry...");
                try {
                    System.in.read();
                } catch (Exception e) { }
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
