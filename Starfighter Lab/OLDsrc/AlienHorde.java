//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlienHorde implements Iterable<Alien>
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<>();

		for(int i = 0 ; i < size; i++){
			aliens.add(new Alien(30*(size%(int)10), 20*(size/(int)10), 10, 10, 5));
			System.out.println(30*(size%(int)10) + "  " + (20*(size/(int)10)));
		}
		System.out.println(aliens.size());
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for(Alien a : aliens){
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		//read docs
		for(int i = 0; i < aliens.size(); i++){
			aliens.get(i).move("LEFT");
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for(int i = 0; i < aliens.size(); i++){
			for(int j = 0; j < shots.size(); j++){
				if(StarFighterUtilities.collision(aliens.get(i), shots.get(j))){
					aliens.remove(i);
					shots.remove(j);
					i--;
					j--;
				}
			}
		}
	}

	public String toString()
	{
		return "";
	}

	@Override
	public Iterator<Alien> iterator() {
		return aliens.iterator();
	}
}
