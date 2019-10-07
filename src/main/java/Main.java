import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main implements AnsiCode {
    public static void main(String[] ags) {

        System.out.println(ANSI_BLUE+"Creating Excel file..."+ANSI_RESET);
        ExcelFunction excelFunction = new ExcelFunction();
        excelFunction.createExcel();
        System.out.println(ANSI_GREEN+"Excel File has been created successfully !"+ANSI_RESET);

        System.out.println(ANSI_BLUE+"Saving List Data ..."+ANSI_RESET);
        SaveListData.SaveListExcel saveListExcel = new SaveListData.SaveListExcel();
        saveListExcel.listData();
        System.out.println(ANSI_GREEN+"Saved List Data Complete !"+ANSI_RESET);

        System.out.println(ANSI_BLUE+"Saving Issues Data..."+ANSI_RESET);
        SaveIssuesData.SaveIssuesExcel saveIssuesExcel = new SaveIssuesData.SaveIssuesExcel();
        saveIssuesExcel.issuesData();
        System.out.println(ANSI_GREEN+"Saved Issues Data Complete !"+ANSI_RESET);

        ReadExcelData readListData = new ReadExcelData();
        CompareExcel compareExcel = new CompareExcel();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        while (true) {

            System.out.println("MENU" +
                    "\n1 View List Of Students" +
                    "\n2 View List Of Issues" +
                    "\n3 Compare two list" +
                    "\n4 Open Excel file" +
                    "\n0 Exit");

            String input = "";

            while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {

                System.out.println("Please enter your choice");

                input = myObj.nextLine();  // Read user input

                switch (input) {
                    case "1":
                        readListData.readData("ListData");
                        break;
                    case "2":
                        readListData.readData("IssuesData");
                        break;
                    case "3":
                        compareExcel.compare();
                        break;
                    case "4":
                        excelFunction.open();
                        break;
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input please try again !");
                }
            }
        }
    }
}
