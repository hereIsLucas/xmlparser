package ch.heroin.xmlparser.model;

import java.util.ArrayList;
import java.util.List;

public class Recipient
{
    
    private int id;
    private String name;
    private List<String> numbers = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public List<String> getNumbers()
    {
        return numbers;
    }
    
    public void setNumbers(List<String> numbers)
    {
        this.numbers = numbers;
    }
    
    public List<String> getEmails()
    {
        return emails;
    }
    
    public void setEmails(List<String> emails)
    {
        this.emails = emails;
    }
    
    @Override
    public String toString()
    {
        return "Recipient [name=" + name + ", numbers=" + numbers + ", emails=" + emails + "]";
    }
    
}
