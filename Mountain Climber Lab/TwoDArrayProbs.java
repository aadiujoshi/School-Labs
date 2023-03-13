public class TwoDArrayProbs
{
    private int[][] nums;
    
    public TwoDArrayProbs(int[][] numArray)
    {
        nums = numArray;
    }
    
    public int sum()
    {
        int sum = 0;

        for(int r = 0; r < nums.length; r++)
        {
            for(int c = 0; c < nums[0].length; c++)
            {
                sum += nums[r][c];
            }
        }
        
        return sum;
    }
    
    public boolean isSquare()
    {
        if(nums.length == nums[0].length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void addMatrix(int[][] other)
    {
        for(int r = 0; r < nums.length; r++)
        {
            for(int c = 0; c < nums[0].length; c++)
            {
                nums[r][c] += other[r][c];
            }
        }
        
        this.print();
    }
    
    public void print()
    {
        for(int rowArr[] : nums)
        {
            for(int num : rowArr)
            {
                System.out.println(num);
            }
        }
    }
    
    public int columnSum(int col)
    {
        int colSum = 0;
        
        for(int r = 0; r < nums.length; r++)
        {
            if(r < nums[r].length)
            {
                colSum += nums[r][col];
            }
        }
        
        return colSum;
    }
    
    public boolean isColumnMagic()
    {
        int curColSum = 0;
        int magicNum = 0;
        
        int longestRowLength = 0; 
        
        for(int[] rowArr : nums)
        {
            longestRowLength = Math.max(longestRowLength, rowArr.length);
        }
        
        for(int atCol = 0; atCol < longestRowLength; atCol++)
        {
            for(int atRow = 0; atRow < nums.length; atRow++)
            {
                if(atCol == 0)
                {
                    magicNum += nums[atRow][0];
                }
                if(atCol < nums[atRow].length)
                {
                    curColSum += nums[atRow][atCol];
                }
            }
            if(curColSum != magicNum)
            {
                return false;
            }
            curColSum = 0;
        }
        return true;
    }
    
    public int diagDifference()
    {
        int diagDiff = 0;
        
        
        for(int n = 0; n < nums[0].length; n++)
        {
            diagDiff += nums[0+n][n];
            diagDiff -= nums[nums.length-n-1][n];
        }
        
        return Math.abs(diagDiff);
    }
}

