import java.util.*;

public class MorseCode
{
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890 ";
    private final String[] morse = {".-", "-...", "-.-.", "-..", 
        ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", 
        "--", "-.", "---", ".--.", "--.-", ".-.", "...", 
        "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
        "..---", "...--", "....-", ".....", "-....", "--...", "---..",
        "----.", "-----", "|"};


    private HashMap<String, String> toText;
    private HashMap<String, String> toCode;
    
    public MorseCode()
    {
        toText = new HashMap();
        toCode = new HashMap();
        
        for(int i = 0; i < morse.length; i++)
        {
            toText.put(morse[i], Character.toString(alphabet.charAt(i)));
            toCode.put(Character.toString(alphabet.charAt(i)), morse[i]);
        }
    }
    
    public String encode(String s)
    {
        String morse = "";
        
        for(int i = 0; i < s.length(); i++)
        {
            morse += toCode.get(Character.toString(s.charAt(i)));
            morse += " ";
        }
        
        return morse;
    }
    
    public String decode(String s) //s is morse code
    {
        String text = "";
        int index = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            String curMorse = "";
            
            while(s.charAt(i) != ' ' && i < s.length()-1)
            {
                curMorse += s.charAt(i);
                i++;
            }
            
            if(i == s.length()-1)
            {
                break;
            }
            
            text += toText.get(curMorse);
        }
        
        return text;
    }
}