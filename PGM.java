import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;

public class PGM extends Image {
    int [][] pixels;

    // Default Constructor
    public PGM() {

    }

    // Overloading Constructor
    public PGM(String file) {
        File in = new File(file);

        try {
            Scanner sc = new Scanner(in);

            this.magic = sc.nextLine();
            this.width = sc.nextInt();
            this.height = sc.nextInt();
            this.depth = sc.nextInt();

            this.pixels = new int[height][width];
            for (int i = 0; i < this.height; i++) {
                for (int j = 0; j < this.width; j++) {
                    this.pixels[i][j] = sc.nextInt();
                }
            }

            sc.close();
        } catch(FileNotFoundException exp) {
            System.out.println("Error " + exp.toString());
        }
    }

    //-----------//
    // Accessors //
    //-----------//
    public String getMagic() {return this.magic;}
    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}
    public int getDepth() {return this.depth;}
    public int[][] getPixels() {return this.pixels;}

    //-----------//
    // Modifiers //
    //-----------//
    public void setMagic(String s) {this.magic = s;}
    public void setWidth(int i) {this.width = i;}
    public void setHeight(int i) {this.height = i;}
    public void setDepth(int i) {this.depth = i;}
    public void setPixels() {
        Scanner px = new Scanner(System.in);

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print("Next Pixel: ");
                this.pixels[i][j] = px.nextInt();
            }
        }

        px.close();
    }

    //-------------------//
    // Editing Functions //
    //-------------------//
    public void flip_horizontally() {
        int temp;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width / 2; j++) {
                temp = this.pixels[i][j];
                this.pixels[i][j] = this.pixels[i][this.width - 1 - j];
                this.pixels[i][this.width - 1 - j] = temp;
            }
        }
    }

    public void flip_vertically() {
        int temp;
        for (int i = 0; i < this.height / 2; i++) {
            for (int j = 0; j < this.width; j++) {
                temp = this.pixels[i][j];
                this.pixels[i][j] = this.pixels[this.height - 1 - i][j];
                this.pixels[this.height - 1 -i][j] = temp;
            }
        }
    }

    public void rotate_right_90() {
        int m = this.height;
        int n = this.width;
        int[][] rotatedArray = new int[n][m];
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArray[j][m-i-1] = this.pixels[i][j];
            }
        }

        int temp = this.height;
        this.height = this.width;
        this.width = temp;
        this.pixels = rotatedArray;
    }

    public void save(String file) {
        File in = new File(file);

        try {
            PrintWriter writer = new PrintWriter(in);
            
            writer.println(this.magic);
            writer.println(this.height + " " + this.depth);
            writer.println(this.depth);

            for (int i = 0; i < this.height; i++) {
                for (int j = 0; j < this.width; j++) {
                    writer.print(this.pixels[i][j]);
                    if (j < this.width - 1) {
                        writer.print(" ");
                    }
                }
                if (i < this.height - 1) {
                    writer.println();
                }
            }
            writer.close();
        } catch(FileNotFoundException exp) {
            System.out.println("Error " + exp.toString());
        }
    }
}