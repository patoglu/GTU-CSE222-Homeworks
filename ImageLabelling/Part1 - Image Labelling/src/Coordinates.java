public class Coordinates {
    private int x,y;

    /**
     * Default constructor for Coordinates class.
     */
    public Coordinates()
    {

    }

    /**
     * Two parameter constructor.
     * @param x X Coordinate
     * @param y Y Coordinate
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x sets the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y sets the y coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY()+")";
    }
}
