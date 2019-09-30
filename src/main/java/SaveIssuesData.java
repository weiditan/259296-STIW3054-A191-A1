import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SaveIssuesData extends GetUrlData {

    public void issuesData(){

        final Document docIssues = getData("https://github.com/STIW3054-A191/Main-Issues/issues/1");
        Elements elementsIssues = docIssues.select("table > tbody > tr > td > p");
        System.out.println(elementsIssues);

        if(elementsIssues.size()==0){
            System.out.println("\u001B[31m\nUnable to receive data from the URL !\u001B[0m");
            System.exit(0);
        }

    }
}