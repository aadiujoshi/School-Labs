import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class HashMapProbs
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        
        HashMap<String, String> animalSounds = new HashMap();
        
        animalSounds.put("Dog", "Woof");
        animalSounds.put("Lion", "Roar");
        animalSounds.put("Chicken", "Cluck");
        animalSounds.put("Bird", "Chirp");
        
        System.out.println(animalSounds);
        
        String newAnimal = s.nextLine();
        String newSound = s.nextLine();
        
        animalSounds.put(newAnimal, newSound);
        
        System.out.println(animalSounds);
        
        //test methods
        
        highestFrequency();
        //takeBefore();
        System.out.println(multiple("thallium"));
        System.out.println(takeBefore("str", "bye"));
        System.out.println(charWord(new String[]{"salt", "tea", "soda", "taco"}));
    }
    
    public static void highestFrequency()
    {
        HashMap<String, Integer> wordCount = new HashMap();
        
        try
        {
            Scanner fileR = new Scanner(new File("dream.txt"));
            
            while(fileR.hasNext())
            {
                String token = fileR.next().toLowerCase();
                
                if(wordCount.get(token) != null)
                {
                    wordCount.put(token, wordCount.get(token)+1);
                }
                else
                {
                    wordCount.put(token, 0);
                }
            }
            
            int max = Collections.max(wordCount.values());
            
            for(String key: wordCount.keySet())
            {
                if(wordCount.get(key) == max)
                {
                    System.out.println("Highest frequency word: "
                     + key + ", " + max);
                }
            }
        }
        catch(FileNotFoundException fnaf) {System.out.println("error");}
    }
    
    public static HashMap<String, String> takeBefore(String a, String b)
    {
        //Strings are the same length
        HashMap<String, String> newHash = new HashMap();
        
        for(int i = 0; i < a.length(); i++)
        {
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);
            
            if(aChar < bChar)
            {
                newHash.put(Character.toString(aChar), 
                Character.toString(bChar));
            }
            else
            {
                newHash.put(Character.toString(bChar), 
                Character.toString(aChar));
            }
        }
        
        return newHash;
    }
    
    public static HashMap<String, Boolean> multiple(String s)
    {
        HashMap<String, Boolean> newHash = new HashMap();
        
        for(int i = 0; i < s.length(); i++)
        {
            boolean repeats = false;
            for(int j = 0; j < s.length(); j++)
            {
                if(j != i && s.charAt(j) == s.charAt(i))
                {
                    repeats = true;
                }
            }
            newHash.put(Character.toString(s.charAt(i)), 
            repeats);
        }
        
        return newHash;
    }
    
    
    public static HashMap<String, String> charWord(String[] words)
    {
        HashMap<String, String> newHash = new HashMap();
        
        for(int i = 0; i < words.length; i++)
        {
            String prev = newHash.get(Character.toString(words[i].charAt(0)));
            
            newHash.put(Character.toString(words[i].charAt(0)), 
            (prev + words[i]).replace("null", ""));
        }
        
        return newHash;
    }
}