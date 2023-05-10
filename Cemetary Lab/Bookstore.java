import java.util.ArrayList;

public class Bookstore
{
    private ArrayList<Book> inventory;
    
    
    public Bookstore()
    {
        inventory = new ArrayList();
    }
    
    public void addBook(Book b)
    {
        inventory.add(b);
    }
    
    public int numBooks()
    {
        return inventory.size();
    }
    
    public ArrayList<Book> getInventory()
    {
        return inventory;
    }
    
    public Book getBook(int index)
    {
        if(index < inventory.size())
        {
            return inventory.get(index);
        }
        return null;
    }
}