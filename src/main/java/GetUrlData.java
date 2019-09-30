import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetUrlData {
    public Document getData(final String url){

        try{
            final Document document = Jsoup.connect(url).get();
            return document;
        }
        catch (Exception ex){
            System.out.println("\u001B[31m\nUnable connect to the URL !\u001B[0m");
            System.exit(0);
        }
        return null;
    }
}
