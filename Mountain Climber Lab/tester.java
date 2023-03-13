public class tester
{
    public static void main(String a[])
    {
        int[][] arr = {{4,2,3,4,5}, {5,4,3,2,1}, {1,2,3,2,1}, {5,1,2,3,5}, {2,5,4,3,1}};
        
        int bestR = 0, bestC = 0;
        
        for(int r = 0; r < arr.length; r++)
        {
            if(arr[r][0] < arr[bestR][bestC])
            {
                bestR = r;
                bestC = 0;
            }
        }
        System.out.println(bestR + " " + bestC);
        
        int r = bestR;
        for(int c = 0; c < arr[0].length-1; c++)
        {
            //        | r-1,c+1  
            //    r,c | r,c+1
            //        | r+1,c+1
            
            
            if(c != arr[0].length || c != 0)
            {
                if(r == 0)
                {
                    if(Math.abs(arr[r][c] - arr[r][c+1]) <= Math.abs(arr[r][c] - arr[r+1][c+1]))
                    {
                        bestR = r;
                        bestC = c+1;
                        System.out.println(bestR + ", " +  bestC + "- top straight");
                    }
                    else
                    {
                        bestR = r+1;
                        bestC = c+1;
                        System.out.println(bestR + ", " +  bestC + "- top down");
                    }
                    r = bestR;
                    
                }
                else if(r == arr.length -1)
                {
                    if(Math.abs(arr[r][c] - arr[r][c+1]) <= Math.abs(arr[r][c] - arr[r-1][c+1]))
                    {
                        bestR = r-1;
                        bestC = c+1;
                        System.out.println(bestR + ", " +  bestC + "- down up");
                    }
                    else
                    {
                        bestR = r;
                        bestC = c+1;
                        System.out.println(bestR + ", " +  bestC + "- down straight");
                    }
                    
                    r = bestR;
                }
                else
                {   
                    if(Math.abs(arr[r][c] - arr[r-1][c+1]) <= Math.abs(arr[r][c] - arr[r+1][c+1]))
                    {
                        bestR = r-1;
                        bestC = c+1;
                        System.out.println(bestR + ", " +  bestC + "- mid up");
                    }
                    else
                    {
                        bestR = r+1;
                        bestC = c+1;
                        System.out.println(bestR + ", " +  bestC + "- mid down");
                    }
            
                    if(Math.abs(arr[r][c] - arr[r][c+1]) <= Math.abs(arr[r][c] - arr[bestR][bestC]))
                    {
                        bestR = r;
                        bestC = c+1;
                        System.out.println(bestR + ", " +  bestC + "- mid straight");
                    }
                    
                    r = bestR;
                }
                    
                System.out.println("(" + bestR + ", " + bestC + ")");
            }
        }
    }
}


