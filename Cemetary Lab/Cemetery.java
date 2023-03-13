import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Cemetery
{
    private ArrayList<Tombstone> tombstones;
    
    public Cemetery(String fileName)
    {
        tombstones = new ArrayList();
        double totalAge = 0;
        int totalPeople = 0;
        
        try
        {
            File file = new File(fileName);
        
            Scanner lineCounter = new Scanner(file);
            
            while(lineCounter.hasNext())
            {
                String line = (String)lineCounter.nextLine();
                
                String name = line.substring(0, 24); // 1-25
                String DOD = line.substring(25, 36); // 26-37
                double age = parseAge(line.substring(37, 41).trim());   // 38-42
                String address = line.substring(42);  //43-end
                
                age = (double)Math.round((age/365)*100)/100;
                
                if(address.contains("Little Carter Lane"))
                {
                    totalPeople++;
                    totalAge += age;
                }
                
                Tombstone t;
                
                tombstones.add(t = new Tombstone(name, DOD, 
                age, address));
                
                System.out.println(t);
            }
        }
        catch(FileNotFoundException e){}
        System.out.println(totalAge/totalPeople);
    }
    
    
    
    //---------------------------------------------
    //---------------------------------------------
    //---------------------------------------------
    /** 
     * convert the ageString to a number of days; age can 
     * take a variety of forms in the data file
     */
    public static int parseAge(String ageString)
    {
        
        
        if (ageString.contains("d")) { //age supplied in days
            ageString = ageString.replaceAll("d", "");
            return Integer.parseInt(ageString);
        }
        
        int result = 0;
        
        boolean done = true;

        try { result = Integer.parseInt(ageString); } //is the String a whole number of years?
        
        catch (NumberFormatException n) { done = false; }
        
        if (done) //successfully parsed as an int, return value
            return 365 * result; //ignoring leap years
        
        double ageDouble = 0;
        
        done = true;
        
        try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?
        
        catch (NumberFormatException n) { done = false; }
        
        if (done) { //successfully parse as a double, String doesn't contain any text
            return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
        }
        
        if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
            ageString = ageString.replaceAll("w", "");
            return Integer.parseInt(ageString) * 7;
        }
        
        return 0;
    }
}
