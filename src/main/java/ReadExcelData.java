import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;


public class ReadExcelData extends ExcelFunction {
    public void readData(String sheetName) {

        try {
            //Read Excel file
            readExcel();

            XSSFSheet sheet = wb.getSheet(sheetName);
            String format = null;


            System.out.println(sheet.getLastRowNum());
            System.out.println(sheet.getRow(0).getLastCellNum());

            if(sheet.getRow(0).getLastCellNum()==3){
                format = "%-10s%-10s%-40s\n";
                System.out.format(format,
                        sheet.getRow(0).getCell(0),
                        sheet.getRow(0).getCell(1),
                        sheet.getRow(0).getCell(2));

                System.out.format(format,
                        "---------",
                        "---------",
                        "---------------------------------------");

            }else if (sheet.getRow(0).getLastCellNum()==4) {
                format = "%-10s%-10s%-40s%-40s\n";
                System.out.format(format,
                        sheet.getRow(0).getCell(0),
                        sheet.getRow(0).getCell(1),
                        sheet.getRow(0).getCell(2),
                        sheet.getRow(0).getCell(3));

                System.out.format(format,
                        "---------",
                        "---------",
                        "---------------------------------------",
                        "---------------------------------------");
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
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
