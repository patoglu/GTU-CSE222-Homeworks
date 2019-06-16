import java.util.Iterator;

public class Main {
    public static void main(String args[])
    {
        int[][]matrix1 = {{1,2,3,4,5},
                         {5,3,1,6,4},
                         {2,5,2,1,3},
                         {2,7,8,4,2}};


        MatrixConverter matrixConverter = new MatrixConverter(matrix1,matrix1.length, matrix1[0].length);
        matrixConverter.traverseMatrix();
        Iterator<Integer> iter =matrixConverter.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }

        int [][]matrix2 = {{1,5,6,3,2,5,3,3,5,1},
                           {2,4,5,3,2,5,7,4,2,1}};

        MatrixConverter matrixConverter2 = new MatrixConverter(matrix2, matrix2.length, matrix2[0].length);
        matrixConverter2.traverseMatrix();
        Iterator<Integer> iter2 = matrixConverter2.iterator();

        while(iter2.hasNext())
        {
            System.out.print(iter2.next() + " ");
        }


        int [][] matrix3=
                {{1,2,7,4,3,1,2,4,6,2,4,5,3,1,2,5,6,4,3,2,1},
                 {2,5,3,2,1,4,6,7,4,3,3,2,1,2,4,6,2,6,5,4,2},
                 {1,4,6,3,2,6,4,1,3,5,4,2,3,6,8,6,5,4,4,4,2},
                 {1,4,7,4,2,3,6,8,6,5,4,3,2,3,1,4,6,8,7,6,5},
                 {1,3,3,4,0,5,0,0,3,2,4,7,5,3,2,6,6,5,6,7,7},
                 {2,3,5,7,4,6,3,6,8,7,5,3,5,6,7,8,2,1,2,5,3},
                 };
        MatrixConverter matrixConverter3 = new MatrixConverter(matrix3, matrix3.length, matrix3[0].length);
        matrixConverter3.traverseMatrix();
        Iterator<Integer> iter3 = matrixConverter3.iterator();

        while(iter3.hasNext())
        {
            System.out.print(iter3.next() + " ");
        }
    }
}
