//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	// private Alien alienOne;
	// private Alien alienTwo;
	private AlienHorde aliens;
	private Bullets shots;

	/* uncomment once you are ready for this part
	 *
   private AlienHorde horde;
	private Bullets shots;
	*/

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
		this.setSize(800, 500);
		ship = new Ship(getWidth()/2, getHeight()/2, 100, 100, 10);
		// alienOne = new Alien(200, 200, 20, 20, 5);
		// alienTwo = new Alien(100, 100, 20, 20, 5);
		aliens = new AlienHorde(18);
		shots = new Bullets();

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the background image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

		//add code to move Ship, Alien, etc.

		aliens.moveEmAll();
		shots.moveEmAll();

		aliens.removeDeadOnes(shots.getList());

		for(Alien a : aliens){
			if(StarFighterUtilities.collision(ship, a)){
				graphToBack.setFont(new Font("Sans Serif", Font.BOLD, 100));
				graphToBack.drawString("GAME OVER", 250, 250);
				return;
			}
		}

		if(!ship.collision(getWidth(), getHeight())){
			if(keys[0] == true) ship.move("LEFT"); 
			if(keys[1] == true) ship.move("RIGHT");
			if(keys[2] == true) ship.move("UP");
			if(keys[3] == true) ship.move("DOWN");
			if(keys[4]) shots.add(new Ammo(ship.getX(), ship.getY(), 5));
		}

		aliens.drawEmAll(back.getGraphics());
		shots.drawEmAll(back.getGraphics());
		ship.draw(back.getGraphics());
		
		twoDGraph.drawImage(back, null, 0, 0);
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
			Thread.sleep(5);
        	repaint();
        }
      } catch(Exception e) { }
  	}
}

