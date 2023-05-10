//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		this(x, y, 0);
	}

	public Ammo(int x, int y, int s)
	{
		super(x, y, 3, 5);
		speed = s;
	}

	public void setSpeed(int s)
	{
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.YELLOW);
		window.drawString("M", getX(), getY());
	}
	
	
	public void move( String direction )
	{
		switch(direction){
			case "LEFT":
				setX(getX()-speed);
				break;
			case "RIGHT":
				setX(getX()+speed);
				break;
			case "UP":
				setY(getY()-speed);
				break;
			case "DOWN":
				setY(getY()+speed);
				break;
		}
	}

	public String toString()
	{
		return "";
	}
}
