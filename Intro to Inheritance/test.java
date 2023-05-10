import java.util.Objects;

public class test
{
    static int x;
    
    test(int x)
    {
        this.x = x;
    }
    
    public static void main(String args[])
    {
        check();
    }
    
    static int getX()
    {
        return x;
    }
    
    
    
    static void check()
    {
        /*test[] o = new test[5];
        
        for(int i = 0; i < 5; i++)
        {
            o[i] = new test(test.getX()+1);
            System.out.println(o[i].getX());
        }
        
        System.out.println(x);*/
    }
}