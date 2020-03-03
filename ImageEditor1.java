import java.awt.*;

public class ImageEditor1 {

    public static double luminance(Color color){
        return 0.299*color.getRed() + 0.587*color.getGreen() + 0.114*color.getBlue();
    }

    //Return a double that represents the luminance of color. This is given by the following function of color‘s red (R), green (G)
    // and blue (B) values: luminance=0.299×R+0.587×G+0.114×B.
    //To obtain the RGB values of color, you will need to call its instance methods getRed(), getGreen() and getBlue().

    public static Color toGrey(Color color){
        int grey = (int)ImageEditor1.luminance(color);
       return new Color(grey,grey,grey);
    }
    //Return a new Color object whose RGB values are all equal to the luminance of the input color. To get appropriate values,
    // round the luminance value and cast it to an int.

    public static Picture makeGreyscale(Picture pic) {
        Picture greyPic = new Picture(pic.width(),pic.height());
        for (int i = 0; i < pic.width(); i++) {
            for (int j = 0; j < pic.height(); j++) {
                greyPic.set(i,j,ImageEditor1.toGrey(pic.get(i, j)));

            }
        }
        return greyPic;
    }

    //Return a new Picture object which results from converting every pixel in pic to its greyscale equivalent.
    // Remember that a Picture is just a 2D array of Color objects, and the pixel with coordinates (i, j) is accessed via the call pic.get(i, j).

    public static void main(String[] args) {
        Picture p = new Picture("spider.jpg"); // or use any other colour image
        Picture greyscale = makeGreyscale(p);
        greyscale.show();
    }
}
