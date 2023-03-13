public class SoundLabProbs
{
    public int lastIndexOf(int[] nums, int value)
    {
        int index = 0;
        for(int i = 0; i <= nums.length-1; i++)
        {
            if(nums[i] == value)
            {
                index = i;
            }
        }
        return index; 
    }
    
    public int range(int[] nums)
    {
        int largest = nums[0];
        int smallest = nums[0];
        
        for(int n : nums)
        {
            if(n > largest)
            {
                largest = n;
            }
            if(n < smallest)
            {
                smallest = n;
            }
        }
        
        return largest - smallest;
    }
    
    public int minDifference(int[] nums)
    {
        int minDiff = 0;
        
        for(int i = 0; i <= nums.length-2; i++)
        {
            if(Math.abs(nums[i] - nums[i+1]) < minDiff)
            {
                minDiff = Math.abs(nums[i] - nums[i+1]);
            }
        }
        
        return minDiff;
    }
    
    public String reverseWords(String str)
    {
        String wordArray[] = str.split(" ");
        String reversedString = "";
        int length = wordArray.length;
        
        for(int i = length-1; i >= 0; i--)
        {
            reversedString += wordArray[i] + " ";
        }
        
        return reversedString;
    }
    
    public int priceIsRight(int[] bids, int price)
    {
        int closest = -1;
        
        for(int n : bids)
        {
            if(n < price && n > closest)
            {
                closest = n;
            }
        }
        
        return closest;
    }
    
    public int[] productExceptSelf(int[] nums)
    {
        int product[] = new int[nums.length];
        
        for(int i = 0; i <= product.length-1; i++)
        {
            product[i] = 1;
        }
        
        for(int i = 0; i <= nums.length-1; i++)
        {
            for(int n : nums)
            {
                product[i] *= n;
            }
            product[i] /= nums[i];
        }
        
        return product;
    }
}


