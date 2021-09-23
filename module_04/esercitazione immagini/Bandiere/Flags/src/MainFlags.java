import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFlags {


    public static void main(String[] args) throws IOException {
        ImageIO.write(poland(), "jpg", new File("poland.jpg"));
        ImageIO.write(italy(), "jpg", new File("italy.jpg"));
        ImageIO.write(france(), "jpg", new File("france.jpg"));
        ImageIO.write(Belgium(), "jpg", new File("belgium.jpg"));
    }


    private static BufferedImage poland()
    {
        int redColor = new Color(255,0,0).getRGB();
        int whiteColor = new Color(255,255,255).getRGB();
        BufferedImage outputImage = new BufferedImage(300, 300, BufferedImage.TYPE_3BYTE_BGR);
        for (int row = 0; row < outputImage.getHeight(); row++)
            for(int col = 0; col < outputImage.getWidth(); col++)
                if(row <= outputImage.getHeight() / 2)
                    outputImage.setRGB(col,row, whiteColor);
                else
                    outputImage.setRGB(col,row, redColor);
        return outputImage;
    }


    private static BufferedImage ThreeVerticalStripesFlag(int color1, int color2, int color3)
    {
        BufferedImage outputImage = new BufferedImage(300, 300, BufferedImage.TYPE_3BYTE_BGR);
        int sizeStripe = outputImage.getWidth() / 3;
        for (int row = 0; row < outputImage.getHeight(); row++)
            for(int col = 0; col < outputImage.getWidth(); col++)
            {
                int color = col / sizeStripe;
                switch (color)
                {
                    case 0:
                        outputImage.setRGB(col,row, color1);
                        break;
                    case 1:
                        outputImage.setRGB(col,row, color2);
                        break;
                    case 2:
                        outputImage.setRGB(col,row, color3);
                        break;
                }
            }
        return outputImage;
    }


    private static BufferedImage Belgium()
    {
        return ThreeVerticalStripesFlag(new Color(0,0,0).getRGB(), new Color(255,200,0).getRGB(), new Color(255,0,0).getRGB());
    }

    private static BufferedImage italy()
    {
        return ThreeVerticalStripesFlag(new Color(0,255,0).getRGB(), new Color(255,255,255).getRGB(), new Color(255,0,0).getRGB());
    }

    private static BufferedImage france()
    {
        return ThreeVerticalStripesFlag(new Color(0,0,255).getRGB(), new Color(255,255,255).getRGB(), new Color(255,0,0).getRGB());
    }
}