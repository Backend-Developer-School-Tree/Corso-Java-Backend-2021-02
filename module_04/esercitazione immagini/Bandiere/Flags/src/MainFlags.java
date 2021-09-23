import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFlags {


    public static void main(String[] args) throws IOException {
        ImageIO.write(poland(), "jpg", new File("poland.jpg"));
    }


    private static BufferedImage poland()
    {
        int redColor = new Color(255,0,0).getRGB();
        int whiteColor = new Color(255,255,255).getRGB();
        BufferedImage outputImage = new BufferedImage(300, 300, BufferedImage.TYPE_3BYTE_BGR);
        for (int row = 0; row < outputImage.getHeight(); row++)
            for(int col = 0; col < outputImage.getWidth(); col++)
                if(row <= outputImage.getHeight() / 2)
                    outputImage.setRGB(col,row, redColor);
                else
                    outputImage.setRGB(col,row, whiteColor);
        return outputImage;
    }


    private static BufferedImage italy()
    {
        return null;
    }

    private static BufferedImage france()
    {
        return null;
    }


}