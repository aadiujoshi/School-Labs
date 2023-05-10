import java.util.*;

public class ArrayListProbs
{
    public ArrayListProbs()
    {
        
    }
    
    public void makeListAndPrint(int num, int limit)
    {
        ArrayList<Integer> list = new ArrayList();
        
        for(int i = 0; i < num; i++)
        {
            list.add((int)(Math.random()*limit+1));
        }
        
        System.out.println(list);
    }
    
    public ArrayList<Integer> addOne(ArrayList<Integer> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            list.set(i, list.get(i)+1);
        }
        
        return list;
    }
    
    public ArrayList<Integer> minToFront(ArrayList<Integer> list)
    {
        int smallest = list.get(0);
        
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i) < smallest)
            {
                smallest = list.get(i);
            }
        }
        
        list.add(0, smallest);
        
        return list;
    }
    
    public ArrayList<String> removeDupes(ArrayList<String> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            for(int j = 0; j < list.size(); j++)
            {
                if(list.get(i) == list.get(j) && j != i)
                {
                    list.remove(i);
                    list.remove(j);
                }
            }
        }
        
        return list;
    }
    
    public ArrayList<Integer> swapPairs(ArrayList<Integer> list)
    {
        for(int i = 0; i < list.size(); i += 2)
        {
            int tempPlus = list.get(i+1);
            list.set(i+1, list.get(i));
            list.set(i, tempPlus);
        }
        
        return list;
    }
    
    public ArrayList<String> removeLenN(ArrayList<String> list, int n)
    {
        for(int i = 0; i < list.size(); i ++)
        {
            if(list.get(i).length() == n)
            {
                list.remove(i);
            }
        }
        
        return list;
    }
    
    public int dumbestPerson(ArrayList<Person> list)
    {
        int index = 0;
        
        for(int i = 0; i < list.size(); i ++)
        {
            if(list.get(i).getIQ() < list.get(index).getIQ())
            {
                index = i;
            }
        }
        
        return index;
    }
    
    public Book highestPricedBook(ArrayList<Book> list)
    {
        int index = 0;
        
        for(int i = 0; i < list.size(); i ++)
        {
            if(list.get(i).getPrice() > list.get(0).getPrice())
            {
                index = i;
            }
        }
        
        return list.get(index);
    }
    
    public ArrayList<Book> banBook(ArrayList<Book> list,Book book)
    {
        String title = book.getTitle();
        
        for(int i = 0; i < list.size(); i ++)
        {
            if(list.get(i).getTitle() == title)
            {
                list.remove(i);
            }
        }
        
        return list;
    }
    
    
    
    public double bookstoreValue(Bookstore Store)
    {
        double val = 0;
        
        for(int i = 0; i < Store.getInventory().size(); i++)
        {
            val += Store.getInventory().get(i).getPrice();
        }
        
        return val;
    }
}