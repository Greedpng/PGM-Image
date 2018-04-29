public abstract class Image {
    //------------------//
    // Image Attributes //
    //------------------//
    protected String magic; // always p2 for this assignment
    protected int width, height, depth;

    // Accessors: getMagic(), getWidth(), etc

    // Modifiers: setMagic(string m), setWidth(int w), etc

    //--------------------//
    // Abstract Functions //
    //--------------------//
    public abstract void flip_horizontal();
    public abstract void flip_vertical();
    public abstract void rotate_right_90();
}