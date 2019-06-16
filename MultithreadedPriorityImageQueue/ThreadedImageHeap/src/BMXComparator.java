

import java.util.Comparator;

public class BMXComparator implements Comparator<MyImage>{


    /**
     * Compare method for Bitmix. It processes 3D bit to get 24 bit value, then compares between em.
     * @param o1 the left bit
     * @param o2 the right bit
     * @return the comparison result
     */
    @Override
    public int compare(MyImage o1, MyImage o2) {
        int returnVal = this.decoder(o1, o2);
        return returnVal;

    }

    /**
     * Decoder method that creates 24 bit bitmix values, then comparing them.
     * @param o1 First 3D pixel parameter
     * @param o2 Second 3D pixel parameter.
     * @return the comparison value.
     */
    private int decoder(MyImage o1, MyImage o2)
    {
        int [] firstRed = new int[8];
        int [] firstGreen = new int[8];
        int [] firstBlue = new int[8];
        int [] secondRed = new int[8];
        int [] secondGreen = new int[8];
        int [] secondBlue = new int[8];



        firstRed = BIT8(o1.getRed());
        firstGreen = BIT8(o1.getGreen());
        firstBlue = BIT8(o1.getBlue());

        secondRed = BIT8(o2.getRed());
        secondGreen = BIT8(o2.getGreen());
        secondBlue = BIT8(o2.getBlue());




        int redCounter = 0;
        int greenCounter = 0;
        int blueCounter = 0;
        int [] resultPixel1 = new int[24];
        int [] resultPixel2 = new int[24];
        int firstPixelDecimal = 0;
        int secondPixelDecimal = 0;




        for(int i = 0 ; i < 24 ; i = i + 3)
        {
            resultPixel1[i] = firstRed[redCounter];
            resultPixel1[i+1] = firstGreen[greenCounter];
            resultPixel1[i+2] = firstBlue[blueCounter];


            resultPixel2[i] = secondRed[redCounter];
            resultPixel2[i+1] = secondGreen[greenCounter];
            resultPixel2[i+2] = secondBlue[blueCounter];



            redCounter++;
            greenCounter++;
            blueCounter++;
        }

        for(int i = 0 ; i < 24 ;++i)
        {


            firstPixelDecimal +=  resultPixel1[i] * power(2,i);
            secondPixelDecimal += resultPixel2[i] * power(2,i);
        }


        if(firstPixelDecimal > secondPixelDecimal)
        {
            return 1;
        }
        else if(firstPixelDecimal < secondPixelDecimal)
        {
            return -1;
        }
        else
        {
            return 0;
        }


    }

    /**
     * Method that converts decimal value to binary value.
     * @param number is a decimal value to be converted.
     * @return the converted binary array.
     */
    private int[] BIT8(int number)
    {

        int [] array = new int[8];
        int i = 0;
        while(number > 0)
        {
            array[i] = number % 2;
            number = number / 2;
            i++;
        }

        return array;
    }

    /**
     * Recursive power method.
     * @param n is base
     * @param m is exponent
     * @return the n^m
     */
    private int power(int n, int m)
    {
        if(m == 0)
        {
            return 1;
        }
        else
        {
            return n * power(n,m-1);
        }
    }



}
