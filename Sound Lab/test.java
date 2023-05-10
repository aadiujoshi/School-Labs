public class test
{
        int i =0;
        
    public static void main(String agre[])
    {
        
        test[] arr = new test[5];
        
        for(test e : arr)
        {
            e = new test(5);
            System.out.println(e);
        }
        
    }
    
    public test(int i)
    {
        i = i;
    }
    
    public String toString()
    {
        return Integer.toString(i);
    }
}