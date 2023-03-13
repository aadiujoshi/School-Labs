public class MobileSprite extends Sprite
{
    private double vx, vy;
    
    public MobileSprite(double x, double y, double vx, double vy, 
    int width, int height, String image)
    {
        super(x, y, width, height, image);
        
        this.vx = vx;
        this.vy = vy;
    }
    
    public void step(World world)
    {
        setX(getX()+vx);
        setY(getY()+vy);
    }
    
    public double getVX()
    {
        return vx;
    }
    
    public double getVY()
    {
        return vy;
    }
    
    public void setVX(double nvx)
    {
        vx = nvx;
    }
    
    public void setVY(double nvy)
    {
        vy = nvy;
    }
}