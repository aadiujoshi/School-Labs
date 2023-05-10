public class tester
{
    public static void main(String ares[])
    {
        double[] clip = {0.5, 1, 0,-1};
        Sound.show(clip);
        Sound.play(clip);
        
        SoundLabProbs slp = new SoundLabProbs();
        
        slp.lastIndexOf(new int[] {8, 2, 4, 6, 8}, 8);
        slp.lastIndexOf(new int[] {2, 4, 6, 12}, 8);
        
        slp.range(new int[] {8, 3, 5, 7, 2, 4});
        slp.range(new int[] {15, 22, 8, 19, 31});
        
        slp.minDifference(new int[] {4, 8, 6, 1, 5, 9, 4});
        
        slp.reverseWords("hello world");
        slp.reverseWords("the sky is blue");
        
        slp.priceIsRight(new int[] {900, 885, 990, 1}, 800);
        slp.priceIsRight(new int[] {1500, 1600, 2000, 2500}, 1900);
        
        slp.productExceptSelf(new int[] {1, 2, 3, 4});
    }
}