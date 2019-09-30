import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetUrlData {

    public static Document getData(final String url){
        while (true) {
            try {
                final Document document = Jsoup.connect(url).get();
                return document;
            } catch (Exception ex) {
                System.out.println("\u001B[31m\nUnable connect to the URL !\u001B[0m");
                System.out.println("Press Enter to continue...");
                try {
                    System.in.read();
                } catch (Exception e) {}
            }
        }
    }
}
