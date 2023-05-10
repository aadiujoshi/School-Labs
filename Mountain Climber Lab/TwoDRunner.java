public class TwoDRunner
{
    public static void main(String a[])
    {
        ////////////////////// SUM METHOD
        System.out.println(new
        TwoDArrayProbs
        (new int[][] {{1, 2}, {10, 11}})
        .
        sum());
        ////////////////////////// IsSQUARE METHOD
        System.out.println(new
        TwoDArrayProbs
        (new int[][] {{2, 3, 1}, {5, 4, 6}})
        .
        isSquare());
        ///////////////////////// ADDMATRIX METHOD
        new
        TwoDArrayProbs
        (new int[][] {{1,2,3},
        {3,2,1}}).addMatrix(new int[][] {{2,3,
        1}, {3,1,2}});
        ///////////////////////// COLUMNSUM METHOD
        System.out.println(new
        TwoDArrayProbs
        (new int[][] {{1, 2, 3}, {4, 5, 6}, {6}}).columnSum(2));
        ///////////////////////// COLUMNMAGIC METHOD
        System.out.println(new
        TwoDArrayProbs
        (new int[][] {{1, 2, 3}, {1}, {2, 2, 1}})
        .
        isColumnMagic());
        ///////////////////////// DIAGONALDIFFERENCE METHOD 
        System.out.println(new TwoDArrayProbs(new int[][] {{1, 2, 3}, {3, 2, 1}, {7, 2, 2}}).diagDifference());
    }
}