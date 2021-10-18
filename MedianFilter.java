/**
 * MedianFilter
 */
import java.util.Collections;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class MedianFilter {
    private BufferedImage filteredImage;
    private BufferedImage[] images;

    public MedianFilter(String[] imageInputFilenames){
    // constructor with array of names of the noisy images
        images = new BufferedImage[imageInputFilenames.length];
        for (int i = 0; i< imageInputFilenames.length; i++){
            images[i] = readImage(new File(imageInputFilenames[i]));
        }
    } 

    public BufferedImage readImage(File imageFile){
    // opens and reads in an image file
        BufferedImage img = null;
        try {
            img = ImageIO.read(imageFile);
        }
            catch(IOException e){
        } return img;

    } 


    public BufferedImage removeNoise(){
    // gets the median value for all pixels and returns the filtered noiseless image]
        filteredImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int y = 0; y<getHeight(); y++ ){
            for (int x = 0; x<getWidth(); x++){
                ArrayList<Integer> currPixel = new ArrayList<Integer>();
                for (BufferedImage k : images){
                    currPixel.add(k.getRGB(x,y));
                }
                filteredImage.setRGB(x, y, getMedianValue(currPixel)); 
            }
        } return filteredImage;
    } 
    public int getMedianValue(ArrayList<Integer> pixels){
        // returns the median value of the pixel(x,y) for all images
        int medianValue;
        Collections.sort(pixels);
        if (pixels.size()%2 == 0){
            medianValue = (pixels.get(pixels.size()/2)+ pixels.get(pixels.size()/2)) / 2;
        } else medianValue = pixels.get(pixels.size()/2);
        return (int)medianValue;
    } 
    public int writeImage(String outputFilename){
    // writes filteredImage to the outputFilename jpg file. Returns 0 if successful, or -1 if an exception was thrown.
        try {
            File outputFile = new File(outputFilename);

            ImageIO.write(removeNoise(), "jpg", outputFile); 
            return 1;
        }
        catch(IOException e){
        return -1;
        } 
    } 
    public int getHeight(){
    // returns height (y-dimension) of filteredImage
        return images[0].getHeight();
    } 
    public int getWidth(){
        return images[0].getWidth();
    } // returns width (x-dimension) of filteredImage

    
}