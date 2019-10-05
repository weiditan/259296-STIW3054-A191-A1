import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetUrlData implements AnsiCode{

    public static Document getData(final String url){
        while (true) {
            try {
                final Document document = Jsoup.connect(url).get();
                return document;
            } catch (Exception ex) {
                System.out.println("\u001B[31mUnable connect to the URL !\u001B[0m");
                System.out.println("Press Enter to retry...");
                try {
                    System.in.read();
                    System.out.println(ANSI_BLUE+"Loading..."+ANSI_RESET);
                } catch (Exception e) {}
            }
        }
    }
}
