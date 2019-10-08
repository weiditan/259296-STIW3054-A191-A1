public class CompareExcel extends ExcelFunction implements AnsiCode{
    public  void compare(){
        try {
            //Read Excel file
            readExcel();

            String format;
            boolean found, inList;

            int submitted = 0, noSubmit = 0, noInList = 0;

            Object[][] arrayNoSubmit = new String[sheetList.getLastRowNum()][];

            System.out.println(ANSI_YELLOW+ANSI_BOLD+ANSI_ITALIC+"\n\nSubmitted Students"+ANSI_RESET);
            headerFourCell();

            //Data in list
            for (int i=1; i <= sheetList.getLastRowNum(); i++ ) {

                found = false;

                for (int j=1; j <= sheetIssues.getLastRowNum(); j++ ) {

                    if(sheetIssues.getRow(j).getCell(1) != null) {

                        if (sheetList.getRow(i).getCell(1).toString().equals(sheetIssues.getRow(j).getCell(1).toString())){
                            submitted++;
                            found = true;
                            format = "| %-10s| %-10s| %-40s| %-40s|\n";
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
                            format = "| %-10s| %-10s| %-40s| %-40s|\n";
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

            printFourLine();
            System.out.println(ANSI_GREEN+"Total "+submitted+" students submitted the GitHub account."+ANSI_RESET);

            System.out.println(ANSI_YELLOW+ANSI_BOLD+ANSI_ITALIC+"\n\nNot Submitted Students"+ANSI_RESET);
            headerThreeCell();

            for(int k = 0; k < noSubmit; k++){
                format = "| %-10s| %-10s| %-40s|\n";
                System.out.format(format, arrayNoSubmit[k]);
            }

            printThreeLine();
            System.out.println(ANSI_GREEN+"Total "+noSubmit+" students not submitted the GitHub account."+ANSI_RESET);

            System.out.println(ANSI_YELLOW+ANSI_BOLD+ANSI_ITALIC+"\n\nWrong Submitted Students"+ANSI_RESET);
            headerFourCell();

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
                        format = "| %-10s| %-10s| %-40s| %-40s|\n";
                        System.out.format(format,
                                noInList,
                                String.valueOf((int)sheetIssues.getRow(i).getCell(1).getNumericCellValue()),
                                sheetIssues.getRow(i).getCell(2),
                                sheetIssues.getRow(i).getCell(3));
                    }
                }
            }

            printFourLine();
            System.out.println(ANSI_GREEN+"Total "+noInList+" another class students submitted the GitHub account."+ANSI_RESET);

            System.out.println("\n\nPress Enter to continue...");
            try {
                System.in.read();
            } catch (Exception ignored) { }


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void headerThreeCell(){
        printThreeLine();
        System.out.format("| %-10s| %-10s| %-40s|\n", "No","Matric","Name");
        printThreeLine();
    }
    public void headerFourCell(){
        printFourLine();
        System.out.format("| %-10s| %-10s| %-40s| %-40s|\n", "No","Matric","Name","GitHub Link");
        printFourLine();
    }

    public void printThreeLine(){
        System.out.format("+%-10s+%-10s+%-40s+\n",
                "-----------",
                "-----------",
                "-----------------------------------------");
    }

    public void printFourLine(){
        System.out.format("+%-10s+%-10s+%-40s+%-40s+\n",
                "-----------",
                "-----------",
                "-----------------------------------------",
                "-----------------------------------------");
    }
}
