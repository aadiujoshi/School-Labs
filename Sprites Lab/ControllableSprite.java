import java.awt.event.KeyEvent;

public class ControllableSprite extends BouncingSprite
{
    public ControllableSprite(double x, double y, double vx, double vy, 
    int width, int height, String image)
    {
        super(x, y, vx, vy, width, height, image);
    }
    
    @Override 
    public void step(World world)
    {
        if(StdDraw.isKeyPressed(KeyEvent.VK_UP))
            yStep(false);
        if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN))
            yStep(true);
        if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
            xStep(false);
        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
            xStep(true);
        super.bounce(world);
    }
    
    public void xStep(boolean backwards) 
    {
        if(backwards)
            setX(getX()+(-1*getVX()));
        else
            setX(getX()+getVX());
    }
    
    public void yStep(boolean backwards)
    {
        if(backwards)
            setY(getY()+(-1*getVY()));
        else
            setY(getY()+getVY());
    }
}