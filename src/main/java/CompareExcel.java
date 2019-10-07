import java.util.ArrayList;
import java.util.Arrays;

public class CompareExcel extends ExcelFunction{
    public  void compare(){
        try {
            //Read Excel file
            readExcel();

            String format;
            boolean found, inList;

            int submitted = 0, noSubmit = 0, noInList = 0;

            String[][] arrayNoSubmit = new String[sheetList.getLastRowNum()][];

            //Data in list
            for (int i=1; i <= sheetList.getLastRowNum(); i++ ) {

                found = false;

                for (int j=1; j <= sheetIssues.getLastRowNum(); j++ ) {

                    if(sheetIssues.getRow(j).getCell(1) != null) {

                        if (sheetList.getRow(i).getCell(1).toString().equals(sheetIssues.getRow(j).getCell(1).toString())){
                            submitted++;
                            found = true;
                            format = "%-10s%-10s%-40s%-40s\n";
                            System.out.format(format,
                                    submitted,
                                    String.valueOf((int)sheetList.getRow(i).getCell(1).getNumericCellValue()),
                                    sheetList.getRow(i).getCell(2),
                                    sheetIssues.getRow(j).getCell(3));
                        }

                    }else {
                        if (sheetList.getRow(i).getCell(2).toString().replaceAll(" ","").toLowerCase().equals
                                (sheetIssues.getRow(j).getCell(2).toString().replaceAll(" ","").toLowerCase())){

                            submitted++;
                            found = true;
                            format = "%-10s%-10s%-40s%-40s\n";
                            System.out.format(format,
                                    submitted,
                                    String.valueOf((int)sheetList.getRow(i).getCell(1).getNumericCellValue()),
                                    sheetList.getRow(i).getCell(2),
                                    sheetIssues.getRow(j).getCell(3));
                        }
                    }
                }

                if(!found){
                    noSubmit++;
                    arrayNoSubmit[noSubmit-1] = new String[]{
                            String.valueOf(noSubmit),
                            String.valueOf((int)sheetList.getRow(i).getCell(1).getNumericCellValue()),
                            sheetList.getRow(i).getCell(2).toString()};
                }

            }

            for(int k = 0; k < noSubmit; k++){
                format = "%-10s%-10s%-40s\n";
                System.out.format(format, arrayNoSubmit[k]);
            }

            //Data no in the list
            for (int i=1; i <= sheetIssues.getLastRowNum(); i++ ) {

                if (sheetIssues.getRow(i).getCell(1) != null) {

                    inList = false;

                    for (int j = 1; j <= sheetList.getLastRowNum(); j++) {

                        if (sheetIssues.getRow(i).getCell(1).toString().equals(sheetList.getRow(j).getCell(1).toString())) {
                            inList = true;
                        }
                    }

                    if(!inList){
                        noInList++;
                        format = "%-10s%-10s%-40s%-40s\n";
                        System.out.format(format,
                                noInList,
                                String.valueOf((int)sheetIssues.getRow(i).getCell(1).getNumericCellValue()),
                                sheetIssues.getRow(i).getCell(2),
                                sheetIssues.getRow(i).getCell(3));
                    }
                }
            }

            System.out.println("Press Enter to continue...");
            try {
                System.in.read();
            } catch (Exception ignored) { }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
