//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,30,30,10);
	}

	public Alien(int x, int y)
	{
		this(x, y, 30, 30, 10);
	}

	public Alien(int x, int y, int s)
	{
		this(x, y);
		speed = s;
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("/images/alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

    public void move(String direction)
	{
		switch(direction){
			case "LEFT":
				if(speed > 0)
					if(getX()-speed >= 0)
						setX(getX()-speed);
					else speed *= -1;

				if(speed < 0)
					if(getX()-speed+getWidth() <= 800)
						setX(getX()-speed);
					else speed *= -1;

				break;
		}
	}

	public void draw( Graphics window )
	{
		// System.out.println(getX() + "  " + getY());
   		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return "";
	}
}
