import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

public class ReadTest {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a PGM file name to read: ");
        String file = sc.nextLine();
        sc.close();

        Read PGMImage = new Read(file);
        
        PGMImage.flip_vertical();

        PGMImage.save("out.pgm");
    }
}