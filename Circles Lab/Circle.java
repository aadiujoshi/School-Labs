import java.awt.*;

public class Circle
{
    private int x;
    private int y;
    
    private int dx;
    private int dy;
    
    private int radius;
    private Color color;
    
    public Circle(int ex, int why, int rad, Color colour)
    {
        x = ex;
        y = why;
        radius = rad;
        color = colour;
    }
    
    public Circle(int ex, int why, int dex, int die, int rad, Color colour)
    {
        x = ex;
        y = why;
        dx = dex;
        dy = die;
        radius = rad;
        color = colour;
    }
    
    public void draw()
    {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x,y, radius);
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public int getRadius()
    {
        return radius;
    }
    
    public boolean overlaps(Circle other)
    {
        double distance = Math.sqrt(Math.pow(this.x - other.getX(), 2)
        + Math.pow(this.y - other.getY(), 2));
        
        if(distance < this.radius + other.radius)
        {
            return true;
        }
        
        return false;
    }
    
    public void bounce(int sizeX, int sizeY)
    {
        if(x+radius >= sizeX || x-radius <= 0)
        {
            dx = -dx;
        }
        else if(y+radius >= sizeY || y-radius <= 0)
        {
            dy = -dy;
        }
    }
    
    public void update(int sizeX, int sizeY)
    {
        bounce(sizeX, sizeY);
        
        x += dx;
        y += dy;
        
        draw();
    }
}
