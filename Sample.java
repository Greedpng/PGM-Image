import java.util.*;

public class Sample {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a PGM file name to read: ");
        String file = sc.nextLine();

        PGM PGMImage = new PGM (file);
        PGMImage.flip_vertically();
        PGMImage.save("out.pgm");
    }
}