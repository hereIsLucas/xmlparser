package ch.heroin.xmlparser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import ch.heroin.xmlparser.model.Recipient;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecipientXmlParser
{
    
    public static List<Recipient> parse(InputStream in) throws Exception
    {
        
        List<Recipient> recipients = new ArrayList<>();
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        
        DefaultHandler handler = new DefaultHandler()
        {
            
            private Recipient currentRecipient;
            private StringBuilder text = new StringBuilder();
            
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
            {
                text.setLength(0);
                
                if("recipient".equals(qName))
                {
                    currentRecipient = new Recipient();
                }
            }
            
            @Override
            public void characters(char[] ch, int start, int length)
            {
                text.append(ch, start, length);
            }
            
            @Override
            public void endElement(String uri, String localName, String qName)
            {
                
                String value = text.toString().trim();
                
                if(currentRecipient != null)
                {
                    switch(qName)
                    {
                        case "name":
                            currentRecipient.setName(value);
                            break;
                        
                        case "number":
                            if(!value.isEmpty())
                            {
                                currentRecipient.getNumbers().add(value);
                            }
                            break;
                        
                        case "email":
                            if(!value.isEmpty())
                            {
                                currentRecipient.getEmails().add(value);
                            }
                            break;
                        
                        case "recipient":
                            recipients.add(currentRecipient);
                            currentRecipient = null;
                            break;
                    }
                }
                
                text.setLength(0);
            }
        };
        
        parser.parse(in, handler);
        return recipients;
    }
}