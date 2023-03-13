import java.io.*;
import java.util.*;

public class Runner
{
    public static void main(String a[]) throws FileNotFoundException
    {
        try
        {
            File playerFile = new File("players.txt");
            Scanner fileReader = new Scanner(playerFile);
            int p = fileReader.nextInt();
            
            Team liberty = new Team(p);
            
            for(int i = 0; i < p; i++)
            {
                String pName = fileReader.next();
                int pNumber = fileReader.nextInt();
                int pAtBats = fileReader.nextInt();
                int pHits = fileReader.nextInt();
                
                Player newPlayer = new Player(pName, pNumber, pAtBats, pHits);
                
                System.out.println(newPlayer + "\n");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("lol missing");
        }
    }
}

