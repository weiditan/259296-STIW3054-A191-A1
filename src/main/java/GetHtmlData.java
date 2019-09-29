import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetHtmlData {
    public  void getData(){
        final String url =
                "https://github.com/STIW3054-A191/Main-Issues/issues/1";

        try{
            final Document document = Jsoup.connect(url).get();
            System.out.println(document.outerHtml());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void print(){
        System.out.println("Haha gagshadhjsadahjdhja");
    }
}
