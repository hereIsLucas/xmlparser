package ch.heroin.xmlparser;


import java.io.InputStream;
import java.util.List;

import ch.heroin.xmlparser.model.Recipient;

public class App{
    public static void main(String[] args) throws Exception {

        try (InputStream in = ResourceLoader.open("empfaenger_lsa.xml")) {

            List<Recipient> recipients = RecipientXmlParser.parse(in);

            System.out.println("First recipient: " + recipients.get(2).getName()
                    + " numbers=" + recipients.get(2).getNumbers());
            
            for (int i = 0; i < Math.min(5, recipients.size()); i++) {
                System.out.println(" - " + recipients.get(i).getName());
            }
        }
    }
}
