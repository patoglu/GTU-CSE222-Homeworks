

import java.util.Comparator;

public class LEXComparator implements Comparator<MyImage>{

    /**
     * Simple lexicographical comparison method.
     * @param o1 is left 3D pixel value
     * @param o2 is right 3D pixel value
     * @return comparison value
     */
    @Override
    public int compare(MyImage o1, MyImage o2) {
        if(o1.getRed() > o2.getRed())
        {
            return 1;
        }
        else if(o1.getRed() < o2.getRed())
        {
            return -1;
        }
        else
        {
            if(o1.getGreen() > o2.getGreen())
            {
                return 1;
            }
            else if(o1.getGreen() < o2.getGreen())
            {
                return -1;
            }
            else
            {
                if(o1.getBlue() > o2.getBlue())
                {
                    return 1;
                }
                else if(o1.getBlue() < o2.getBlue())
                {
                    return -1;
                }
                else
                {
                    return 0;
                }

            }
        }
    }




}
