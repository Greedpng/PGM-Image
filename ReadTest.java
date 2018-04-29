//import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class ReadTest {
    public static void main(String [] args) {
        //Scanner sc = new Scanner(System.in);
        //System.out.print("Enter a PGM file name to read: ");
        String file = "PGMtest.pgm";

        Read PGMImage = new Read (file);

        System.out.println("Magic: " + PGMImage.magic);
        System.out.println("Width: " + PGMImage.width);
        System.out.println("Height: " + PGMImage.height);
        System.out.println("Depth: " + PGMImage.depth);
        /*System.out.println("Pixels: ");
        for (int i = 0; i < PGMImage.height; i++) {
            for (int j = 0; j < PGMImage.width; j++) {
                System.out.print(PGMImage.pixels[i][j] + " ");
            }
            System.out.println();
        }*/

        PGMImage.flip_horizontal();
        System.out.println("Flipped Pixels: ");
        for (int i = 0; i < PGMImage.height; i++) {
            for (int j = 0; j < PGMImage.width; j++) {
                System.out.print(PGMImage.pixels[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//Use PrintWriter for save()
//PrintWriter writer = new PrintWriter(file);
//writer.println();