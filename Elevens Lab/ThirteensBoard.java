import java.util.*;

public class ThirteensBoard extends Board
{
    private static final int BOARD_SIZE = 10;
    private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static final boolean I_AM_DEBUGGING = false;
    
    public ThirteensBoard()
    {
        super(BOARD_SIZE, POINT_VALUES);
    }
    
    @Override
    public boolean isLegal(List<Integer> selected)
    {
        return (selected.size() == 1 && 
                cardAt(selected.get(0)).rank() == "king") ||
                (selected.size() == 2 && containsPairSum(selected, 13));
    }
    
    @Override
    public boolean anotherPlayIsPossible()
    {
        List<Integer> cInd = cardIndexes();
        for(Integer i : cInd)
            if(cardAt(i).rank() == "king")
                return true;
        return containsPairSum(cInd, 13);
    }
}