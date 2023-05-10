

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations implements Runnable
{
    private ArrayList<Circle> circles; //the circles to animate
    private int               size;    //canvas width and height (will be square)
    private Random            rng;     //use to make random numbers

    /** create a drawing pane of a particular size */
    public CircleAnimations(int s) {
        circles = new ArrayList<>();
        size    = s;
        rng     = new Random();
        
        //don't mess with this
        StdDraw.setCanvasSize(size, size); //set up drawing canvas
        StdDraw.setXscale(0, size);        //<0, 0> is bottom left.  <size-1, size-1> is top right
        StdDraw.setYscale(0, size);
    }
    
    public void drawCircles()
    {
        for(int i = 0; i < circles.size(); i++)
        {
            circles.get(i).draw();
        }
    }
    
    public void addCircles(int num)
    {
        for(int i = 0; i < num; i++)
        {
            circles.add(new Circle(rng.nextInt(size), rng.nextInt(size), 
            rng.nextInt(26), new Color(rng.nextInt(255), rng.nextInt(255), 
            rng.nextInt(255))));
        
            circles.get(i).draw();
        }
    }
    
    public void addCircles()
    {
        for(int i = 0; i < rng.nextInt(100); i++)
        {
            circles.add(new Circle(rng.nextInt(size), rng.nextInt(size), 
            rng.nextInt(26), new Color(rng.nextInt(255), rng.nextInt(255), 
            rng.nextInt(255))));
        
            circles.get(i).draw();
        }
    }
    
    //this method is only for no overlap method
    public Circle getRandomCircle()
    {
        return new Circle(rng.nextInt(size), rng.nextInt(size), 
            rng.nextInt(75), new Color(rng.nextInt(255), rng.nextInt(255), 
            rng.nextInt(255)));
    }
    
    //this method is only for no overlap method
    public Circle getRandomCircleWithVelocity()
    {
        return new Circle(size/2, size/2,
            rng.nextInt(10)-5, rng.nextInt(10)-5,
            rng.nextInt(75), new Color(rng.nextInt(255), rng.nextInt(255), 
            rng.nextInt(255)));
    }
    
    public void noOverlapping()
    { 
        for(int n = 0; n <= 2000; n++)
        {
            circles.add(n, getRandomCircle());
            
            for(int i = 0; i < circles.size()-1; i++)
            {
                if(circles.get(n).overlaps(circles.get(i)))
                {
                    circles.set(n, getRandomCircle());
                    i = 0;
                }
            }
            if(n != 0)
            {
                circles.get(n).draw();
            }
        }
        System.out.println("done");
    }
    
    public void movingCircles()
    {
        for(int i = 0; i < 5; i++)
        {
            circles.add(i, getRandomCircleWithVelocity());
            //circles.setDX((int)(Math.random * 6 + 1));
            //circles.setDY((int)(Math.random * 6 + 1));
            circles.get(i).draw();
        }
        for(;;)
        {
            for(int i = 0; i < circles.size(); i++)
            {
                circles.get(i).update(size, size);
            }
            StdDraw.show(10);
            StdDraw.clear();
        }
    }
    
    public void run() //movingCircles() runs in a seperate thread
    {
        movingCircles();
    }
    
    public void removeClicked()
    {
        while(true)
        {
            if(StdDraw.isMousePressed())
            {
                for(int i = 0; i < circles.size(); i++)
                {
                    //the new Circle() acts as an xy point
                    //for the mouse to be compared with
                    if(circles.get(i).overlaps(new Circle
                    ((int)StdDraw.mouseX(), (int)StdDraw.mouseY(),
                    1, Color.WHITE)))
                    {
                        circles.remove(i);
                        break;
                    }
                }
            }
        }
    }
}





