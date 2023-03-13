import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Runner {
    public static void main(String[] args) {
        QueueProbs test = new QueueProbs();
        // System.out.println(test.evenFirst(new LinkedList<Integer>(Arrays.asList(new Integer[]{3,5,4,17,6,83,1,84,16,37}))));
        // System.out.println(test.numPalindrome(new LinkedList<Integer>(Arrays.asList(new Integer[]{1,2,3,3,4,5,4,3,2,1}))));
        System.out.println(test.sieveOfEratosthenes(100));
        

    }
}