import org.apache.poi.ss.usermodel.Row;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SaveListData extends GetUrlData {
    public static class SaveListExcel extends ExcelFunction {
        public void listData() {

            try {
                //Read Excel file
                readExcel();

                final Document docList = getData("https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student");
                Elements elementsList = docList.select("table").select("tr");
                for (int i = 1; i < elementsList.size(); i++) {
                    Elements elementsItem = elementsList.get(i).select("td");

                    //Select Excel sheet and row
                    Row row = sheetList.createRow(i);

                    //Insert data to selected Excel column
                    row.createCell(0).setCellValue(Integer.parseInt(elementsItem.get(0).text()));
                    row.createCell(1).setCellValue(Integer.parseInt(elementsItem.get(1).text()));
                    row.createCell(2).setCellValue(elementsItem.get(2).text());

                }

                if (elementsList.size() == 0) {
                    System.out.println("\u001B[31mUnable to receive data from the URL !\u001B[0m");
                    System.exit(0);
                }

                //Save the Excel file
                saveExcel();

            }catch (Exception e) {
                System.out.println("\u001B[31mUnable to receive data from the URL !\u001B[0m");
                System.exit(0);
            }
        }
    }
}