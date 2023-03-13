//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10,10,10,10);
	}

	public Ship(int x, int y)
	{
		this(x, y, 10, 10, 10);
	}

	public Ship(int x, int y, int s)
	{
		this(x, y);
		speed = s;
	}

	// public boolean collision(int width, int height){
	// 	return StarFighterUtilities.edgeCollision(this, getSpeed(), width, height);
	// }

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			image = ImageIO.read(new File("images/ship.jpg"));
		}
		catch(Exception e) {
			System.out.println("file not found");
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
				if(getX()-speed >= 0)
					setX(getX()-speed);
				break;
			case "RIGHT":
				if(getX()+speed+getWidth() <= 800)
					setX(getX()+speed);
				break;
			case "UP":
				if(getY()-speed >= 0)
					setY(getY()-speed);
				break;
			case "DOWN":
				if(getY()+speed+getHeight() <= 500)
					setY(getY()+speed);
				break;
		}
	}

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
