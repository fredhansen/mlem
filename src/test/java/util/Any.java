package util;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Any {

    public static String alphabetic(int min, int max){
        int i = max - min;
        return RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(i, max + 1));
    }

    public static String randomName(){
        return alphabetic(2,18);
    }

    public static Long randomLong(){
        return Math.abs(RandomUtils.nextLong());
    }

    public static int randomInt(){
        return RandomUtils.nextInt(0, 100);
    }

    public static double randomDouble(){
        return Math.round(RandomUtils.nextDouble(0, 75) * 100.0) / 100.0;
    }

    public static String randomImage() throws IOException {
        return buffered_To_String(randomImage_Buffered());
    }

    private static BufferedImage randomImage_Buffered(){
        // https://www.geeksforgeeks.org/image-processing-java-set-7-creating-random-pixel-image/
        int width = 640;
        int height = 320;

        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int a = (int)(Math.random()*256); //generating
                int r = (int)(Math.random()*256); //values
                int g = (int)(Math.random()*256); //less than
                int b = (int)(Math.random()*256); //256

                int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel

                img.setRGB(x, y, p);
            }
        }
        return img;
    }

    private static String buffered_To_String(BufferedImage bufferedImage) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("data:image/jpeg;base64,");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(randomImage_Buffered(), "jpg",baos);
        baos.flush();

        MultipartFile multipartFile = new MockMultipartFile("newFile.jpg", baos.toByteArray());
        sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(multipartFile.getBytes(),false)));
        return sb.toString();
    }
}
