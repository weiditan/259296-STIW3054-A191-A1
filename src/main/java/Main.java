

public class Main {
    public static void main(String[] ags) {

        ExcelFunction excelFunction = new ExcelFunction();
        excelFunction.create();
        System.out.println("Sheets Has been Created successfully");


        System.out.println("\nLoading...");
        SaveIssuesData saveIssuesData = new SaveIssuesData();
        saveIssuesData.issuesData();
        System.out.println("Saving Issues Data Complete.");


        System.out.println("\nLoading...");
        SaveListData saveListData = new SaveListData();
        saveListData.listData();
        System.out.println("Saving List Data Complete.");


    }
}