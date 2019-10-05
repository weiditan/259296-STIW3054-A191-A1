import org.apache.poi.ss.usermodel.*;


public class ReadExcelData extends ExcelFunction {
    public void readData() {

        try {

            //Read Excel file
            readExcel();

            for (Row row : sheetIssues) {

                //System.out.print(row.getCell(1).getCellType());
                System.out.println();

              for (Cell cell : row) {

                    // Alternatively, get the value and format it yourself
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.format("%-40s",cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue());
                            } else {
                                System.out.print(String.valueOf((int)cell.getNumericCellValue()));
                            }
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            System.out.print(cell.getCellFormula());
                            break;
                        default:
                            System.out.println();
                    }
                    System.out.print("\t");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
