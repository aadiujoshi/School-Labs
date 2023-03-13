public class Point 
{
    private double  x, y;
    private boolean visited;
    
    /** get the Euclidean distance between two points */
    public double getDistance(Point other)
    {
        return Math.sqrt(Math.pow((other.getX()-this.x), 2) + Math.pow((other.getY()-this.y), 2));
    }
    
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
        visited = false;
    }
    
    @Override
    public String toString()
    {
        return x + " " + y;
    }
    
    public boolean hasVisited()
    {
        return visited;
    }
    
    public void setVisited(boolean b)
    {
        visited = b;
    }
    
    public double getX()
    {
        return this.x;
    }
    
    public double getY()
    {
        return this.y;
    }
}