public class BouncingSprite extends MobileSprite
{
    public BouncingSprite(double x, double y, double vx, double vy, 
    int width, int height, String image)
    {
        super(x, y, vx, vy, width, height, image);
    }
    
    @Override
    public void step(World world)
    {
        super.step(world);
        bounce(world);
    }
    
    public void bounce(World world)
    {
        double x = getX();
        double y = getY();
        double vx = getVX();
        double vy = getVY();
        int width = getWidth();
        int height = getHeight();
        int wWidth = world.getWidth();
        int wHeight = world.getHeight();
        
        if(x-width/2 < 0)
            setVX(-1*vx);
        if(x+width/2 > wWidth)
            setVX(-1*vx); 
        if(y-width/2 < 0)
            setVY(-1*vy);
        if(y+height/2 > wHeight)
            setVY(-1*vy);
    }
}