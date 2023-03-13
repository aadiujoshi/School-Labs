import java.util.*;

public class SoundClip
{
    double clip[];
    
    public SoundClip()
    {
        clip = null;
    }
    
    public SoundClip(double[] sClip)
    {
        clip = sClip;
    }
    
    public void adjustVolume(double factor)
    {
        for(int i = 0; i < clip.length; i++)
        {
            clip[i] *= factor;
        }
    }
    
    public void mix(double[] clip1, double[] clip2)
    {
        clip = new double[clip1.length + clip2.length];
        int limit = 0;
        int remaining = 0;
        boolean clip1Greater = false;
        boolean clip2Greater = false;
        
        if(clip1.length > clip2.length)
        {
            limit = clip2.length;
            remaining = clip1.length - clip2.length;
            clip1Greater = true;
        }
        else if(clip2.length > clip1.length)
        {
            limit = clip1.length;
            remaining = clip2.length - clip1.length;
            clip2Greater = true;
        }
        
        for(int i = 0; i < limit; i++)
        {
            clip[i] = clip1[i] + clip2[i];
        }
        
        for(int i = limit; i < remaining; i++)
        {
            if(clip1Greater)
            {
                clip[i] = clip1[i];
            }
            if(clip2Greater)
            {
                clip[i] = clip2[i];
            }
        }
    }
    
    public void append(double[] other)
    {
        double result[] = new double[clip.length + other.length];
        
        for(int i = 0; i < clip.length; i++)
        {
            result[i] = clip[i];
        }
        for(int i = clip.length; i < other.length; i++)
        {
            result[i] = other[i];
        }
        
        clip = result;
    }
    
    public void fadeIn(double seconds)
    {
        int fadeSamples = Sound.toNumSamples(seconds);
        
        for(int i = 0; i < fadeSamples; i++)
        {
            clip[i] *= (double)i/fadeSamples; 
        }
    }
    
    public void fadeOut(double seconds)
    {
        int fadeSamples = Sound.toNumSamples(seconds);
        int counter = fadeSamples;
        
        for(int i = clip.length-fadeSamples; i < clip.length; i++)
        {
            clip[i] *= (double)counter/fadeSamples;
            counter--;
        }
    }
    
    public void reverse()
    {
        for(int i = 0; i < clip.length/2; i++)
        {
            double n = clip[i];
            
            clip[i] = clip[clip.length-i-1];

            clip[clip.length-i-1] = n;
        }
    }
    
    public void speedUp(double factor)
    {
        for(int i = 0; i < clip.length-1; i++)
        {
            if(i % 2 != 0)
            {
                clip[i] = 0;
            }
            if(i > clip.length/2)
            {
                clip[i] = 0;
            }
        }
    }
}


