import org.apache.poi.ss.usermodel.Row;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveIssuesData extends GetUrlData {
    public static class SaveIssuesExcel extends ExcelFunction {
        public void issuesData() {

            //Read Excel file
            readExcel();

            try {
                final Document docIssues = getData("https://github.com/STIW3054-A191/Main-Issues/issues/1");
                Elements elementsIssues = docIssues.select("table").select("tr");
                for (int i = 1; i < elementsIssues.size(); i++) {
                    Elements elementsItem = elementsIssues.get(i).select("p");

                    //Select Excel sheet and row
                    Row row = sheetIssues.createRow(i);

                    for (int j = 0; j < elementsItem.size(); j++) {

                        //Insert data to selected Excel column
                        row.createCell(0).setCellValue(i);

                        Pattern matric = Pattern.compile("([0-9]{6})");
                        Matcher matchMatric = matric.matcher(elementsItem.get(j).text());
                        if (matchMatric.find()) {
                            //Insert data to selected Excel column
                            row.createCell(1).setCellValue(Integer.parseInt(matchMatric.group()));
                        }

                        Pattern name = Pattern.compile("(Name)(.*)(Matric)");
                        Matcher matchName = name.matcher(elementsItem.get(j).text());

                        Pattern name2 = Pattern.compile("(Name)(.*)(Link)");
                        Matcher matchName2 = name2.matcher(elementsItem.get(j).text());

                        Pattern name3 = Pattern.compile("(name)(.*)(link)");
                        Matcher matchName3 = name3.matcher(elementsItem.get(j).text());

                        if (matchName.find()) {
                            //Insert data to selected Excel column
                            row.createCell(2).setCellValue(matchName.group(2).replaceAll(":", "").trim());
                        } else if (matchName2.find()) {
                            //Insert data to selected Excel column
                            row.createCell(2).setCellValue(matchName2.group(2).replaceAll(":", "").trim());
                        } else if (matchName3.find()) {
                            //Insert data to selected Excel column
                            row.createCell(2).setCellValue(matchName3.group(2).replaceAll(":", "").trim());
                        }

                        Pattern link = Pattern.compile("https://.*");
                        Matcher matchLink = link.matcher(elementsItem.get(j).text());
                        if (matchLink.find()) {
                            //Insert data to selected Excel column
                            row.createCell(3).setCellValue(matchLink.group());
                        }
                    }
                }

                if (elementsIssues.size() == 0) {
                    System.out.println("\u001B[31mNo data from the URL !\u001B[0m");
                    System.exit(0);
                }

                //Save the Excel file
                saveExcel();

            } catch (Exception e) {
                System.out.println("\u001B[31mUnable to receive data from the URL !\u001B[0m");
                System.exit(0);
            }
        }
    }
}