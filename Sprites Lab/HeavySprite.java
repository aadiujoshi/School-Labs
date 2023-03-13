public class HeavySprite extends BouncingSprite
{
    public HeavySprite(double x, double y, double vx, double vy, 
    int width, int height, String image)
    {
        super(x, y, vx, vy, width, height, image);
    }
    
    public void step(World world)
    {
        super.step(world);
        
        setY(getY()-0.1);
    }
}