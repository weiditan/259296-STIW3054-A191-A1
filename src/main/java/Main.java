public class Main {
    public static void main(String[] ags) {

        ExcelFunction excelFunction = new ExcelFunction();
        excelFunction.save();
        System.out.println("Sheets Has been Created successfully");


        System.out.println("\nLoading...");
        SaveIssuesData saveIssuesData = new SaveIssuesData();
        saveIssuesData.issuesData();
        System.out.println("Saving Issues Data Complete.");


        System.out.println("\nLoading...");
        SaveListData.SaveListExcel saveListExcel = new SaveListData.SaveListExcel();
        saveListExcel.listData();
        System.out.println("Saving List Data Complete.");

    }
}