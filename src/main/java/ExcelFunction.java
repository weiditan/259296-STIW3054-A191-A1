import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.*;

public class ExcelFunction implements AnsiCode{

    FileInputStream file;
    XSSFWorkbook wb;
    XSSFSheet sheetList,sheetIssues;
    // Set Excel File Name
    String fileName = "UrlData.xlsx";


    public void createExcel(){
        // Creating Workbook instances
        wb = new XSSFWorkbook();

        CellStyle style = wb.createCellStyle();//Create style
        XSSFFont font = wb.createFont();//Create font
        font.setBold(true);//Make font bold
        style.setFont(font);//set it to bold

        // Creating Sheets using sheet object
        wb.createSheet("ListData");
        sheetList = wb.getSheet("ListData");
        Row rowList = sheetList.createRow(0);
        rowList.createCell(0).setCellValue("No");
        rowList.createCell(1).setCellValue("Matric");
        rowList.createCell(2).setCellValue("Name");

        for(int i = 0; i < rowList.getLastCellNum(); i++){//For each cell in the row
            rowList.getCell(i).setCellStyle(style);//Set the style
        }


        wb.createSheet("IssuesData");
        sheetIssues = wb.getSheet("IssuesData");
        Row rowIssues = sheetIssues.createRow(0);
        rowIssues.createCell(0).setCellValue("No");
        rowIssues.createCell(1).setCellValue("Matric");
        rowIssues.createCell(2).setCellValue("Name");
        rowIssues.createCell(3).setCellValue("GitHub Link");

        for(int i = 0; i < rowIssues.getLastCellNum(); i++){//For each cell in the row
            rowIssues.getCell(i).setCellStyle(style);//Set the style
        }

        //Save the Excel file
        saveExcel();
    }

    public void readExcel() {
        try {
            file = new FileInputStream(fileName);
            wb = new XSSFWorkbook(file);
            sheetList = wb.getSheet("ListData");
            sheetIssues = wb.getSheet("IssuesData");
        } catch (IOException ex) {
            System.out.println(ANSI_RED + "Failed to read the Excel file !" + ANSI_RESET);
            System.out.println("Press Enter to retry...");
            try {
                System.in.read();
            } catch (Exception e) { }
        }
    }

    public void saveExcel(){
        while (true) {
            // An output stream accepts output bytes and sends them to sink.
            try (OutputStream fileOut = new FileOutputStream(fileName)) {
                wb.write(fileOut);
                break;
            } catch (IOException ex) {
                System.out.println(ANSI_RED + "Failed to create the Excel file !" + ANSI_RESET);
                System.out.println("Press Enter to retry...");
                try {
                    System.in.read();
                    System.out.println(ANSI_BLUE+"Loading..."+ANSI_RESET);
                } catch (Exception e) { }
            }
        }
    }

    public void open(){
        File excelFile = new File(fileName);
        Desktop desktop = Desktop.getDesktop();

        // Ensure if file exist or not
        try{
            desktop.open(excelFile);
        } catch (Exception e) {
            System.out.println(ANSI_RED+file+" either not exist or can't open"+ANSI_RESET);
        }
    }
}
