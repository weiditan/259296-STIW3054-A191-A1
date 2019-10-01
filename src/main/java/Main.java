public class Main implements AnsiCode {
    public static void main(String[] ags) {

        System.out.println(ANSI_BLUE+"\nCreating Excel file..."+ANSI_RESET);
        ExcelFunction excelFunction = new ExcelFunction();
        excelFunction.save();
        System.out.println(ANSI_GREEN+"Excel File has been created successfully !"+ANSI_RESET);


        System.out.println(ANSI_BLUE+"\nSaving Issues Data..."+ANSI_RESET);
        SaveIssuesData saveIssuesData = new SaveIssuesData();
        saveIssuesData.issuesData();
        System.out.println(ANSI_GREEN+"Saved Issues Data Complete !"+ANSI_RESET);


        System.out.println(ANSI_BLUE+"\nSaving List Data ..."+ANSI_RESET);
        SaveListData.SaveListExcel saveListExcel = new SaveListData.SaveListExcel();
        saveListExcel.listData();
        System.out.println(ANSI_GREEN+"Saved List Data Complete !"+ANSI_RESET);

        //excelFunction.open();
    }
}