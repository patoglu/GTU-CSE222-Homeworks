

public class MyImage {
    private int red,green,blue;

    /**
     * 3 parameter constructor that initializes main colors.
     * @param first red
     * @param second green
     * @param third blue
     */
    public MyImage(int first, int second, int third)
    {
        red = first;
        green = second;
        blue = third;

    }

    /**
     * Gets the red decimal value
     * @return red's decimal value
     */
    public int getRed() {
        return red;
    }

    /**
     * Sets the Red's decimal value.
     * @param red's decimal value
     */
    public void setRed(int red) {
        this.red = red;
    }

    /**
     * Gets the green's decimal value
     * @return green's decimal value
     */
    public int getGreen() {
        return green;
    }

    /**
     * sets green's decimal value
     * @param green green's decimal value
     */
    public void setGreen(int green) {
        this.green = green;
    }

    /**
     * gets the blues decimal value
     * @return blues decimal value
     */
    public int getBlue() {
        return blue;
    }

    /**
     * sets the blues decimal value
     * @param blue decimal value of blue.
     */
    public void setBlue(int blue) {
        this.blue = blue;
    }

    /**
     *
     * @return Image properties.
     */
    @Override
    public String toString()
    {
        String s = "Red: " + this.getRed() + " Green: " + this.getGreen() + " Blue: " + this.getBlue();
        return s;

    }

}
