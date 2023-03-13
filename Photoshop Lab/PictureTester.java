import java.awt.*;

public class PictureTester 
{
    public static void main(String[] args) 
    {
        //construct a Picture object from a jpg image on disk
        Picture img = new Picture("beach.jpg"); 
        img.view();
        //PUT YOUR TESTS HERE
        
        //img.zeroBlue();       
        //img.keepOnlyBlue();       
        //img.negate();       
        //img.solarize(127);       
        //img.grayscale();       
        //img.tint(1.25, 0.75, 1);       
        //img.posterize(63);          
        //img.mirrorRightToLeft();       
        //img.mirrorHorizontal();       
        //img.verticalFlip();
        //img.fixRoof(); 
        //img.edgeDetection(25); 
        //img.chromakey(new Picture("moon-surface.jpg"), Color.BLUE, 1);       
        //img.encode(new Picture("msg.jpg"));       
        //img.decode();       
        //img.simpleBlur().view();       
        img.blur(5).view();       
        //img.glassFilter(5).view();       
        
        img.view();
    }
    
    /** this method is static, you don't need to call it on an object (just "testChromekey()") */
    public static void testChromakey()
    {
        Picture one = new Picture("blue-mark.jpg");
        Picture two = new Picture("moon-surface.jpg");
    
        one.view(); //show original mustache guy picture
        two.view(); //show the untouched moon's surface pic
    
        one.chromakey(two, new Color(10, 40, 75), 60); //replace this color if within 60
    
        one.view();
    }
    
    /** this method is static, you don't need to call it on an object (just "testSteganography()") */
    public static void testSteganography()
    {
        Picture msg   = new Picture("msg.jpg");
        Picture beach = new Picture("beach.jpg");
        
        beach.encode(msg); //hide message in beach picture
        beach.view();      //beach w/ hidden message inside, shouldn't look different
    
        beach.decode().view(); //see the hidden message in the beach picture
    }
}

