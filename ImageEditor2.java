import java.awt.*;

public class ImageEditor2 {
    public static Picture threshold(Picture p, int thresh){
        Picture newPic = new Picture(p.width(),p.height());
        for (int i = 0; i < p.width(); i++) {
            for (int j = 0; j < p.height(); j++) {
                Color pixel = p.get(i,j);

                if(ImageEditor1.luminance(pixel)<thresh) {
                    newPic.set(i, j, Color.BLACK);
                }else{
                    newPic.set(i,j,ImageEditor1.toGrey(p.get(i, j)));

                }

            }
        }
        return newPic;
    }

    public static void main(String[] args) {
        Picture p = new Picture("spider.jpg"); // or use any other colour image
        Picture greyscale = threshold(p, 90);
        greyscale.show();
    }
}
