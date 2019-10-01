import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SaveIssuesData extends GetUrlData {

    public void issuesData(){

        try {
            final Document docIssues = getData("https://github.com/STIW3054-A191/Main-Issues/issues/1");
            Elements elementsIssues = docIssues.select("table").select("tr");
            for(int i = 1;i<elementsIssues.size();i++){
                Elements elementsItem = elementsIssues.get(i).select("p");
                for(int j = 0;j<elementsItem.size();j++){
                    System.out.println(elementsItem.get(j).text());

                    Pattern matric = Pattern.compile("([0-9]{6})");
                    Matcher matchMatric = matric.matcher(elementsItem.get(j).text());
                    if (matchMatric.find()) {
                        System.out.println(matchMatric.group()); // Prints 123456
                    }

                    Pattern name = Pattern.compile("(Name)(.*)(Matric)");
                    Matcher matchName = name.matcher(elementsItem.get(j).text());

                    Pattern name2 = Pattern.compile("(Name)(.*)(Link)");
                    Matcher matchName2 = name2.matcher(elementsItem.get(j).text());

                    Pattern name3 = Pattern.compile("(name)(.*)(link)");
                    Matcher matchName3 = name3.matcher(elementsItem.get(j).text());

                    if (matchName.find()) {
                       System.out.println(matchName.group(2).replaceAll(":","").trim());
                    }else if (matchName2.find()){
                        System.out.println(matchName2.group(2).replaceAll(":","").trim());
                    }else if (matchName3.find()){
                        System.out.println(matchName3.group(2).replaceAll(":","").trim());
                    }

                    Pattern link = Pattern.compile("https://.*");
                    Matcher matchLink = link.matcher(elementsItem.get(j).text());
                    if (matchLink.find()) {
                        System.out.println(matchLink.group()+"\n\n"); // Prints 123456
                    }
                }
            }

            if(elementsIssues.size()==0){
                System.out.println("\u001B[31m\nNo data from the URL !\u001B[0m");
                System.exit(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("\u001B[31m\nUnable to receive data from the URL !\u001B[0m");
            System.exit(0);
        }



    }
}