public class Team
{
    private Player players[];
    
    public Team()
    {
        players = new Player[12];
    }
    
    public Team(int numPlayers)
    {
        players = new Player[numPlayers];
    }
    
    public Player getPlayerAtIndex(int i)
    {
        return players[i];
    }
    
    public void addPlayer(Player p, int index)
    {
        players[index] = p;
    }
    
    public void printTeamStats()
    {
        for(int i = 0; i < players.length; i++)
        {
            System.out.println(players[i]);
        }
    }
}

