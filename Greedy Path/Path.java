import java.io.*;
import java.util.*;

public class Path
{
    private Point[] points;
    private double minX, minY;
    private double maxX, maxY;
    
    public Path(String fileName) throws FileNotFoundException
    {
         Scanner in = new Scanner(new File(fileName));
         int lines = in.nextInt();
         points = new Point[lines];
            
         minX = Integer.MAX_VALUE; 
         minY = Integer.MAX_VALUE;
         maxX = Integer.MIN_VALUE;
         maxY = Integer.MIN_VALUE;
        
         for(int i = 0; i < lines; i++)
         {
             double x = in.nextDouble();
             double y = in.nextDouble();
             points[i] = new Point(x, y);
         
             minX = Math.min(minX, x);
             minY = Math.min(minY, y);
             maxX = Math.max(maxX, x);
             maxY = Math.max(maxY, y);
         }
        
         StdDraw.setXscale(minX, maxX);
         StdDraw.setYscale(minY, maxY);
    }
    
    public double getMinX()
    {
        return minX;
    }
    
    public double getMinY()
    {
        return minY;
    }
    
    public int getNumPoints()
    {
        return points.length;
    }
    
    public double getMaxX()
    {
        return maxX;
    }
    
    public Point[] getPoints()
    {
        return points;
    }
    
    public double getMaxY()
    {
        return maxY;
    }
    
    public Point getPoint(int i)
    {
        return points[i];
    }
    
    public double getDistance(Point[] p)
    {
        double total = 0;
        for(int i = 0; i < p.length-1; i++)
            total += p[i].getDistance(p[i+1]);
            
        return total;
    }
    
    public String toString()
    {
        return Double.toString(getDistance(this.points));
    }
}