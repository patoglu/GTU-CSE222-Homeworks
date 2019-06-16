import java.util.Comparator;

public class EUCComparator implements Comparator<MyImage> {
    /**
     * Euclidian norm comparison.
     * @param o1 left 3D bit
     * @param o2 right 3Dbit
     * @return the comparison result
     */
    @Override
    public int compare(MyImage o1, MyImage o2) {
        double firstPixelNorm;
        double secondPixelNorm;
        firstPixelNorm = o1.getBlue() * o1.getBlue() + o1.getRed() * o1.getRed() + o1.getGreen() * o1.getGreen();
        secondPixelNorm = o2.getBlue() * o2.getBlue() + o2.getRed() * o2.getRed() + o2.getGreen() * o2.getGreen();
        firstPixelNorm = Math.sqrt(firstPixelNorm);
        secondPixelNorm = Math.sqrt(secondPixelNorm);

        if(firstPixelNorm > secondPixelNorm)
        {
            return 1;
        }
        else if(firstPixelNorm < secondPixelNorm)
        {
            return -1;
        }
        else
        {
            return 0;
        }

    }

}
