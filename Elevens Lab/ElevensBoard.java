import java.util.List;
import java.util.ArrayList;

public class ElevensBoard extends  Board{
    private static final int BOARD_SIZE = 9;
    private static final int[] POINT_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
    private static final boolean I_AM_DEBUGGING = false;

    public ElevensBoard() {
        super(BOARD_SIZE, POINT_VALUES);
    }
    
    public boolean isLegal(List<Integer> selectedCards) {
        return (selectedCards.size() == 2 && 
            containsPairSum(selectedCards, 11)) ||
            (selectedCards.size() == 3 && containsJQK(selectedCards));
    }
    
    public boolean anotherPlayIsPossible() {
        List<Integer> cIndexes = cardIndexes();
        return containsPairSum(cIndexes, 11) || containsJQK(cIndexes);
    }
    
    private boolean containsJQK(List<Integer> selectedCards) 
    {
        boolean king = false;
        boolean queen = false;
        boolean jack = false;
        for(Integer faceCard : selectedCards)
        {
            int i = faceCard.intValue();
            if(cardAt(i).rank().equals("king"))
                king = true;
            else if(cardAt(i).rank().equals("queen"))
                queen = true;
            else if(cardAt(i).rank().equals("jack"))
                jack = true;
        }
        if(king == true && queen == true && jack == true)
            return true;
        return false;
    }
}