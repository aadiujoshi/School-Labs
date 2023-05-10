public class SoundTester
{
    public static void main(String[] args)
    {
        adjustVolumeTest(); 
        
        mixTest();
        
        appendTest();
        
        fadeInTest();
        
        fadeOutTest();
        
        reverseTest();
        
        speedUpTest();
    }
    
    public static void adjustVolumeTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 1));
        
        Sound.show(s.clip);
        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        s.adjustVolume(0.25); 
        
        Sound.show(s.clip); 
        Sound.play(s.clip); 
    }
    
    
    public static void mixTest()
    {
        SoundClip s = new SoundClip();
        
        double[] clip1 = Sound.pureTone(3, 1);
        double[] clip2 = Sound.pureTone(5, 1);
        
        Sound.show(clip1);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        Sound.show(clip2);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        s.mix(clip1, clip2);

        Sound.show(s.clip); 
    }
    
    public static void appendTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(3, 1)); 

        Sound.show(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        s.append(Sound.pureTone(5, 2));

        Sound.show(s.clip); 
    }
    
    public static void fadeInTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 3));
        
        s.fadeIn(1);
        
        Sound.show(s.clip);
        Sound.play(s.clip); 
    }
    
    public static void fadeOutTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 3));
        
        s.fadeOut(1);
        
        Sound.show(s.clip); 
        Sound.play(s.clip); 
    }
    
    public static void reverseTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(200, 3));
        
        s.fadeIn(3);
        
        Sound.show(s.clip); 
        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        
        s.reverse();
        
        Sound.show(s.clip); 
        Sound.play(s.clip);
    }
    
    public static void speedUpTest()
    {
        SoundClip s = new SoundClip(Sound.pureTone(300, 4));
        
        Sound.show(s.clip);
        Sound.play(s.clip);
        try { Thread.sleep(4000); } catch (InterruptedException e) {}
        
        s.speedUp(4); 
        
        Sound.show(s.clip);
        Sound.play(s.clip);
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
    } 
}
