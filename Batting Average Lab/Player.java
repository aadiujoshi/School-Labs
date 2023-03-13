public class Player
{
    private String name;
    private int number;
    private int atBats;
    private int hits;
        
    public Player(String pName, int pNum)
    {
        name = pName;
        number = pNum;
    }
    
    public Player(String pName, int pNum, int atB, int pHit)
    {
        name = pName;
        number = pNum;
        atBats = atB;
        hits = pHit;
    }
    
    public double getBattingAverage()
    {
        return (double) hits/atBats;
    }
    
    public String toString()
    {
        return name + "\t #" + number + "\t" + this.getBattingAverageString();
    }
    
    public String getBattingAverageString()
    {
        return Integer.toString((int)Math.round(1000*((double)hits/atBats)));
    }
}
