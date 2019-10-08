import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class ReadExcelData extends ExcelFunction implements AnsiCode{
    public void readData(String sheetName) {

        try {
            //Read Excel file
            readExcel();

            XSSFSheet sheet = wb.getSheet(sheetName);
            String format = "", title = "", resultSentence = "";

            int lastCell = sheet.getRow(0).getLastCellNum();


            if(sheetName.equals("ListData")) {

                title = ANSI_YELLOW+ANSI_BOLD+ANSI_ITALIC+"\n\nList Of Students"+ANSI_RESET;
                resultSentence = ANSI_GREEN+"Total " + sheet.getLastRowNum() + " students in the class."+ANSI_RESET;

            }else if(sheetName.equals("IssuesData")){

                title = ANSI_YELLOW+ANSI_BOLD+ANSI_ITALIC+"\n\nList Of Issues"+ANSI_RESET;
                resultSentence = ANSI_GREEN+"Total " + sheet.getLastRowNum() + " students have submitted the GitHub account."+ANSI_RESET;

            }

            System.out.println(title);

            if(lastCell==3){
                format = "| %-10s| %-10s| %-40s|\n";

                printLine(lastCell);

                System.out.format(format,
                        sheet.getRow(0).getCell(0),
                        sheet.getRow(0).getCell(1),
                        sheet.getRow(0).getCell(2));

                printLine(lastCell);

            }else if (lastCell==4) {
                format = "| %-10s| %-10s| %-40s| %-40s|\n";

                printLine(lastCell);

                System.out.format(format,
                        sheet.getRow(0).getCell(0),
                        sheet.getRow(0).getCell(1),
                        sheet.getRow(0).getCell(2),
                        sheet.getRow(0).getCell(3));

                printLine(lastCell);
            }

            for (int i=1; i <= sheet.getLastRowNum(); i++ ) {

                 Row row = sheet.getRow(i);

                 ArrayList<String> rowData = new ArrayList<>();

                for (int j=0; j < row.getLastCellNum(); j++ ) {

                   Cell cell = row.getCell(j);

                    if (cell!=null) {

                        // Alternatively, get the value and format it yourself
                        switch (cell.getCellType()) {
                            case STRING:
                                rowData.add(cell.getRichStringCellValue().getString());
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    rowData.add(cell.getDateCellValue().toString());
                                } else {
                                    rowData.add(String.valueOf((int) cell.getNumericCellValue()));
                                }
                                break;
                            case BOOLEAN:
                                rowData.add(String.valueOf(cell.getBooleanCellValue()));
                                break;
                            case FORMULA:
                                rowData.add(cell.getCellFormula());
                                break;
                            default:
                                System.out.println();
                        }
                    }else {
                        rowData.add("");
                    }
                }

               System.out.format(format,rowData.toArray());


            }

            printLine(lastCell);

            System.out.println(resultSentence);

            System.out.println("\n\nPress Enter to continue...");
            try {
                System.in.read();
            } catch (Exception ignored) { }
        }
        catch (Exception ignored) { }
    }

    public void printLine(int totalCell) {

        if (totalCell == 3) {
            System.out.format("+%-10s+%-10s+%-40s+\n",
                    "-----------",
                    "-----------",
                    "-----------------------------------------");
        } else if (totalCell == 4){
            System.out.format("+%-10s+%-10s+%-40s+%-40s+\n",
                    "-----------",
                    "-----------",
                    "-----------------------------------------",
                    "-----------------------------------------");
        }
    }


}
