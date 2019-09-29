import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class GetHtmlData {
    public  void getData(){
        final String url =
                "https://github.com/STIW3054-A191/Main-Issues/issues/1";

        try{
            final Document document = Jsoup.connect(url).get();

            Elements elements = document.select("table > tbody > tr > td > p");
            System.out.println(elements);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
