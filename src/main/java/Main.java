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

        //excelFunction.open();

      /*  Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        while (true) {

            System.out.println("MENU" +
                            "\n1 View List Of Students"+
                            "\n2 View List Of Issues"+
                            "\n3 Compare two list"+
                            "\n0 Exit");

            System.out.println("Please enter your choice");

            String input = myObj.nextLine();  // Read user input

            switch (input) {
                case "1":
                    System.out.println("Monday");

                    break;
                case "2":
                    System.out.println("Tuesday");
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input please try again !");
                    System.out.println("Please enter your choice");
            }
        }*/

        ReadExcelData readListData = new ReadExcelData();
        readListData.readData();

       /* System.out.format("%-10s",90);
        System.out.format("%-15s",905654);
        System.out.format("%15s",90);
        System.out.format("%15s",90);*/
    }
}