import java.io.*;
import java.util.*;

public class GreedyPath extends Path
{
    Point[] greedyPoints;
    
    public GreedyPath(String fileName) throws FileNotFoundException
    {
        super(fileName);
        greedyPoints = findPath();
    }
    
    public Point[] findPath()
    {
        greedyPoints = new Point[super.getPoints().length];
        Point[] points = super.getPoints();
        
        int pointsIndex = 0;
        int greedyPointsIndex = 1;
        int greedyIndex = 0;
        
        greedyPoints[0] = points[0];
        greedyPoints[0].setVisited(true);
        
        while(greedyPointsIndex < points.length)
        {
            double smallest = Double.MAX_VALUE;
            
            for(int i = 0; i < points.length; i++)
            {
                if(pointsIndex != i && points[pointsIndex].getDistance(points[i]) < smallest &&
                points[i].hasVisited() == false)
                {
                    smallest = points[pointsIndex].getDistance(points[i]);
                    greedyIndex = i;
                }
            }
            
            points[greedyIndex].setVisited(true);
            pointsIndex = greedyIndex;
            greedyPoints[greedyPointsIndex] = points[greedyIndex];
            greedyPointsIndex++;
        }
        
        return greedyPoints;
    }
    
    public double getDistance()
    {
        return super.getDistance(greedyPoints);
    }
    
    @Override
    public Point getPoint(int i)
    {
        return greedyPoints[i];
    }
    
    public String toString()
    {
        return Double.toString(getDistance());
    }
}