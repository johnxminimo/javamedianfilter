/**
 * TestClient
 */
public class TestClient {
    public static void main(String[] args) {
        String[] filePaths = new String[8];
        filePaths[0] = "/Users/johnminimo/vsc/Program4/veg1.jpg";
        filePaths[1] = "/Users/johnminimo/vsc/Program4/veg2.jpg";
        filePaths[2] = "/Users/johnminimo/vsc/Program4/veg1.jpg";
        filePaths[3] = "/Users/johnminimo/vsc/Program4/veg1.jpg";
        filePaths[4] = "/Users/johnminimo/vsc/Program4/veg1.jpg";
        filePaths[5] = "/Users/johnminimo/vsc/Program4/veg1.jpg";
        filePaths[6] = "/Users/johnminimo/vsc/Program4/veg1.jpg";
        filePaths[7] = "/Users/johnminimo/vsc/Program4/veg1.jpg";
        MedianFilter test = new MedianFilter(filePaths);
        test.removeNoise();
        System.out.println(test.writeImage("output.jpg"));
    }
    
}