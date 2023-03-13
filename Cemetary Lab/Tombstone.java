public class Tombstone
{
    private String name;
    private String burialDate;
    private double age;
    private String address;
    
    public Tombstone(String n, String death, double a, String addr)
    {
        name = n;
        burialDate = death;
        age = a;
        address = addr;
    }
    
    public String toString()
    {
        return name + "  " + burialDate + "  " + age + "  " + address;
    }
}
