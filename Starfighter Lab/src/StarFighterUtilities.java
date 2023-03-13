import javax.swing.SwingUtilities;

public class StarFighterUtilities {
    
    public static boolean collision(Moveable m1, Moveable m2){
        return SwingUtilities.isRectangleContainingRectangle(
            new java.awt.Rectangle(m1.getX(), m1.getY(), m1.getWidth(), m1.getHeight()), 
            new java.awt.Rectangle(m2.getX(), m2.getY(), m2.getWidth(), m2.getHeight()));
    }

    // public static boolean edgeCollision(Moveable m, int step, int width, int height){
    //     // if(m instanceof Ship)
    //     // System.out.println(m.getClass() + "  " + (m.getX()-step < 0 || m.getX()+step > width ||
    //     // m.getY()-step < 0 || m.getY()+step > height));

	// 	return m.getX()-step < 0 || m.getX()+step > width ||
    //             m.getY()-step < 0 || m.getY()+step > height;
    // }
}
