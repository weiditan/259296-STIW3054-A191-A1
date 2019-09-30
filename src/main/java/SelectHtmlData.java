import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SelectHtmlData extends GetUrlData {

    public void selectData (){

        final Document docIssues = getData("https://github.com/STIW3054-A191/Main-Issues/issues/1");
        Elements elementsIssues = docIssues.select("table > tbody > tr > td > p");
        System.out.println(elementsIssues);

        if(elementsIssues.size()==0){
            System.out.println("\u001B[31m\nUnable to receive data from the URL !\u001B[0m");
            System.exit(0);
        }

        final Document docList = getData("https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student");
        Elements elementsList = docList.select("table").select("tr");
        for(int i = 0;i<elementsList.size();i++){
            Elements elementsItem = elementsList.get(i).select("td");
            for(int j = 0;j<elementsItem.size();j++){
                System.out.println(elementsItem.get(j).text());
            }
        }

        if(elementsList.size()==0){
            System.out.println("\u001B[31m\nUnable to receive data from the URL !\u001B[0m");
            System.exit(0);
        }

    }
}