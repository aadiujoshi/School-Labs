import java.awt.*;

public class CircleRunner {
    static CircleAnimations app;
    
    public static void main(String[] args) {
        app = new CircleAnimations(600); //supply window size, will be 600x600

        
        //TEST ONE AT A TIME   
        
        //app.addCircles(100);
        //app.drawCircles();
        //app.noOverlapping();
        //testRemoveMovingCircles();
        //testCircleOverlap(); 
    }
    
    public static void testRemoveMovingCircles()
    {
        Thread t2 = new Thread(app);
        t2.start(); 
        app.removeClicked();
        /*
         * t2 is a 2nd parallel thread to run removeClicked() 
         * since there are 2 while(true) loops
        */
    }
    
    public static void testCircleOverlap() { //uncomment contents to use
        /*
         * The distance between a and b is ~2.83, which is greater than the combined radius of 2 (a and b do NOT overlap)
         *
         * The distance between a and c is ~2.83, which is less    than the combined radius of 6 (a and c overlap)
         */
              Circle a = new Circle(1, 1, 1, null); //color is irrelevant for this
              Circle b = new Circle(3, 3, 1, null);
              Circle c = new Circle(3, 3, 5, null);
        
              System.out.println(a.overlaps(b)); //should print false
              System.out.println(a.overlaps(c)); //should print true
    }
}

